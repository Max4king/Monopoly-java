/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopoly_java;

/**
 * The AlreadyHoused class represents an exception thrown when
 * a player is trying to add a house on a property that has a house.
 * This prevents players from overbuilding on a single property
 * @author Ryan Supawarapong
 */
public class AlreadyHoused extends Exception {
    /**
     * Constructs a new AlreadyHoused exception with a default message indicating
     * that a house already exists on the property.
     */
    public AlreadyHoused() {
        super("There is already a house here.");
    }
}
