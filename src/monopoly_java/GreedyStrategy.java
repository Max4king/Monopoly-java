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
        try {
            if (field instanceof Property) {
                Property prop = ((Property) field);
                if(prop.isForSale()) {
                    player.buy((Property) field);
                } else if (prop.getOwner() == player) {
                    try {
                        prop.addHouse(player);
                    } catch (NotEnoughMoney e) {
                        System.out.println(e);
                    } catch(AlreadyHoused e) {
                        System.out.println(e);
                    }

                } else {
                    player.forcedPay(prop.getValue());
                    prop.getOwner().receive(prop.getValue());
                }
            } 
        }
        catch (PlayerLost e) {
                    System.out.println(e);
        }
            
    }
}
    