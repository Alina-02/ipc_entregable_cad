/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxmlapplication;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import model.Booking;
import model.Club;
import model.Court;


/**
 * FXML Controller class
 *
 * @author nymok
 */
public class ReservarFXMLController implements Initializable {

    private Label title_num_pista_label;
    private TextField find_hour_textfield;
    private Button nine_ten_button;
    private Button ten_eleven_button;
    private Button eleven_twelve_button;
    private Button fourteen_fifthteen_button;
    private Button sixteen_seventeen_button;
    private Button eighteen_nineteen_button;
    private Button nineteen_twenty_button;
    private Button twenty_twentyone_button;
    @FXML
    private Button back_button;
    @FXML
    private Button exit_button;
    private DatePicker calendar_date_picker;
    private ToggleButton pista4_toggle_button;
    private ToggleButton pista2_toggle_button;
    private ToggleButton pista5_toggle_button;
    private ToggleButton pista3_toggle_button;
    private ToggleButton pista6_toggle_button;
    
    private VBox nine_ten_vbox;
    private VBox ten_eleven_vbox;
    private VBox eleven_twelve_vbox;
    private Button twelve_thirdteen_button;
    private VBox twelve_thirdteen_vbox;
    private Button thirdteen_fourteen_button;
    private VBox thirdteen_fourteen_vbox;
    private VBox fourteen_fifthteen_vbox;
    private Button fifthteen_sixteen_button;
    private VBox fifthteen_sixteen_vbox;
    private VBox sixteen_seventeen_vbox;
    private Button seventeen_eigtheen_button;
    private VBox seventeen_eighteen_vbox;
    private VBox eighteen_nineteen_vbox;
    private VBox nineteen_twenty_vbox;
    private VBox twenty_twentyone_vbox;
    private Button twentyone_twentytwo_button;
    private VBox twentyone_twentytwo_vbox;
    
   
    private Label ocupado_9;
    private Label ocupado_10;
    private Label ocupado_11;
    private Label ocupado_12;
    private Label ocupado_13;
    private Label ocupado_14;
    private Label ocupado_15;
    private Label ocupado_16;
    private Label ocupado_17;
    private Label ocupado_18;
    private Label ocupado_19;
    private Label ocupado_20;
    private Label ocupado_21;
    
     /**
     * Initializes the controller class.
     */
    
    Hashtable used = new Hashtable();
    private ToggleButton pista1_toggle_button;
    
    
    //VARIABLES
    
    ToggleGroup pistas = new ToggleGroup(); //grupo pistas
    List<VBox> nicknames = new ArrayList<>();
    List<Label> ocupado = new ArrayList<>();
    List<Button> horas = new ArrayList<>();
    LocalDate date = LocalDate.now(); //fecha de las pistas
    String pista = "Pista 1";
    Club club;
    private VBox hour_buttons_vbox;
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try{
        club = Club.getInstance();
        
        
        //coloca todas las pistas en el toggle group pistas
        pista1_toggle_button.setToggleGroup(pistas);
        pista2_toggle_button.setToggleGroup(pistas);
        pista3_toggle_button.setToggleGroup(pistas);
        pista4_toggle_button.setToggleGroup(pistas);
        pista5_toggle_button.setToggleGroup(pistas);
        pista6_toggle_button.setToggleGroup(pistas);
        //establece la primera pista como seleccionada de serie
        pista1_toggle_button.setSelected(true);
        
        //coloca los vbox en la lista 
        nicknames.add(nine_ten_vbox);
        nicknames.add(ten_eleven_vbox);
        nicknames.add(eleven_twelve_vbox);
        nicknames.add(twelve_thirdteen_vbox);
        nicknames.add(thirdteen_fourteen_vbox);
        nicknames.add(fourteen_fifthteen_vbox);
        nicknames.add(fifthteen_sixteen_vbox);
        nicknames.add(sixteen_seventeen_vbox);
        nicknames.add(seventeen_eighteen_vbox);
        nicknames.add(eighteen_nineteen_vbox);
        nicknames.add(nineteen_twenty_vbox);
        nicknames.add(twenty_twentyone_vbox);
        
        //coloca los labels en la lista
        ocupado.add(ocupado_9);
        ocupado.add(ocupado_10);
        ocupado.add(ocupado_11);
        ocupado.add(ocupado_12);
        ocupado.add(ocupado_13);
        ocupado.add(ocupado_14);
        ocupado.add(ocupado_15);
        ocupado.add(ocupado_16);
        ocupado.add(ocupado_17);
        ocupado.add(ocupado_18);
        ocupado.add(ocupado_19);
        ocupado.add(ocupado_20);
        ocupado.add(ocupado_21);
       
        //coloca los botones en la lista
        horas.add(nine_ten_button);
        horas.add(ten_eleven_button);
        horas.add(eleven_twelve_button);
        horas.add(twelve_thirdteen_button);
        horas.add(thirdteen_fourteen_button);
        horas.add(fourteen_fifthteen_button);
        horas.add(fifthteen_sixteen_button);
        horas.add(sixteen_seventeen_button);
        horas.add(seventeen_eigtheen_button);
        horas.add(eighteen_nineteen_button);
        horas.add(nineteen_twenty_button);
        horas.add(twenty_twentyone_button);
        horas.add(twentyone_twentytwo_button);
        
        //comprueba la pista
        comprobarPista(pista, date);
        
        calendar_date_picker.setDayCellFactory((DatePicker picker) -> {
           return new DateCell() {
               @Override
               public void updateItem(LocalDate date, boolean empty){
                   super.updateItem(date, empty);
                   LocalDate today = LocalDate.now();
                   setDisable(empty || date.compareTo(today) < 0);
               }
           }; 
        });

        
        
        }catch(Exception e){
            System.out.println("problemos");
        }
         
    } 
    
    

    @FXML
    private void exit_clicked(MouseEvent event) {
        Platform.exit();
    }

    
    


    
    Button clicked1;
    Button clicked2;
    
    private void hour_clicked(MouseEvent event) {
        
        //se guarda la hora seleccionada en una variable (puede haber hasta dos)
        event.getSource();
        
        
    }

    private void pista1_toggle_button_clicked(MouseEvent event) {
        pista = "Pista 1";
        title_num_pista_label.setText("01");
        comprobarPista(pista, date);
    }

    private void pista4_toggle_button_clicked(MouseEvent event) {
        pista = "Pista 4";
        title_num_pista_label.setText("04");
        comprobarPista(pista, date);
    }

    private void pista2_toggle_button_clicked(MouseEvent event) {
        pista = "Pista 2";
        title_num_pista_label.setText("02");
        comprobarPista(pista, date);
    }

    private void pista5_toggle_button_clicked(MouseEvent event) {
        pista = "Pista 5";
        title_num_pista_label.setText("05");
        comprobarPista(pista, date);
    }

    private void pista3_toggle_button_clicked(MouseEvent event) {
        pista = "Pista 3";
        title_num_pista_label.setText("03");
        comprobarPista(pista, date);
    }

    private void pista6_toggle_button_clicked(MouseEvent event) {
        pista = "Pista 6";
        title_num_pista_label.setText("06");
        comprobarPista(pista, date);
    }

    private void calendar_on_action(ActionEvent event) {
        
        date = calendar_date_picker.getValue();
        resetButtons();
        comprobarPista(pista, date);
        
    }

    private void reservar_clicked(MouseEvent event) {
        
        Court court = club.getCourt(pista);
        
    }
    

    public void comprobarPista(String pista, LocalDate date){
        //comprobar qué horas del día están ocupadas y cambiar los botones
        //correspondientes :)
        
        resetButtons();
        
        List<Booking> today = club.getCourtBookings(pista, date);
        
        //recorrer la lista de reservas del día para configurar los botones
        for(Booking book : today){
            LocalTime time = book.getFromTime();
            int hour = time.getHour();
            String nickname = book.getMember().getNickName();
            
            switch(hour){
                case 9: cambiar_ocupado(nine_ten_vbox,  ocupado_9,nine_ten_button, nickname);
                    break;
                case 10: cambiar_ocupado(ten_eleven_vbox,  ocupado_10,ten_eleven_button, nickname);
                    break;
                case 11: cambiar_ocupado(eleven_twelve_vbox,  ocupado_11,eleven_twelve_button, nickname);
                    break;
                case 12: cambiar_ocupado(twelve_thirdteen_vbox,  ocupado_12,twelve_thirdteen_button, nickname);
                    break;
                case 13: cambiar_ocupado(thirdteen_fourteen_vbox,  ocupado_13,thirdteen_fourteen_button, nickname);
                    break;
                case 14: cambiar_ocupado(fourteen_fifthteen_vbox,  ocupado_14,fourteen_fifthteen_button, nickname);
                    break;
                case 15: cambiar_ocupado(fifthteen_sixteen_vbox,  ocupado_15,fifthteen_sixteen_button, nickname);
                    break;
                case 16: cambiar_ocupado(sixteen_seventeen_vbox,  ocupado_16,sixteen_seventeen_button, nickname);
                    break;
                case 17: cambiar_ocupado(seventeen_eighteen_vbox,  ocupado_17,seventeen_eigtheen_button, nickname);
                    break;
                case 18: cambiar_ocupado(eighteen_nineteen_vbox,  ocupado_18,eighteen_nineteen_button, nickname);
                    break;
                case 19: cambiar_ocupado(nineteen_twenty_vbox,  ocupado_19,nineteen_twenty_button, nickname);
                    break;
                case 20: cambiar_ocupado(twenty_twentyone_vbox,  ocupado_20,twenty_twentyone_button, nickname);
                    break;
                 case 21: cambiar_ocupado(twentyone_twentytwo_vbox,  ocupado_21,twentyone_twentytwo_button, nickname);
                    break;
                
               }
        }
    }
    
        
    private void  cambiar_ocupado(VBox vbox, Label l, Button b, String id){
        b.setDisable(true);
        l.setText("Ocupado");
        
        
        Label nickname = new Label(id);
        nickname.setId("nickname");
        nickname.setAlignment(Pos.CENTER);
        nickname.setFont(new Font("System", 15));
        nickname.setStyle("-fx-text-fill: #3b3b3b");
        nickname.setContentDisplay(ContentDisplay.LEFT);
        nickname.setTextOverrun(OverrunStyle.ELLIPSIS);
        nickname.setPadding(new Insets(0, 10, 0, 0));
        vbox.getChildren().add(1,nickname);
    }
    
    private void resetButtons(){
        //comprobar todos los vbox
        
        for(Button button: horas){
            button.setDisable(false);
        }
        
        for(Label label: ocupado){
            label.setText("Libre");
        }
        
        for(VBox vbox: nicknames){
            resetButton(vbox);
        }
    }
    
    private void resetButton(VBox v){
        
        for(Node node:v.getChildren()){
            if(node instanceof Label &&  node.getId().equals("nickname")){
                v.getChildren().remove(node);
                break;
            }
        }
        
    }

    private void find_hour_clicked(MouseEvent event) {
        
        String hour = find_hour_textfield.getText();
        
    }
    
    private void find_hour(String hour){
        
        List<Button> searchHour = new ArrayList<>();
        
        for(Node node: hour_buttons_vbox.getChildren()){
            if(node instanceof Button){
                Button button = (Button) node;
                Label label = (Label) button.lookup(".button-label");
                
                if(label != null && label.getText().contains(hour)){
                    searchHour.add(button);
                }
            }
        }
        
    }
    
    
}
