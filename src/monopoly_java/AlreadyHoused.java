/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopoly_java;

/**
 *
 * @author work
 */
public class AlreadyHoused extends Exception {
    public AlreadyHoused() {
        super("There is already a house here.");
    }
}
