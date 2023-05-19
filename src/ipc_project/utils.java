/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipc_project;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author nymok
 */
public class utils {
    
    
        
    
    public static void cambiarCursor(MouseEvent event, Button button) {
        
        Cursor actual = button.getCursor();
        button.setCursor(Cursor.HAND);
        
    }
    
    public static void cambiarCursor(MouseEvent event, ToggleButton button) {
        
        Cursor actual = button.getCursor();
        button.setCursor(Cursor.HAND);
        
    }
    
    public static void devolverCursor(MouseEvent event, Button button){
        
        Cursor actual = button.getCursor();
        button.setCursor(Cursor.DEFAULT);
    }
    
    public static void asignarHoras(int clicked1, int clicked2, Button b1, Button b2, Button hour, int first_hour){
        if(clicked1 != -1){clicked2 = first_hour; b2 = hour;}
        else{clicked1 = first_hour; b1 = hour;}
    }
}
