/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopoly_java;

/**
 * The TacticalStrategy class implements the PlayerStrategy interface to provide
 * a specific behavior to a player. In this strategy, the player acts on certain
 * turns based on whether the turn count is even.
 *
 * @author Ryan Supawarapong
 */
public class TacticalStrategy implements PlayerStrategy {
    int turn;
    /**
     * Initializes a new instance of the TacticalStrategy class with the turn count set to 0.
     */
    public TacticalStrategy() {
        turn = 0;
    }
    
    /**
     * Executes the tactical strategy for a player on a given field.
     * @param player The player to execute the strategy for.
     * @param field The field the player is currently on.
     */
    public void execute(Player player, Field field) {
        try {
            if (field instanceof Property) {
                Property prop = ((Property) field);
                if(prop.isForSale() && strategyCondition() ) {
                    player.buy((Property) field);
                } else if (prop.getOwner() == player  && strategyCondition()) {
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
        turn += 1;
            
    }
    
    /**
     * Checks whether the strategy conditions are met for making a move.
     * This is the factor to help determine the strategy.
     * @return True if the current turn count is even; otherwise, false.
     */
    public boolean strategyCondition() {
        return turn % 2 == 0;
    }
}
