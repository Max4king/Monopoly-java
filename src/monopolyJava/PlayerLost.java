/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopolyJava;

/**
 *
 * @author work
 */
public class PlayerLost extends Exception {
    public PlayerLost(String name) {
        super("Player "+ name +"have losted");
    }
}
