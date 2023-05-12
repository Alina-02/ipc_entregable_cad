/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxmlapplication;

import java.net.URL;
import java.util.Hashtable;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
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
    private Button twelve_thirteen_button;
    @FXML
    private Button thirteen_fourteen_button;
    @FXML
    private Button fourteen_fifthteen_button;
    @FXML
    private Button fithteen_sixteen_button;
    @FXML
    private Button sixteen_seventeen_button;
    @FXML
    private Button seventeen_eighteen_button;
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
    private ToggleButton pista1_toogle_button;
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

    /**
     * Initializes the controller class.
     */
    
    Hashtable used = new Hashtable();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try{
        Club club = Club.getInstance();
        }catch(Exception e){}
        
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

    @FXML
    private void nine_ten_clicked(MouseEvent event) {
        
        Label nickname = new Label("nickname");
        nickname.setAlignment(Pos.CENTER);
        nickname.setFont(new Font("System", 20));
        
    }
    
    
    
    
    
    
    
    
    
    
    
}
