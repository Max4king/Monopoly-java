/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopoly.java;
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
    
    public void pay(int amount) throws Exception {
        if (money < amount) {
            throw new Exception("Not Enough Money");
        }
        money -= amount;
    }
    public void payBank(int amount) throws NotEnoughMoney {
        if (money < amount) {
            throw new NotEnoughMoney();
        }
        money -= amount;
    }
    public void buy(Property property) {
        try {

            this.payBank(property.getValue());
            property.setOwner(this);
            System.out.println("Property Bought!");
        }
        catch(NotEnoughMoney e) {
            System.out.println("Not Enough Money!");
        }
        catch(PropertyAlreadyOwned e){
            System.out.println("Someone already own this property.");
        }
    }
    public void action(Field block) {
        if (block.getClass().getSimpleName().equals("Property")) {
            this.buy(((Property) block));
        }
    }
    
    public void receive(int amount) {
        money += amount;
    }
    
    
}
