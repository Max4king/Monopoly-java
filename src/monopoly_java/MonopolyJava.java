/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package monopoly_java;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
/**
 *
 * @author work
 */
public class MonopolyJava {

    /**
     * @param args the command line arguments
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
    public static List<Field> createBoard(Scanner scanner) {
        int numFields = scanner.nextInt();
        scanner.nextLine();  // Consume the newline
        List<Field> board = new ArrayList<>();
        for (int i = 0; i < numFields; i++) {
            String[] fieldInfo = scanner.nextLine().split(" ");
            if (fieldInfo[0].equals("property")) {
                board.add(new Property()); }
//            } else if (fieldInfo[0].equals("lucky")) {
//                int amount = Integer.parseInt(fieldInfo[2]);
//                board.add(new LuckyField(amount));
//            } else if (fieldInfo[0].equals("service")) {
//                int cost = Integer.parseInt(fieldInfo[1]);
//                board.add(new ServiceField(cost));
//            }
        }
        return board;
    }   
        
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
                throw new Exception("Strategy '"+ strategyType+ "' not found for player " + name + ".");
            }
            players.add(new Player(name, strategy));
            }
            catch(Exception e) {
                System.err.println("Error:" + e.getMessage());
            }
        }
        return players;

    }
    public static void playGame(List<Field> board, List<Player> players) {
        List<Player> playersToRemove = new ArrayList<>();
        while (players.size() > 1) {
            for (Player player : players) {
                int diceroll = 1;
                int newPosition = (player.getPosition() + diceroll) % board.size();
                player.setPosition(newPosition);
                Field currentField = board.get(newPosition);
                System.out.println(player.getName() + " lands on " + currentField.getClass().getSimpleName() + " at " + newPosition);  // Assume a getDescription method in Field class
                player.action(currentField);
                if (!player.getAlive()) {
                    playersToRemove.add(player);
                }
            }
            players.removeAll(playersToRemove);  
            
        }
        if (players.size() == 1) {
                System.out.println(players.get(0).getName() + " Won!!!!");
            }
        else 
            System.err.println("Something went wrong.");
        }
    }
}
