/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopoly_java;

/**
 * The ServiceField class extends the Field class to represent a service field on the board.
 * Service fields have a specific price that players must pay when they land on such fields.
 * The price of the service field is set upon initializing.
 *
 * @author work
 */
public class ServiceField extends Field {
    
    /**
     * Constructs a new ServiceField with the specified price.
     *
     * @param price The price that players must pay when they land on this service field.
     */
    public ServiceField(int price) {
        this.setValue(price);
    }
}
