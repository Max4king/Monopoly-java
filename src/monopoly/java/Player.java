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
    public Player(String name) {
        this.name = name;
        this.money = 10_000;
    }
    public Player() {
        this.name = "Bank";
        this.money = 0;
    }
    
    public String getName() { return name;}
    
    public void pay(Player player, int amount) throws Exception {
        if (money < amount) {
            throw new Exception("Error Fix this");
        }
        money -= amount;
        player.receive(amount);
    }
    public void payBank(int amount) throws Exception {
        if (money < amount) {
            throw new Exception("Error Fix this");
        }
        money -= amount;
    }
    public void buy(Property property) {
        try{
            this.payBank(property.getValue());
        }
        catch(Exception e) {
            System.out.println("Unable to buy");
        }
    }
    
    public void receive(int amount) {
        money += amount;
    }
    
    
}
