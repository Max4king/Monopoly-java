/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import java.io.File;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.Scanner;
import java.io.StringReader;
import monopoly_java.*;
import java.util.ArrayList;
public class MonopolyJavaTest {

    @Before
    public void setUp() {
        // Initialization code, if needed
    }

    @Test
    public void testCreateBoard() throws Exception {
        String input = "3\nproperty\nlucky 2000\nservice 10000\n";
        Scanner scanner = new Scanner(new StringReader(input));
        List<Field> board = MonopolyJava.createBoard(scanner);

        assertEquals(3, board.size());
        assertTrue(board.get(0) instanceof Property);
        assertTrue(board.get(1) instanceof LuckyField);
        assertTrue(board.get(2) instanceof ServiceField);
    }

    @Test
    public void testCreatePlayers() throws Exception {
        String input = "2\nAlice greedy\nBob careful\n";
        Scanner scanner = new Scanner(new StringReader(input));
        List<Player> players = MonopolyJava.createPlayers(scanner);

        assertEquals(2, players.size());
        assertEquals("Alice", players.get(0).getName());
        assertEquals("Bob", players.get(1).getName());
        assertTrue(players.get(0).getStrategy() instanceof GreedyStrategy);
        assertTrue(players.get(1).getStrategy() instanceof CarefulStrategy);
    }

    @Test
    public void testPlayGame() {
        // Mock your board and players
        List<Field> board = new ArrayList<>();
        board.add(new Property(0));
        board.add(new LuckyField(2000));
        board.add(new ServiceField(10000));

        List<Player> players = new ArrayList<>();
        players.add(new Player("Alice", new GreedyStrategy()));
        players.add(new Player("Bob", new CarefulStrategy()));

        // Call your playGame method
        MonopolyJava.playGame(board, players);

        // Perform assertions
        assertEquals(1, players.size());
    }
    
    @Test
    public void testCannotBuyOwnedProperty() {
        // Mock your board and players
        Property prop = new Property(0);

        List<Player> players = new ArrayList<>();
        Player alice = new Player("Alice", new GreedyStrategy());
        Player bob = new Player("Bob", new CarefulStrategy());
        players.add(alice);
        players.add(bob);

        try {
        prop.setOwner(alice); // Alice owns the property
        } catch (PropertyAlreadyOwned e) {
            // Handle exception (in this case, you might not expect an exception here)
            fail("Unexpected exception: " + e.getMessage());
        }
        assertThrows(PropertyAlreadyOwned.class, () -> {
        prop.setOwner(bob);
    });
        // Check
        assertEquals(alice, prop.getOwner()); // Property should still be owned by Alice
    }
    
    @Test
    public void testPlayerLosesAfterNoMoney() {
        // Mock your board and players
        List<Field> board = new ArrayList<>();
        board.add(new Property(0));
        board.add(new ServiceField(10000)); // Expensive service field

        List<Player> players = new ArrayList<>();
        Player alice = new Player("Alice", new GreedyStrategy());
        Player bob = new Player("Bob", new CarefulStrategy());
        alice.setMoney(5000); // Not enough money to pay for the service
        players.add(alice);
        players.add(bob);

        // Call playGame with a dice roll that lands Alice on the service field
        Scanner diceRollScanner = new Scanner("1 2 2");
        MonopolyJava.playGameTest(board, players, diceRollScanner);

        // Perform assertions
        assertEquals(1, players.size()); // Alice should be removed from the game
    }

}

