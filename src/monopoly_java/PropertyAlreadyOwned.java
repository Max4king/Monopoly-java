/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopoly_java;

/**
 * The PropertyAlreadyOwned class represents an exception that is thrown
 * when an attempt is made to change the ownership of a property that is already owned.
 *
 * @author Ryan Supawarapong
 */
public class PropertyAlreadyOwned extends Exception {
    
    /**
     * Initializes a new instance of the PropertyAlreadyOwned class with a predefined error message.
     */
    public PropertyAlreadyOwned() {
        super("Property Already been Owned.");
    }
}
