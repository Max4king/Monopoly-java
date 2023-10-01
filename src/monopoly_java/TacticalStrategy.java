/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopoly_java;

/**
 *
 * @author work
 */
public class TacticalStrategy implements PlayerStrategy {
    int turn;
    public TacticalStrategy() {
        turn = 0;
    }
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
    public boolean strategyCondition() {
        return turn % 2 == 0;
    }
}
