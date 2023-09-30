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
//        Player player1 = new Player("Bob");
        List<Property> fields = new ArrayList<>();
        for (int i=0; i < 3; i++) {
            Property field = new Property();
            fields.add(field);
        }
        Iterator itr=fields.iterator();  
        while(itr.hasNext()){  
        System.out.println(itr.next());  
        }
        System.out.println("First one done.");
        while(itr.hasNext()){  
        System.out.println(itr.next());  
        }  
        
    }
    
}
