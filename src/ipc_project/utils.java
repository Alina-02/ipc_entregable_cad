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
    
     public static void devolverCursor(MouseEvent event, ToggleButton button) {
        
        Cursor actual = button.getCursor();
        button.setCursor(Cursor.HAND);
        
    }
    
    public static void asignarHoras(int clicked1, int clicked2, Button b1, Button b2, Button hour, int first_hour){
        if(clicked1 != -1){clicked2 = first_hour; b2 = hour;}
        else{clicked1 = first_hour; b1 = hour;}
    }
    
    public static boolean isNumeric(String string) {
        int intValue;

        if(string == null || string.equals("")) {
            return false;
        }

        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
        }
        return false;
    }
    public static boolean isLong(String string) {
        long longValue;

        if(string == null || string.equals("")) {
            return false;
        }

        try {
            longValue = Long.parseLong(string);
            return true;
        } catch (NumberFormatException e) {
        }
        return false;
    }
    public static boolean textBien(String nombre){
        String n = nombre.replaceAll("\\s", "");
        char lista[]= n.toCharArray();
        boolean si = true;
        int num =0;
        for(int i = 0; i< lista.length && si; i++){
            num = (int) lista[i];
            if(num<= 90 && num >= 65){
                si = true;
            }else if(num<=122 && num >= 97){
                si = true;
            }else if(num == 164 || num ==165){
                si = true;
            }else si = false;
        }
        return si;
    }
    public static boolean numberBien(String nombre, int n){
        String s = nombre.replaceAll("\\s", "");
        
        if((isNumeric(s) ||isLong(s)) && s.length() == n){
            return true;
        }
        return false;
    }
    
    public static boolean contraseñaBien(String cont){
        if(cont.length()>6){
            return true;
        }
        return false;
    }
    
    public static boolean confirmacionBien(String cont, String conf){
        return cont.equals(conf);
    }
}


