package monopoly_java;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * The NotEnoughMoney Exception class is used when there is not enough money in the player
 * use this exception.
 * @author work
 */
public class NotEnoughMoney extends Exception {
    /**
     * Constructs a new NotEnoughMoney exception with default message
     * due to not having enough money.
     */
    public NotEnoughMoney() {
        super("Not Enough Money");
    }
}
