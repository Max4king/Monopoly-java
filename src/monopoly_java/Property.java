/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopoly_java;

/**
 * The Property class represents a property field in the Monopoly game.
 * It extends the Field class and holds information about the ownership and house status of the property.
 *  
 * @author Ryan Supawarapong
 */
public class Property extends Field {
    protected Player Owner;
    protected boolean House;
    protected int housePrice = 4_000;
    
    /**
     * Initializes a new instance of the Property class.
     */
    public Property() {
        this.setValue(1_000);
        House = false;
        
    }
    public static final String ANSI_RESET = "\u001B[0m";
    
    public static final String ANSI_COLOR = "\u001B[34m";
    
    
    /**
     * @return The rental value of this property, which is higher if a house is built on it.
     */
    @Override
    public int getValue() {
        return (House) ? 2000 : 500;
    }
    
    /**
     * @return The total cost of this property, including the cost of a house if one is built.
     * Helps when selling the property.
     */
    public int totalCost() { return (House) ? value + housePrice : value; }
    
    /**
     * @return The purchase price of this property.
     */
    public int buyPrice() { return value;}
    
    /**
     * @return The purchase price of a house for this property.
     */ 
    public int buyHouseP() { return housePrice;}
    
    /**
     * @return true if this property is available for purchase, false otherwise.
     */
    public boolean isForSale() {return Owner == null;} 
    
    /**
     * Sets the owner of this property to the specified player.
     *
     * @param player The new owner.
     * @throws PropertyAlreadyOwned if the property is already owned.
     */
    public void setOwner(Player player) throws PropertyAlreadyOwned {
        if (Owner != null) {
            throw new PropertyAlreadyOwned();
        }
        Owner = player;
    }
    
    /**
     * @return The player who owns this property.
     */
    public Player getOwner() {return Owner;}
    
    /**
     * Removes the current owner of this property.Used when selling the property.
     */
    public void removeOwner() {
        Owner = null;
    }
    
    /**
     * Adds a house to this property if there isn't one already.
     *
     * @param player The player who is adding the house.
     * @throws NotEnoughMoney if the player cannot afford to add a house.
     * @throws AlreadyHoused if a house is already built on this property.
     */
    public void addHouse(Player player) throws NotEnoughMoney,AlreadyHoused {
        if (House) {
            throw new AlreadyHoused();
        }
        player.pay(housePrice);
        System.out.println(ANSI_COLOR + "-----------"+ player.getName() + " Add a House."+"-----------" + ANSI_RESET);

        House = true;
    }
    /**
     * @return true if a house is built on this property, false otherwise.
     */
    public boolean haveHouse() {return House;}
    
}
