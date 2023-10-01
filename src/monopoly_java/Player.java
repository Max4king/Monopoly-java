/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopoly_java;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author work
 */
public class Player {
    private int money;
    private String name;
    protected List<Property> properties = new ArrayList<>();
    protected PlayerStrategy strategy;
    private int turn_count;
    private int position;
    private boolean alive;
    public Player(String name, PlayerStrategy strategy) {
        this.name = name;
        this.money = 10_000;
        this.turn_count = 0;
        this.strategy = strategy; 
        this.position = 0;
        this.alive = true;
    }
    public List<Property> getProperites() { return properties;}
    
    public boolean getAlive() {return alive;}
    
    public void setPosition(int position) { this.position = position;}
    
    public int getPosition() { return position;}
    
    public String getName() { return name;}
    
    public void pay(int amount) throws NotEnoughMoney {
        if (!this.canPay(amount)) {
            throw new NotEnoughMoney();
        }
        System.out.println(name + " payed " + amount);
        money -= amount;
    }
    public void forcedPay(int amount) throws PlayerLost {
        System.out.println(name + " force to pay " + amount);
        if (!this.canPay(amount)) {
            System.out.println(name + " doesn't have enough money.");
            this.sellProperty(amount);
             if (!this.canPay(amount)) {
                 alive = false;
                 throw new PlayerLost(name);
             }
        }
        System.out.println(name + " payed " + amount);
        money -= amount;
    }
    public int getMoney() {return money; }
    
    public boolean canPay(int amount) {
        if (money < amount) {
            return false;
        }
        return true;
    }
    
    public void sellProperty(int debt) {
        while (debt > money) {
            System.out.println(name + " tries to sell property for money.");
            if (properties.isEmpty()) {
                System.out.println(name + " has no property left.");
                return;
            }
            Property propertyToSell = properties.get(0);
            if (propertyToSell.haveHouse()) {
                
            }
            int salePrice = propertyToSell.getValue();
            money += salePrice;
            properties.remove(0);
        }
    }
    public void buy(Property property) {
        try {
            System.out.println(name + " tries to buy " + property.getClass().getSimpleName());
            this.pay(property.buyPrice());  // Pay the ~~bank~~ game.
            property.setOwner(this);  // Update property owner
            this.properties.add(property);  // Add property to player's list
            System.out.println("Property Bought!");
        } catch(NotEnoughMoney e) {
            System.out.println("Not Enough Money!");
        } catch(PropertyAlreadyOwned e) {
            System.err.println(name + " tried to buy already own property.");
            this.receive(property.buyPrice());
        }
    }
    
    public void action(Field field) {
        System.out.println(name + " turns to act.");
        strategy.execute(this, field);
    }
    
    public void receive(int amount) {
        System.out.println(name + " receives " + amount);
        money += amount;
    }
    
    
}
