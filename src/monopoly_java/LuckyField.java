/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopoly_java;

/**
 * The LuckyField class extends the Field class to represent a specific type of field in the Monopoly game,
 * where a player landing on this field receives a certain amount of money.
 *
 * @author Ryan Supawarapong
 */
public class LuckyField extends Field {
    
    /**
     * Constructor for the LuckyField class. Initializes the field with a specified value.
     *
     * @param value The amount of money a player receives when landing on this field.
     */
    public LuckyField(int value) {
        this.setValue(value);
    }
}
