/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopoly_java;

/**
 * The CarefulStrategy class implements the PlayerStrategy interface to provide a specific
 * behavior for a player in the game. In this strategy, a player is cautious and ensures
 * that they retain at least half of their money when making a purchase or building a house.
 * This strategy also defines how a player interacts with different types of fields on the board.
 *
 * @author Ryan Supawarapong
 */

public class CarefulStrategy implements PlayerStrategy {
    /**
     * Executes the careful strategy for a given player on a given field. The player's actions
     * depend on the type of field they land on and their current financial situation.
     * 
     * @param player The player who is executing this strategy.
     * @param field The field on which the player has landed.
     */
    public void execute(Player player, Field field) {
        try {
            if (field instanceof Property) {
                Property prop = ((Property) field);
                if(prop.isForSale() && this.strategyCondition(player ,prop.getValue()) ) {
                    player.buy((Property) field);
                } else if (prop.getOwner() == player && this.strategyCondition(player, prop.buyHouseP())) {
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
    public boolean strategyCondition(Player player, int amount) {
        return ( player.getMoney() - amount ) > player.getMoney()/2;
    }
    
}
