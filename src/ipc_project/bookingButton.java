/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipc_project;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author dantr
 */

public class bookingButton {
    public Button button;
    public Label time;
    public Label court;
    
    public bookingButton(Button b, Label t, Label c){
        button = b;
        time = t;
        court = c;
    }
    
    public Button getButton(){
        return this.button;
    }
    
    public Label getTime(){
        return this.time;
    }
    
    public Label getCourt(){
        return this.court;
    }
    
    public void setButton(Button b){
        this.button = b;
    }
    public void setTime(String t){
        this.time.setText(t);
    }
    public void setCourt(String c){
        this.court.setText(c);
    }

}
