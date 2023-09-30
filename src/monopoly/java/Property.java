/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopoly.java;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author work
 */
public class Property extends Field {
    protected Player Owner;
    
    public Property() {
        this.setValue(1_000);
        
    }
    public boolean isForSale() {
        return Owner == null;
    } 
    public void setOwner(Player player) {
        Owner = player;
    }
    public void removeOwner() {
        Owner = null;
    }
}
