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
                if(prop.isForSale() && turn % 2 == 0) {
                    player.buy((Property) field);
                } else if (prop.getOwner() == player  && turn % 2 == 0) {
                    try {
                        prop.addHouse(player);
                    } catch (NotEnoughMoney e) {
                        System.out.println(e);
                    } catch(AlreadyHoused e) {
                        System.out.println(e);
                    }

                } else if (prop.getOwner().getClass().getSimpleName().equals("Player")) {
                    player.forcedPay(prop.getRent());
                    prop.getOwner().receive(prop.getRent());
                }
            } // other field check here
        }
        catch (PlayerLost e) {
                    System.out.println(e);
        }
        turn += 1;
            
    }
}
