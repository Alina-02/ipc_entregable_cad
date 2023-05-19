/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxmlapplication;

import ipc_project.bookingButton;
import ipc_project.main;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import model.Booking;
import model.Club;
import model.ClubDAOException;
import model.Member;


/**
 * FXML Controller class
 *
 * @author nymok
 */
public class VerMisReservasFXMLController implements Initializable {

    @FXML
    private TextField find_hour_textfield;
    @FXML
    private Button find_hour_button;
    @FXML
    private Button back_button;
    @FXML
    private Button exit_button;
    @FXML
    private Button B3;
    @FXML
    private Label dayL;
    @FXML
    private Label timeL;
    @FXML
    private Label paymentL;
    @FXML
    private Button cancelB;
    @FXML
    private Button B1;
    @FXML
    private Button B2;
    @FXML
    private Button B4;
    @FXML
    private Button B5;
    @FXML
    private Button B6;
    @FXML
    private Button B7;
    @FXML
    private Button B8;
    @FXML
    private Button B9;
    @FXML
    private Button B10;

    private Club club;
    @FXML
    private Label B1Time;
    @FXML
    private Label B1Court;
    @FXML
    private Label B2Time;
    @FXML
    private Label B2Court;
    @FXML
    private Label B3Time;
    @FXML
    private Label B3Court;
    @FXML
    private Label B4Time;
    @FXML
    private Label B4Court;
    @FXML
    private Label B5Time;
    @FXML
    private Label B5Court;
    @FXML
    private Label B6Time;
    @FXML
    private Label B6Court;
    @FXML
    private Label B7Time;
    @FXML
    private Label B7Court;
    @FXML
    private Label B8Time;
    @FXML
    private Label B8Court;
    @FXML
    private Label B9Time;
    @FXML
    private Label B9Court;
    @FXML
    private Label B10Time;
    @FXML
    private Label B10Court;
    
    private bookingButton[] bb = new bookingButton[10];
    /**
     * Initializes the controller class.
     */
    @Override
    
    
    
    public void initialize(URL url, ResourceBundle rb) {

        //Consigue al miembro loggeado e inicializa club
        Member logedMember = AutenticarseFXMLController.getMember();
        try{club = Club.getInstance(); } 
        catch (ClubDAOException | IOException ex){
            Logger.getLogger(VerMisReservasFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Consigue las reservas del miembro
        String login = logedMember.getNickName();
        List<Booking> bookingList = club.getUserBookings(login);
                
        //Mete todos los valores que hay dentro del boton en un array de bookingButtons
        Button[] buttons = {B1, B2, B3, B4, B5, B6, B7, B8, B9, B10};
        Label[] buttonsTime = {B1Time, B2Time, B3Time, B4Time, B5Time, B6Time, B7Time, B8Time, B9Time, B10Time};
        Label[] buttonsCourt = {B1Court, B2Court, B3Court, B4Court, B5Court, B6Court, B7Court, B8Court, B9Court, B10Court};
        for(int i = 0; i < bb.length; i++){
            //bb[i] = new bookingButton(buttons[i], bookingList.get(i));
        }
        
        //asigna cada boton a una reserva
        for(int i = 0; i < bb.length && i < bookingList.size(); i++){
            //Busca una reserva de la persona loggeada
            Booking aux = bookingList.get(i);
            //Le asigna al boton las caracteristicas de la reserva (no estoy del todo seguro de como funciona getFromTime())
            //bb[i].setTime(aux.getFromTime().toString());
            //bb[i].setCourt(aux.getCourt().getName());
        }

    }  

    @FXML
    private void showData(ActionEvent event){
        dayL.setText("");
        timeL.setText("");
        paymentL.setText("");
    }

    @FXML
    private void exit_clicked(MouseEvent event) {
        
    }
    
}
