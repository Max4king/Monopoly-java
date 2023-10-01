/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopoly_java;

/**
 * The GreedyStrategy class implements the PlayerStrategy interface to define a specific behavior for players
 * following a greedy strategy in the Monopoly game. In this strategy, players will always attempt to buy
 * properties that can be bought and add houses to their owned properties whenever possible.
 *
 * @author Ryan Supawarapong
 */
public class GreedyStrategy implements PlayerStrategy {
    
    /**
     * Executes the greedy strategy for a given player on a given field.
     * If the field is a property:
     * - Buys the property if it's for sale.
     * - Adds a house if the property is owned by the player and the player can afford it.
     * - Pays the rent if the property is owned by another player.
     * If the field is a ServiceField or a LuckyField, the player pays or receives the respective amount.
     *
     * @param player The player executing the strategy.
     * @param field The field the player lands on.
     */
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
                        System.out.println(e.getMessage());
                    }

                } else if (prop.getOwner() instanceof Player) {
                    player.forcedPay(prop.getValue());
                    prop.getOwner().receive(prop.getValue());
                }
            } else if (field instanceof ServiceField) {
                player.forcedPay(field.getValue());
            } else if (field instanceof LuckyField) {
                player.receive(field.getValue());
            } else {
                System.err.println("Nonexisting field. How did this tile get here?");
                throw new Exception("Check Failure");
            }
        }
        catch (PlayerLost e) {
                    System.out.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("There seems to be an uncaught error.");
        }
            
    }
}
    