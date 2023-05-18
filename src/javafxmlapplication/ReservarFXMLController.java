/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxmlapplication;

import ipc_project.main;
import ipc_project.utils;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Optional;
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
import javafx.stage.Stage;
import model.Booking;
import model.Club;
import model.Court;
import model.Member;
import javafxmlapplication.*;


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
    private Button nine_ten_button;
    @FXML
    private Button ten_eleven_button;
    @FXML
    private Button eleven_twelve_button;
    @FXML
    private Button sixteen_seventeen_button;
    @FXML
    private Button eighteen_nineteen_button;
    @FXML
    private Button nineteen_twenty_button;
    @FXML
    private Button twenty_twentyone_button;
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
    private VBox nine_ten_vbox;
    @FXML
    private VBox ten_eleven_vbox;
    @FXML
    private VBox eleven_twelve_vbox;
    @FXML
    private Button twelve_thirdteen_button;
    @FXML
    private VBox twelve_thirdteen_vbox;
    @FXML
    private Button thirdteen_fourteen_button;
    @FXML
    private VBox thirdteen_fourteen_vbox;
    @FXML
    private VBox fourteen_fifthteen_vbox;
    @FXML
    private VBox fifthteen_sixteen_vbox;
    @FXML
    private VBox sixteen_seventeen_vbox;
    @FXML
    private VBox seventeen_eighteen_vbox;
    @FXML
    private VBox eighteen_nineteen_vbox;
    @FXML
    private VBox nineteen_twenty_vbox;
    @FXML
    private VBox twenty_twentyone_vbox;
    @FXML
    private Button twentyone_twentytwo_button;
    @FXML
    private VBox twentyone_twentytwo_vbox;
    
    @FXML
    private Label ocupado_9;
    @FXML
    private Label ocupado_10;
    @FXML
    private Label ocupado_11;
    @FXML
    private Label ocupado_12;
    @FXML
    private Label ocupado_13;
    @FXML
    private Label ocupado_14;
    @FXML
    private Label ocupado_15;
    @FXML
    private Label ocupado_16;
    @FXML
    private Label ocupado_17;
    @FXML
    private Label ocupado_18;
    @FXML
    private Label ocupado_19;
    @FXML
    private Label ocupado_20;
    @FXML
    private Label ocupado_21;
    
     /**
     * Initializes the controller class.
     */
    
    @FXML
    private ToggleButton pista1_toggle_button;
    
    
    //VARIABLES
    
    ToggleGroup pistas = new ToggleGroup(); //grupo pistas
    List<VBox> nicknames = new ArrayList<>();
    List<Label> ocupado = new ArrayList<>();
    List<Button> horas = new ArrayList<>();
    LocalDate date = LocalDate.now(); //fecha de las pistas
    String pista = "Pista 1";
    Club club;
    int clicked1 = -1;
    int clicked2 = -1;
    Button clicked1_button = null;
    Button clicked2_button = null;
    @FXML
    private VBox hour_buttons_vbox;
    @FXML
    private Button find_hour_button;
    @FXML
    private GridPane nine_ten_gridpane;
    @FXML
    private Label nine_ten_label;
    @FXML
    private GridPane nine_ten_gridpane1;
    @FXML
    private Label ten_eleven_label;
    @FXML
    private GridPane nine_ten_gridpane2;
    @FXML
    private Label eleven_twelve_label;
    @FXML
    private GridPane nine_ten_gridpane3;
    @FXML
    private Label twelve_thirdteen_label;
    @FXML
    private GridPane nine_ten_gridpane4;
    @FXML
    private Label thirdteen_fourteen_label;
    @FXML
    private GridPane nine_ten_gridpane5;
    @FXML
    private Label fourteen_fiveteen_label;
    @FXML
    private GridPane nine_ten_gridpane6;
    @FXML
    private Label fiveteen_sixteen_label;
    @FXML
    private GridPane nine_ten_gridpane7;
    @FXML
    private Label sixteen_seventeen_label;
    @FXML
    private Label seventeen_eighteen_label;
    @FXML
    private GridPane nine_ten_gridpane9;
    @FXML
    private Label eigthteen_nineteen_label;
    @FXML
    private GridPane nine_ten_gridpane10;
    @FXML
    private Label nineteen_twenty_label;
    @FXML
    private GridPane nine_ten_gridpane11;
    @FXML
    private Label twenty_twentyone_label;
    @FXML
    private GridPane nine_ten_gridpane12;
    @FXML
    private Label twentyone_twentytwo_label;
    @FXML
    private Button reservar_button;
    @FXML
    private Button actualizar_datos_button;
    @FXML
    private Button mis_reservar_button;
    @FXML
    private Button reservar_pistas_button;
    @FXML
    private Button fourteen_fifteen_button;
    @FXML
    private Button fifteen_sixteen_button;
    @FXML
    private Button seventeen_eighteen_button;
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try{
        club = Club.getInstance();
        
        clicked1 = -1;
        clicked2 = -1;
        
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
        horas.add(fourteen_fifteen_button);
        horas.add(fifteen_sixteen_button);
        horas.add(sixteen_seventeen_button);
        horas.add(seventeen_eighteen_button);
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

    
    


    // CUANDO PULSAS UNA HORA

    @FXML
    private void hour_clicked(MouseEvent event) {
        if(clicked1 == -1 || clicked2 == -1){
        
            Button button = null;
            //se guarda la hora seleccionada en una variable (puede haber hasta dos)
            if(event.getSource() instanceof Button){
                button = (Button) event.getSource(); 
            }
            String id = button.getId();
            button.setStyle("-fx-background-color: #d5dce6");
        
            switch(id){
                case "nine_ten_button": 
                    utils.asignarHoras(clicked1, clicked2, clicked1_button, clicked2_button, nine_ten_button, 9);
                    break;
                case "ten_eleven_button": 
                    utils.asignarHoras(clicked1, clicked2, clicked1_button, clicked2_button, ten_eleven_button, 10);
                    break;
                case "eleven_twelve_button": 
                    utils.asignarHoras(clicked1, clicked2, clicked1_button, clicked2_button, eleven_twelve_button, 11);
                    break;
                case "twelve_thirdteen_button": 
                    utils.asignarHoras(clicked1, clicked2, clicked1_button, clicked2_button, twelve_thirdteen_button, 12);
                    break;
                case "thirdteen_fourteen_button": 
                    utils.asignarHoras(clicked1, clicked2, clicked1_button, clicked2_button, thirdteen_fourteen_button, 13);
                    break;
                case "fourteen_fifteen_button": 
                    utils.asignarHoras(clicked1, clicked2, clicked1_button, clicked2_button, fourteen_fifteen_button, 14);
                    break;
                case "fifteen_sixteen_button": 
                    utils.asignarHoras(clicked1, clicked2, clicked1_button, clicked2_button, fifteen_sixteen_button, 15);
                    break;
                case "sixteen_seventeen_button": 
                    utils.asignarHoras(clicked1, clicked2, clicked1_button, clicked2_button, sixteen_seventeen_button, 16);
                    break;
                case "seventeen_eighteen_button": 
                    utils.asignarHoras(clicked1, clicked2, clicked1_button, clicked2_button, seventeen_eighteen_button, 17);
                    break;
                case "eighteen_nineteen_button": 
                    utils.asignarHoras(clicked1, clicked2, clicked1_button, clicked2_button, eighteen_nineteen_button, 18);
                    break;
                case "nineteen_twenty_button": 
                    utils.asignarHoras(clicked1, clicked2, clicked1_button, clicked2_button, nineteen_twenty_button, 19);
                    break;
                case "twenty_twentyone_button": 
                    utils.asignarHoras(clicked1, clicked2, clicked1_button, clicked2_button, twenty_twentyone_button, 20);
                    break;
                case "twentyone_twentytwo_button": 
                    utils.asignarHoras(clicked1, clicked2, clicked1_button, clicked2_button, twentyone_twentytwo_button, 21);
                    break;
                }
         }
        
    }
    
    // CAMBIAR DE PISTA
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
    
    // CAMBIAR DE FECHA EN EL CALENDARIO
    @FXML
    private void calendar_on_action(ActionEvent event) {
        
        date = calendar_date_picker.getValue();
        resetButtons();
        comprobarPista(pista, date);
        
    }
    
    // RESERVAR UNA PISTA
    @FXML
    private void reservar_clicked(MouseEvent event) {
        if(clicked1 != -1){
        Court court = club.getCourt(pista);
        Member member = AutenticarseFXMLController.getMember();
        //registerBooking(LocalDateTime bookingDate, LocalDate madeForDay, LocalTime fromHour, boolean paid, Court court, Member member)
        
        LocalDate day = date;
        LocalTime hour = LocalTime.of(clicked1, 0);
        LocalDateTime bookingDate = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        Boolean paid = member.checkHasCreditInfo();
        try{
        if(clicked2 != -1){
            club.registerBooking(bookingDate, day, hour, paid, court, member);
            hour = LocalTime.of(clicked2, 0);
            club.registerBooking(bookingDate, day, hour, paid, court, member);
        }else{
            club.registerBooking(bookingDate, day, hour, paid, court, member);

        }
        }catch(Exception e){
            System.out.println("efe");
        }finally{
            clicked1_button.setStyle("-fx-background-color: #FFFFFF");
            if(clicked2_button != null){
                clicked2_button.setStyle("-fx-background-color: #FFFFFF");
            }
            clicked1 = -1;
            clicked2 = -1;
        }
        }
        
        
    }
    
    
    // COMPROBAR SI UNA PISTA ESTÁ OCUPADA O NO
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
                case 14: cambiar_ocupado(fourteen_fifthteen_vbox,  ocupado_14,fourteen_fifteen_button, nickname);
                    break;
                case 15: cambiar_ocupado(fifthteen_sixteen_vbox,  ocupado_15,fifteen_sixteen_button, nickname);
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
    
    // CAMBIAR UN BOTÓN AL ESTADO DE OCUPADO
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
    
    // RESETEAR TODOS LOS BOTONES
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
    
    // RESETEAR UN BOTÓN
    private void resetButton(VBox v){
        
        for(Node node:v.getChildren()){
            if(node instanceof Label &&  node.getId().equals("nickname")){
                v.getChildren().remove(node);
                break;
            }
        }
        
    }
    
    // BOTÓN BUSCAR HORA
    @FXML
    private void find_hour_clicked(MouseEvent event) {
        
        String hour = find_hour_textfield.getText();
        
    }
    
    
    // BUSCADOR DE LA HORA
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
    
    // CAMBIAR EL CURSOR AL PASAR SOBRE UN BOTÓN
    @FXML
    private void button_entered(MouseEvent event) {
        
        Object source = event.getSource();
        if(source instanceof Button){
            Button hour = (Button) source;
            utils.cambiarCursor(event, hour);
        }
        
    }
    
    // IR A ACTUALIZAR DATOS
    @FXML
    private void actualizar_datos_clicked(MouseEvent event) {
        
        try{
            Stage stage;
            stage = main.getStage();
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/actualizarDatosFXML.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 1200, 750);
            stage.setScene(scene);
                    
        }catch(Exception e){System.out.println(e);}
        
    }

    // IR A MIS RESERVAS
    @FXML
    private void mis_reservar_clicked(MouseEvent event) {
        
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
    private void reservar_pistas_cliked(MouseEvent event) {
    }

    @FXML
    private void cerrar_sesion_clicked(MouseEvent event) {
    }

    @FXML
    private void hour_entered(MouseEvent event) {
        

        
    }
    
    
}
