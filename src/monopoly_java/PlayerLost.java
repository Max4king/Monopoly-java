/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopoly_java;

/**
 * PlayLost class represents an exception thrown when
 * a player has lost due to not having enough money to pay
 *  for something
 * @author Ryan Supawarapong
 */
public class PlayerLost extends Exception {
    
    /**
     * Constructs a new PlayerLost exception with a default message indicating
     * that a player has lost.
     */
    public PlayerLost(String name) {
        super("Player "+ name +" have losted");
    }
}
