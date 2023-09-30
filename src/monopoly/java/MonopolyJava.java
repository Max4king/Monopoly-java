/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package monopoly.java;
import java.util.*;

/**
 *
 * @author work
 */
public class MonopolyJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Bank bank = new Bank();
        Player player1 = new Player("Bob");
        List<Field> board = new ArrayList<>();
        for (int i=0; i < 3; i++) {
            Property field = new Property();
            board.add(field);
        }
        int step = 8;
        int cnt = 0;
        while (step != 0) {
            cnt++;
            for(Field block : board) {
                if (step <= 0) {
                    break;
                }
                System.out.println("Processing...");
                player1.action(block);
                step -= 1;
            }
            System.out.println(cnt + " one done.");
        }
        
        
    }
    
}
