/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopoly.java;

/**
 *
 * @author work
 */
public class Bank extends Player {
    public Bank() {
        super();
    }
    
    @Override
    public boolean pay(Player player, int amount) {
        player.receive(amount);
        return true;
    }
}
