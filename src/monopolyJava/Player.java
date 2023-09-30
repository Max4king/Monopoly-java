/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopolyJava;
import java.util.ArrayList;
import monopoly.java.NotEnoughMoney;
/**
 *
 * @author work
 */
public class Player {
    private int money;
    private String name;
    private ArrayList<Property> properties = new ArrayList<>();
    protected PlayerStrategy strategy;
    private int turn_count;
    public Player(String name, PlayerStrategy strategy) {
        this.name = name;
        this.money = 10_000;
        this.turn_count = 0;
        this.strategy = strategy; 
    }
    public Player() {
        this.name = "Bank";
        this.money = 0;
    }
    
    public String getName() { return name;}
    
    public void pay(int amount) throws NotEnoughMoney {
        if (money < amount) {
            throw new NotEnoughMoney();
        }
        money -= amount;
    }
    public void forcedPay(int amount) throws NotEnoughMoney {
        if (money < amount) {
            
        }
        money -= amount;
    }
    
//    public void sellProperty(int debt) {
//        
//        for()
//    }
    public void buy(Property property) {
    if (!property.isForSale()) {
        try {
            this.forcedPay(property.getValue()); // Pay the owner
            property.getOwner().receive(property.getValue()); // Owner receives money
        } catch (Exception e) {
            System.out.println("Not enough money to pay the owner.");
        }
        return;
    }
    try {
        this.pay(property.getValue());  // Pay the bank
        property.setOwner(this);  // Update property owner
        this.properties.add(property);  // Add property to player's list
        System.out.println("Property Bought!");
    } catch(NotEnoughMoney e) {
        System.out.println("Not Enough Money!");
    }
}

    
    public void receive(int amount) {
        money += amount;
    }
    
    
}
