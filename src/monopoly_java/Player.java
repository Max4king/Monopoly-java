/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopoly_java;
import java.util.ArrayList;
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
    private int position;
    public Player(String name, PlayerStrategy strategy) {
        this.name = name;
        this.money = 10_000;
        this.turn_count = 0;
        this.strategy = strategy; 
        this.position = 0;
    }
    public void setPosition(int position) { this.position = position;}
    
    public int getPosition() { return position;}
    
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
