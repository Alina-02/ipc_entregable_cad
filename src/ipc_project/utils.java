/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipc_project;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author nymok
 */
public class utils {
    
       public void cambiarCursor(MouseEvent event, Button button) {
        
        Cursor actual = button.getCursor();
        button.setCursor(Cursor.CLOSED_HAND);
        
    }
    
}
