/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipc_project;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Booking;

/**
 *
 * @author dantr
 */

public class bookingButton {
    public Button button;
    public Booking booking;
    public Label time;
    public Label court;
    
    public bookingButton(Button bu, Booking bo, Label t, Label c){
        button = bu;
        booking = bo;
        time = t;
        court = c;
    }
    
    public Button getButton(){
        return this.button;
    }
    
    public Booking getBooking(){
        return this.booking;
    }
    
    public void setButton(Button bu){
        this.button = bu;
    }
    public void setTime(Booking bo){
        this.booking = bo;
    }

}
