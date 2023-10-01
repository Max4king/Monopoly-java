/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package monopoly_java;

/**
 * The PlayerStrategy interface defines a single method for executing a strategy
 * during a player's turn in the game.
 * @author Ryan Supawarapong
 * @version 1
 */
public interface PlayerStrategy {
    /**
     *  Executes the player strategy base on the field they are on. It will be
     * determine by implement class.
     * @param player
     * @param field 
     */
    void execute(Player player, Field field);
}
