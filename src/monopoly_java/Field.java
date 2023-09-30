/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopoly_java;

/**
 *
 * @author work
 */
public class Field {
    private int value;
    public int getValue() {
        return value;
    }
    protected  void setValue(int value) {
        this.value = value;
    } 
    
    public void fieldAct(Player player) {
        try {
            this.evaluate(player);   
        }
        catch (Exception e) {
            System.out.println(player.getName() + " don't have enough money.");
        }
    }
    // Responsible 
    public void evaluate(Player player) throws Exception {
        player.pay(value);
    }
}
