/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxmlapplication;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Booking;
import model.Club;
import ipc_project.*;

/**
 * FXML Controller class
 *
 * @author nymok
 */
public class DisponibilidadDelDiaFXMLController implements Initializable {

    @FXML
    private Label title_num_pista_label;
    @FXML
    private TextField find_hour_textfield;
    @FXML
    private Button find_hour_button;
    @FXML
    private Button nine_ten_button;
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
    private Button twentyone_twentytwo_button;
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
    private Label nine_ten_label;
    @FXML
    private VBox nine_ten_vbox;
    @FXML
    private Label ocupado_9;
    @FXML
    private GridPane nine_ten_gridpane11;
    @FXML
    private Label ten_eleven_label1;
    @FXML
    private Button ten_eleven_button;
    @FXML
    private GridPane nine_ten_gridpane1;
    @FXML
    private VBox ten_eleven_vbox;
    @FXML
    private Label ocupado_10;
    @FXML
    private Button twelve_thirdteen_button;
    @FXML
    private GridPane nine_ten_gridpane3;
    @FXML
    private Label twelve_thirdteen_label;
    @FXML
    private VBox twelve_thirdteen_vbox;
    @FXML
    private Label ocupado_12;
    @FXML
    private Button thirdteen_fourteen_button;
    @FXML
    private GridPane nine_ten_gridpane4;
    @FXML
    private Label thirdteen_fourteen_label;
    @FXML
    private VBox thirdteen_fourteen_vbox;
    @FXML
    private Label ocupado_13;
    @FXML
    private GridPane nine_ten_gridpane5;
    @FXML
    private Label fourteen_fiveteen_label;
    @FXML
    private VBox fourteen_fifthteen_vbox;
    @FXML
    private Label ocupado_14;
    @FXML
    private Button fifthteen_sixteen_button;
    @FXML
    private GridPane nine_ten_gridpane6;
    @FXML
    private Label fiveteen_sixteen_label;
    @FXML
    private VBox fifthteen_sixteen_vbox;
    @FXML
    private Label ocupado_15;
    @FXML
    private GridPane nine_ten_gridpane7;
    @FXML
    private Label sixteen_seventeen_label;
    @FXML
    private VBox sixteen_seventeen_vbox;
    @FXML
    private Label ocupado_16;
    private Button seventeen_eigtheen_button;
    @FXML
    private Label seventeen_eighteen_label;
    @FXML
    private VBox seventeen_eighteen_vbox;
    @FXML
    private Label ocupado_17;
    @FXML
    private GridPane nine_ten_gridpane9;
    @FXML
    private Label eigthteen_nineteen_label;
    @FXML
    private VBox eighteen_nineteen_vbox;
    @FXML
    private Label ocupado_18;
    @FXML
    private GridPane nine_ten_gridpane10;
    @FXML
    private Label nineteen_twenty_label;
    @FXML
    private VBox nineteen_twenty_vbox;
    @FXML
    private Label ocupado_19;
    @FXML
    private GridPane nine_ten_gridpane111;
    @FXML
    private Label twenty_twentyone_label;
    @FXML
    private VBox twenty_twentyone_vbox;
    @FXML
    private Label ocupado_20;
    @FXML
    private GridPane nine_ten_gridpane12;
    @FXML
    private Label twentyone_twentytwo_label;
    @FXML
    private VBox twentyone_twentytwo_vbox;
    @FXML
    private Label ocupado_21;

    /**
     * Initializes the controller class.
     */
    
    //VARIABLES 
    
    ToggleGroup pistas = new ToggleGroup(); //grupo pistas
    List<VBox> nicknames = new ArrayList<>();
    List<Label> ocupado = new ArrayList<>();
    List<Button> horas = new ArrayList<>();
    LocalDate date = LocalDate.now(); //fecha de las pistas
    String pista = "Pista 1";
    Club club;
    @FXML
    private Button eleven_twelve_button;
    @FXML
    private Label elevel_twelve_label;
    @FXML
    private Label ocupado_11;
    @FXML
    private VBox eleven_twelve_vbox;
    @FXML
    private ToggleButton pista1_toggle_button;
    @FXML
    private Button seventeen_eighteen_button;
    @FXML
    private Button actualizar_datos;
    @FXML
    private Button iniciar_sesion_button;
    
    
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
        horas.add(seventeen_eighteen_button);
        horas.add(eighteen_nineteen_button);
        horas.add(nineteen_twenty_button);
        horas.add(twenty_twentyone_button);
        horas.add(twentyone_twentytwo_button);
        
        
        for(Button hour: horas){
            hour.setDisable(true);
        }
        
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

    @FXML
    private void hour_clicked(MouseEvent event) {
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
                case 17: cambiar_ocupado(seventeen_eighteen_vbox,  ocupado_17,seventeen_eighteen_button, nickname);
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
        if(v != null){
            for(Node node:v.getChildren()){
                if(node instanceof Label &&  node.getId().equals("nickname")){
                    v.getChildren().remove(node);
                    break;
                }
            }
        }
        
    }

    @FXML
    private void pista1_toggle_button_clicked(MouseEvent event) {
        pista = "Pista 1";
        title_num_pista_label.setText("01");
        comprobarPista(pista, date);
    }

    @FXML
    private void pista4_toggle_button_clicked(MouseEvent event) {
        pista = "Pista 4";
        title_num_pista_label.setText("04");
        comprobarPista(pista, date);
    }

    @FXML
    private void pista2_toggle_button_clicked(MouseEvent event) {
        pista = "Pista 2";
        title_num_pista_label.setText("02");
        comprobarPista(pista, date);
    }

    @FXML
    private void pista5_toggle_button_clicked(MouseEvent event) {
        pista = "Pista 5";
        title_num_pista_label.setText("05");
        comprobarPista(pista, date);
    }

    @FXML
    private void pista3_toggle_button_clicked(MouseEvent event) {
        pista = "Pista 3";
        title_num_pista_label.setText("03");
        comprobarPista(pista, date);
    }

    @FXML
    private void pista6_toggle_button_clicked(MouseEvent event) {
        pista = "Pista 6";
        title_num_pista_label.setText("06");
        comprobarPista(pista, date);
    }
    
    @FXML
        private void calendar_on_action(ActionEvent event) {
        
        date = calendar_date_picker.getValue();
        resetButtons();
        comprobarPista(pista, date);
        
    }

    @FXML
    private void actualizar_datos_clicked(MouseEvent event) {
        
        try{
            
            Stage stage;
            stage = main.getStage();
            
            FXMLLoader loader= new  FXMLLoader(getClass().getResource("/views/aCtualizarDatosFXML.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 1315,810);
            stage.setScene(scene);
            
        }catch(Exception e){System.out.println("la cagaste");}
        
        
        
    }

    @FXML
    private void iniciar_sesion_clicked(MouseEvent event) {
        
        try{
            Stage stage;
            stage = main.getStage();
        }catch(Exception e){System.out.println("la cagaste");}
        
        
    }
        
    
}
