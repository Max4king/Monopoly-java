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
    public Property() {
        this.setValue(1_000);
        House = false;
        
    }
    public int getValue() {
        return (House) ? 2000 : 500;
    }
    public boolean isForSale() {return Owner == null;} 
    
    public void setOwner(Player player) {
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
        player.pay(4_000);
        House = true;
    }
    public boolean haveHouse() {return House;}
    
}
