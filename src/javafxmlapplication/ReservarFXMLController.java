/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxmlapplication;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import model.Booking;
import model.Club;


/**
 * FXML Controller class
 *
 * @author nymok
 */
public class ReservarFXMLController implements Initializable {

    @FXML
    private Label title_num_pista_label;
    @FXML
    private TextField find_hour_textfield;
    @FXML
    private Button find_hour_button;
    @FXML
    private Button nine_ten_button;
    @FXML
    private Button ten_eleven_button;
    @FXML
    private Button eleven_twelve_button;
    @FXML
    private Button fourteen_fifthteen_button;
    @FXML
    private Button sixteen_seventeen_button;
    @FXML
    private Button eighteen_nineteen_button;
    @FXML
    private Button nineteen_twenty_button;
    @FXML
    private Button twenty_twentyone_button;
    @FXML
    private Button check_button;
    @FXML
    private Button back_button;
    @FXML
    private Button exit_button;
    @FXML
    private DatePicker calendar_date_picker;
    @FXML
    private ToggleButton pista4_toggle_button;
    @FXML
    private ToggleButton pista2_toggle_button;
    @FXML
    private ToggleButton pista5_toggle_button;
    @FXML
    private ToggleButton pista3_toggle_button;
    @FXML
    private ToggleButton pista6_toggle_button;
    
    @FXML
    private GridPane nine_ten_gridpane;
    @FXML
    private Label nine_ten_ocupado_label;
    @FXML
    private GridPane nine_ten_gridpane1;
    @FXML
    private Label nine_ten_ocupado_label1;
    @FXML
    private VBox nine_ten_vbox;
    @FXML
    private VBox ten_eleven_vbox;
    @FXML
    private GridPane nine_ten_gridpane2;
    @FXML
    private VBox eleven_twelve_vbox;
    @FXML
    private Label nine_ten_ocupado_label2;
    @FXML
    private Button twelve_thirdteen_button;
    @FXML
    private GridPane nine_ten_gridpane3;
    @FXML
    private VBox twelve_thirdteen_vbox;
    @FXML
    private Label nine_ten_ocupado_label3;
    @FXML
    private Button thirdteen_fourteen_button;
    @FXML
    private GridPane nine_ten_gridpane4;
    @FXML
    private VBox thirdteen_fourteen_vbox;
    @FXML
    private Label nine_ten_ocupado_label4;
    @FXML
    private GridPane nine_ten_gridpane5;
    @FXML
    private VBox fourteen_fifthteen_vbox;
    @FXML
    private Label nine_ten_ocupado_label5;
    @FXML
    private Button fifthteen_sixteen_button;
    @FXML
    private GridPane nine_ten_gridpane6;
    @FXML
    private VBox fifthteen_sixteen_vbox;
    @FXML
    private Label nine_ten_ocupado_label6;
    @FXML
    private GridPane nine_ten_gridpane7;
    @FXML
    private VBox sixteen_seventeen_vbox;
    @FXML
    private Label nine_ten_ocupado_label7;
    @FXML
    private Button seventeen_eigtheen_button;
    @FXML
    private VBox seventeen_eighteen_vbox;
    @FXML
    private Label nine_ten_ocupado_label8;
    @FXML
    private GridPane nine_ten_gridpane9;
    @FXML
    private VBox eighteen_nineteen_vbox;
    @FXML
    private Label nine_ten_ocupado_label9;
    @FXML
    private GridPane nine_ten_gridpane10;
    @FXML
    private VBox nineteen_twenty_vbox;
    @FXML
    private Label nine_ten_ocupado_label10;
    @FXML
    private GridPane nine_ten_gridpane11;
    @FXML
    private VBox twenty_twentyone_vbox;
    @FXML
    private Label nine_ten_ocupado_label11;
    @FXML
    private Button twentyone_twentytwo_button;
    @FXML
    private GridPane nine_ten_gridpane12;
    @FXML
    private VBox twentyone_twentytwo_vbox;
    @FXML
    private Label nine_ten_ocupado_label12;
    

    /**
     * Initializes the controller class.
     */
    
    Hashtable used = new Hashtable();
    @FXML
    private ToggleButton pista1_toggle_button;
    
    
    //VARIABLES
    
    ToggleGroup pistas = new ToggleGroup(); //grupo pistas
    LocalDate date = LocalDate.now(); //fecha de las pistas
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try{
        Club club = Club.getInstance();
        }catch(Exception e){}
        
        pista1_toggle_button.setToggleGroup(pistas);
        pista2_toggle_button.setToggleGroup(pistas);
        pista3_toggle_button.setToggleGroup(pistas);
        pista4_toggle_button.setToggleGroup(pistas);
        pista5_toggle_button.setToggleGroup(pistas);
        pista6_toggle_button.setToggleGroup(pistas);

        pista1_toggle_button.setSelected(true);
       

        //getCourtBookings(String courtName, LocalDate madeForDay)
        calendar_date_picker.setOnAction(e -> {
            date = calendar_date_picker.getValue();
        });
        
        //ArrayList<Booking> today = getCourtBookings("pista 1", date);
        
        //comprobar qué horas del día están ocupadas y cambiar los botones
        //correspondientes :)

        
        used.put(910, false);
        used.put(1011, false);
        used.put(1112, false);
        used.put(1213, false);
        used.put(1314, false);
        used.put(1415, false);
        used.put(1516, false);
        used.put(1617, false);
        used.put(1718, false);
        used.put(1920, false);
        used.put(2021, false);
        used.put(2122, false);
        
        
        
    } 
    
    

    @FXML
    private void exit_clicked(MouseEvent event) {
        Platform.exit();
    }

    
    
    
    private void  cambiar_ocupado(VBox vbox){
        Label nickname = new Label("Label");
        nickname.setAlignment(Pos.CENTER);
        nickname.setFont(new Font("System", 15));
        nickname.setStyle("-fx-text-fill: #3b3b3b");
        nickname.setContentDisplay(ContentDisplay.LEFT);
        nickname.setTextOverrun(OverrunStyle.ELLIPSIS);
        nickname.setPadding(new Insets(0, 10, 0, 0));
        vbox.getChildren().add(1,nickname);
    }

    @FXML
    private void hour_clicked(MouseEvent event) {
        
    }

    @FXML
    private void pista1_toggle_button_clicked(MouseEvent event) {
    }

    @FXML
    private void pista4_toggle_button_clicked(MouseEvent event) {
    }

    @FXML
    private void pista2_toggle_button_clicked(MouseEvent event) {
    }

    @FXML
    private void pista5_toggle_button_clicked(MouseEvent event) {
    }

    @FXML
    private void pista3_toggle_button_clicked(MouseEvent event) {
    }

    @FXML
    private void pista6_toggle_button_clicked(MouseEvent event) {
    }

    @FXML
    private void calendar_on_action(ActionEvent event) {
    }
    

    
    
    
    
    
}
