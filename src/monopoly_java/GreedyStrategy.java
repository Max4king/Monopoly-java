/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopoly_java;

/**
 *
 * @author work
 */
public class GreedyStrategy implements PlayerStrategy {
    public void execute(Player player, Field field) {
        if (field instanceof Property && ((Property) field).isForSale()) {
            player.buy((Property) field);
    }
}
}