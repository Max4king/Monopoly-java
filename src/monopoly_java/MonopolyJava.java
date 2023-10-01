/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package monopoly_java;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.Math;
/**
 * 
 *  The MonopolyJava class encapsulates the main logic and flow of a simplified Monopoly game.
 *  It contains methods to set up the game board, create players, play the game, and display a leaderboard.
 *
 * @author Ryan Supawarapong
 * @version V1.1 
 */
public class MonopolyJava {

    /**
     * ANSI escape code for resetting color.
     */
    public static final String ANSI_RESET = "\u001B[0m";
    
    /**
     * ANSI escape code for green color.
     */
    public static final String ANSI_COLOR = "\u001B[32m";
    
    /**
     * ANSI escape code for yellow color.
     */
    public static final String ANSI_COLOR2 = "\u001B[33m";
    
    /**
     * ANSI escape code for cyan color.
     */
    public static final String ANSI_COLOR3 = "\u001B[36m";
    
    /**
     * The main method for the MonopolyJava class.
     * It initializes the game board and players, then starts the game.
     *
     * @param args the command-line arguments (not used)
     */
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            List<Field> board = createBoard(scanner);
            List<Player> players = createPlayers(scanner);
            playGame(board, players);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    /**
     * The createBoard method for the MonopolyJava class.
     * It initializes the game board of the game.
     *
     * @param scanner the Scanner takes input data
     * @returns a List of Fields to be the game board
     * @throws Exception if an invalid field type is encountered
     */
    
    public static List<Field> createBoard(Scanner scanner) throws Exception {
        int numFields = scanner.nextInt();
        scanner.nextLine();  // Consume the newline
        List<Field> board = new ArrayList<>();
        try {
            for (int i = 0; i < numFields; i++) {
                String[] fieldInfo = scanner.nextLine().split(" ");
                if (fieldInfo[0].equals("property")) {
                    board.add(new Property());
                } else if (fieldInfo[0].equals("lucky")) {
                    int amount = Integer.parseInt(fieldInfo[1]);
                    board.add(new LuckyField(amount));
                } else if (fieldInfo[0].equals("service")) {
                    int cost = Integer.parseInt(fieldInfo[1]);
                    board.add(new ServiceField(cost));
                } else {
                    throw new Exception("Invalid field.");
                }
            }
        } catch (NumberFormatException e) {
            System.err.println("The second input must be a number for lucky field and service.");
        } catch(Exception e) {
            throw new Exception("Invalid field.");
        }
        return board;
    }   
    
    /**
     * Creates a list of players based on input from a Scanner.
     *
     * @param scanner the Scanner takes input data
     * @return a List of Player objects representing the players
     * @throws Exception if an invalid strategy type is encountered
     */
    
    public static List<Player> createPlayers(Scanner scanner) throws Exception {
        int numPlayers = scanner.nextInt();
        scanner.nextLine();  // Consume the newline
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < numPlayers; i++) {
            String[] playerInfo = scanner.nextLine().split(" ");
            String name = playerInfo[0];
            String strategyType = playerInfo[1].toLowerCase();
            PlayerStrategy strategy = null;
            try {
            if (strategyType.equals("greedy")) {
                strategy = new GreedyStrategy(); 
            } else if(strategyType.equals("tactical")) {
                strategy = new TacticalStrategy();
            } else if(strategyType.equals("careful")) {
                strategy = new CarefulStrategy();
            }
            else {
                throw new Exception("Strategy '"+ strategyType + "' not found for player " + name + ".");
            }
            players.add(new Player(name, strategy));
            }
            catch(Exception e) {
                System.err.println("Error:" + e.getMessage());
            }
        }
        return players;
    
    }
    
    /**
     *  This is the Main game loop, where to player takes turn rolling the dice 
     *  and interact with field they land on til only one lives.
     * @param board the game board
     * @param players  the collection of player
     */
    
    public static void playGame(List<Field> board, List<Player> players) {
        List<Player> playersToRemove = new ArrayList<>();
        while (players.size() > 1) {
            for (Player player : players) {
                int max = 12;
                int min = 2;
                int diceroll = (int)Math.floor(Math.random() * (max - min + 1) + min);
                int newPosition = (player.getPosition() + diceroll) % board.size();
                player.setPosition(newPosition);
                Field currentField = board.get(newPosition);
                System.out.println(ANSI_COLOR3 + player.getName() + " rolls a " + diceroll + ANSI_RESET);
                System.out.println(player.getName() + " lands on " + currentField.getClass().getSimpleName() + " at " + (newPosition+1) );  // Assume a getDescription method in Field class
                player.action(currentField);
                if (!player.getAlive()) {
                    playersToRemove.add(player);
                    System.out.println(ANSI_COLOR2 + player.getName() + " is out!" + ANSI_RESET);
                }
            }
            leaderBoard(players);
            players.removeAll(playersToRemove);
            
            
        }
        if (players.size() == 1) {
                System.out.println(ANSI_COLOR + players.get(0).getName() + " Won!!!!"+ ANSI_RESET);
            }
        else  {
             
            System.err.println("Something went wrong.");
        }
    }
    /**
     *  An quality of life to see player current status.
     * 
     * @param players the list of active player
     */
    
    public static void leaderBoard(List<Player> players) {
        System.out.println("----------------------------------------");
        System.out.println("-------------LeaderBoard----------------");
        for (Player player : players) {
            System.out.println("Name: " + player.getName());
            System.out.println("Money: " + player.getMoney());
            System.out.println("Properties: " + player.getProperites().size());
        }
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");
        
    }
}
