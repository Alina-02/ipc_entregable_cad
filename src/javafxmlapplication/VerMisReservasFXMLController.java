/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxmlapplication;

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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Button[] buttons = {B1, B2, B3, B4, B5, B6, B7, B8, B9, B10};
        
        //Consigue al miembro loggeado e inicializa club
        Member logedMember = main.logedMember;
        try{club = Club.getInstance();} 
        catch (ClubDAOException | IOException ex){Logger.getLogger(VerMisReservasFXMLController.class.getName()).log(Level.SEVERE, null, ex);}
        
        //Consigue las reservas del miembro
        String login = logedMember.getNickName();
        List<Booking> alm = club.getUserBookings(login);
        
        //asigna cada boton a una resserva
        for(int i = 0; i < 10 && i < alm.size(); i++){
            //buttons[i]
        }
        
    }    

    @FXML
    private void showData(ActionEvent event) {
        
        
    }

    @FXML
    private void exit_clicked(MouseEvent event) {
        
    }
    
}
