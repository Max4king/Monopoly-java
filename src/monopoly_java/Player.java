/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopoly_java;
import java.util.ArrayList;
import java.util.List;
/**
 * The Player class encapsulates the information and actions associated with a player in the Monopoly game.
 * This includes their money, properties, position on the board, and the strategy they employ during the game.
 *
 * @author Ryan Supawarapong 
 */
public class Player {
    private int money;
    private String name;
    protected List<Property> properties = new ArrayList<>();
    protected PlayerStrategy strategy;
    private int turn_count;
    private int position;
    private boolean alive;
    /**
     * Constructor for the Player class.
     *
     * @param name The name of the player.
     * @param strategy The strategy employed by the player.
     */
    public Player(String name, PlayerStrategy strategy) {
        this.name = name;
        this.money = 10_000;
        this.turn_count = 0;
        this.strategy = strategy; 
        this.position = 0;
        this.alive = true;
    }
    /**
     * @return A list of properties owned by the player.
     */
    public List<Property> getProperites() { return properties;}
    
    /**
     * 
     * @return A flag whether the player is still in the game or not
     */
    public boolean getAlive() {return alive;}
    
    /**
     *  set the Player's position on othe board
     * @param position The new Position
     */
    public void setPosition(int position) { this.position = position;}
    
    /**
     * 
     * @return the player position
     */
    public int getPosition() { return position;}
    
    /**
     * 
     * @return the player name
     */
    public String getName() { return name;}
    
    /**
     * Deducts a specified amount of money from the player's total.
     *
     * @param amount The amount to be paid.
     * @throws NotEnoughMoney if the player does not have enough money.
     */
    public void pay(int amount) throws NotEnoughMoney {
        if (!this.canPay(amount)) {
            throw new NotEnoughMoney();
        }
        System.out.println(name + " payed " + amount);
        money -= amount;
    }
    
    /**
     * Forces the player to pay a specified amount, selling properties if necessary.
     *
     * @param amount The amount to be paid.
     * @throws PlayerLost if the player cannot cover the amount even by selling properties.
     */
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
    /**
     * @return The amount of money the player has.
     */
    
    public int getMoney() {return money; }
    
    /**
     * Checks if the player has enough money to cover a specified amount.
     *
     * @param amount The amount to check against.
     * @return true if the player has enough money, false otherwise.
     */
    public boolean canPay(int amount) {
        if (money < amount) {
            return false;
        }
        return true;
    }
    
    /**
     * Attempts to sell properties to cover a specified debt amount.
     *
     * @param debt The amount the player needs to cover.
     */
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
    
    /**
     * Attempts to buy a specified property.
     *
     * @param property The property the player wants to buy.
     */
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
    /**
     * Executes the player's action of the interface on a specified field
     * with the strategy of the player.
     *
     * @param field The field the player is acting on.
     */
    public void action(Field field) {
        System.out.println(name + " turns to act.");
        strategy.execute(this, field);
    }
    /**
     * Increases the player's money by a specified amount
     *
     * @param amount The amount to be received.
     */
    public void receive(int amount) {
        System.out.println(name + " receives " + amount);
        money += amount;
    }
    
    
}
