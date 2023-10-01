/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopoly_java;

/**
 *
 * @author work
 */
public class Property extends Field {
    protected Player Owner;
    protected boolean House;
    protected int housePrice = 4_000;
    public Property() {
        this.setValue(1_000);
        House = false;
        
    }
    public static final String ANSI_RESET = "\u001B[0m";
    
    public static final String ANSI_COLOR = "\u001B[34m";
    
    @Override
    public int getValue() {
        return (House) ? 2000 : 500;
    }
    
    public int totalCost() { return (House) ? value + housePrice : value; }
    
    public int buyPrice() { return value;}
    
    public int buyHouseP() { return housePrice;}
    
    public boolean isForSale() {return Owner == null;} 
    
    public void setOwner(Player player) throws PropertyAlreadyOwned {
        if (Owner != null) {
            throw new PropertyAlreadyOwned();
        }
        Owner = player;
    }
    public Player getOwner() {return Owner;}
    
    public void removeOwner() {
        Owner = null;
    }
    public void addHouse(Player player) throws NotEnoughMoney,AlreadyHoused {
        if (House) {
            throw new AlreadyHoused();
        }
        player.pay(housePrice);
        System.out.println(ANSI_COLOR + "-----------"+ player.getName() + " Add a House."+"-----------" + ANSI_RESET);

        House = true;
    }
    public boolean haveHouse() {return House;}
    
}
