/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monopoly.java;

import java.util.ArrayList;
import java.io.File;
import java.util.List;

/**
 *
 * @author work
 */
public class Board {
    List<Field> fields;

    public Board() {
        fields = new ArrayList<>();
    }
    
    public void add(Field field) {
        fields.add(field);
    }

}
