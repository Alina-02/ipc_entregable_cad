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
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
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
    @FXML
    private Button menu_button1;
    @FXML
    private AnchorPane pane_slide;
    @FXML
    private Button menu_button2;
    @FXML
    private Circle pictureFrame;
    @FXML
    private Button ir_Actualizar;
    @FXML
    private Button ir_Ver;
    @FXML
    private Button ir_Reservar;
    @FXML
    private Label cerrar_sesion_label;
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
        
        pane_slide.setTranslateX(-490);
        menu_button1.setVisible(true);
        menu_button2.setVisible(false);
        
        ir_Actualizar.setOnMouseExited(event ->{
                ir_Actualizar.setCursor(Cursor.DEFAULT);
        });
        ir_Ver.setOnMouseEntered(event -> {
                ir_Ver.setCursor(Cursor.HAND);
        });
        
        ir_Ver.setOnMouseExited(event ->{
                ir_Ver.setCursor(Cursor.DEFAULT);
        });
        ir_Reservar.setOnMouseEntered(event -> {
                ir_Reservar.setCursor(Cursor.HAND);
        });
        
        ir_Reservar.setOnMouseExited(event ->{
                ir_Reservar.setCursor(Cursor.DEFAULT);
        });

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

    @FXML
    private void run1(MouseEvent event) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(pane_slide);
        
        slide.setToX(0);
        slide.play();
        
        pane_slide.setTranslateX(-490);
        
        slide.setOnFinished((ActionEvent e)-> {
            menu_button1.setVisible(false);
            menu_button2.setVisible(true);
        });
    }

    @FXML
    private void run2(MouseEvent event) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(pane_slide);
        
        slide.setToX(-490);
        slide.play();
        
        pane_slide.setTranslateX(0);
        
        slide.setOnFinished((ActionEvent e)-> {
            menu_button1.setVisible(true);
            menu_button2.setVisible(false);
        });
    }

    @FXML
    private void showChange(MouseEvent event) {
    }

    @FXML
    private void changeProfile(MouseEvent event) {
    }

    @FXML
    private void irActualizar(MouseEvent event) {
         try{
                Stage stage;
                stage = main.getStage();
            
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/actualizarDatosFXML.fxml"));
                Parent root = loader.load();
                  
                Scene scene = new Scene(root, 1200, 750);
                stage.setScene(scene);

                    
            }catch(Exception e){System.out.println(e);}
    }

    @FXML
    private void irVer(MouseEvent event) {
        try{
                Stage stage;
                stage = main.getStage();
            
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/verMisReservasFXML.fxml"));
                Parent root = loader.load();
                  
                Scene scene = new Scene(root, 1200, 750);
                stage.setScene(scene);

                    
            }catch(Exception e){System.out.println(e);}
    }

    @FXML
    private void irReservar(MouseEvent event) {
        try{
                Stage stage;
                stage = main.getStage();
            
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/reservarFXML.fxml"));
                Parent root = loader.load();
                  
                Scene scene = new Scene(root, 1200, 750);
                stage.setScene(scene);

                    
            }catch(Exception e){System.out.println(e);}
    }
    
}
