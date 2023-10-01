/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopoly_java;

/**
 * The Field class represents a generic field on a Monopoly game board.
 * It serves as a base class for more specific types of fields like properties, service fields, or lucky fields.
 * Each field has an associated value, which could represent different things depending on the specific type of field.
 *
 * @author Ryan Supawarapong
 */
public class Field {
    protected int value;
    /**
     * Gets the value associated with this field.
     *
     * @return The monetary value of this field.
     */
    public int getValue() {
        return value;
    }
    
    /**
     * Sets the value associated with this field.
     *
     * @param value The new monetary value for this field.
     */
    protected void setValue(int value) {
        this.value = value;
    }
}
