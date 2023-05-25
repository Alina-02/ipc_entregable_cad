package javafxmlapplication;

import ipc_project.main;
import ipc_project.utils;
import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
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
    @FXML
    private ToggleButton pista1_toggle_button;
    @FXML
    private VBox hour_buttons_vbox;
    @FXML
    private GridPane nine_ten_gridpane;
    @FXML
    private Label nine_ten_label;
    @FXML
    private Label ten_eleven_label;
    @FXML
    private Label eleven_twelve_label;
    @FXML
    private Label twelve_thirdteen_label;
    @FXML
    private Label thirdteen_fourteen_label;
    @FXML
    private Label fourteen_fiveteen_label;
    @FXML
    private Label fiveteen_sixteen_label;
    @FXML
    private Label sixteen_seventeen_label;
    @FXML
    private Label seventeen_eighteen_label;
    @FXML
    private Label eigthteen_nineteen_label;
    @FXML
    private Label nineteen_twenty_label;
    @FXML
    private Label twenty_twentyone_label;
    @FXML
    private Label twentyone_twentytwo_label;
    @FXML
    private Button reservar_button;
    @FXML
    private Button fourteen_fifteen_button;
    @FXML
    private Button fifteen_sixteen_button;
    @FXML
    private Button seventeen_eighteen_button;
    @FXML
    private Button menu_button1;
    @FXML
    private AnchorPane pane_slide;
    @FXML
    private Button menu_button2;
    @FXML
    private Button ir_Actualizar;
    @FXML
    private Button ir_Ver;
    @FXML
    private Button ir_Reservar;
    @FXML
    private Button cerrar_sesion_label;
    @FXML
    private Button exit_button_Reservar;
    @FXML
    private Circle avatar_circle;
    @FXML
    private Label nickname_label;
    @FXML
    private GridPane ten_eleven_gridpane;
    @FXML
    private GridPane eleven_twelve_gridpane;
    @FXML
    private GridPane twelve_thirdteen_gridpane;
    @FXML
    private GridPane thirdteen_fourteen_gridpane;
    @FXML
    private GridPane fourteen_fifteen_gridpane;
    @FXML
    private GridPane fifteen_sixteen_gridpane;
    @FXML
    private GridPane sixteen_seventeen_gridpane;
    @FXML
    private GridPane seventeen_eighteen_gridpane;
    @FXML
    private GridPane eighteen_nineteen_gridpane;
    @FXML
    private GridPane nineteen_twenty_gridpane;
    @FXML
    private GridPane twenty_twentyone_gridpane;
    @FXML
    private GridPane twentyone_twentytwo_gridpane;
    @FXML
    private AnchorPane anchor_pane;
   
    
    
    
    //VARIABLES
    
    ToggleGroup pistas = new ToggleGroup(); //grupo pistas
    List<ToggleButton> pistasList = new ArrayList<>();
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
    Member member = AutenticarseFXMLController.getMember();
    ObservableList<Button> horasObservable = FXCollections.observableList(horas);
    ListView<Button> horasListView = new ListView<Button>(horasObservable);
    
    // MAP ENTRE BUTTONS Y VALORES
    ObservableMap<Button, Integer> map = FXCollections.observableHashMap();
    ObservableMap<Button, GridPane> map2 = FXCollections.observableHashMap();
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
        // TODO
        try{
        club = Club.getInstance();
        
        clicked1 = -1;
        clicked2 = -1;
        
        //coloca todas las pistas en el toggle group pistas
        pista1_toggle_button.setToggleGroup(pistas); 
        pistasList.add(pista1_toggle_button);
        pista2_toggle_button.setToggleGroup(pistas);
        pistasList.add(pista2_toggle_button);
        pista3_toggle_button.setToggleGroup(pistas);
        pistasList.add(pista3_toggle_button);
        pista4_toggle_button.setToggleGroup(pistas);
        pistasList.add(pista4_toggle_button);
        pista5_toggle_button.setToggleGroup(pistas);
        pistasList.add(pista5_toggle_button);
        pista6_toggle_button.setToggleGroup(pistas);
        pistasList.add(pista6_toggle_button);
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
        
        //llena el map de buttons e Int
        map.put(nine_ten_button, 9);
        map.put(ten_eleven_button, 10);
        map.put(eleven_twelve_button, 11);
        map.put(twelve_thirdteen_button,12);
        map.put(thirdteen_fourteen_button, 13);
        map.put(fourteen_fifteen_button, 14);
        map.put(fifteen_sixteen_button, 15);
        map.put(sixteen_seventeen_button, 16);
        map.put(seventeen_eighteen_button, 17);
        map.put(eighteen_nineteen_button, 18);
        map.put(nineteen_twenty_button, 19);
        map.put(twenty_twentyone_button, 20);
        map.put(twentyone_twentytwo_button, 21);
        
        //lleva el map de buttons y gridpanes
        map2.put(nine_ten_button, nine_ten_gridpane);
        map2.put(ten_eleven_button, ten_eleven_gridpane);
        map2.put(eleven_twelve_button, eleven_twelve_gridpane); 
        map2.put(twelve_thirdteen_button, twelve_thirdteen_gridpane);
        map2.put(thirdteen_fourteen_button, thirdteen_fourteen_gridpane);
        map2.put(fourteen_fifteen_button, fourteen_fifteen_gridpane);
        map2.put(fifteen_sixteen_button, fifteen_sixteen_gridpane);
        map2.put(sixteen_seventeen_button, sixteen_seventeen_gridpane);
        map2.put(seventeen_eighteen_button, seventeen_eighteen_gridpane);
        map2.put(eighteen_nineteen_button, eighteen_nineteen_gridpane);
        map2.put(nineteen_twenty_button, nineteen_twenty_gridpane);
        map2.put(twenty_twentyone_button, twenty_twentyone_gridpane);
        map2.put(twentyone_twentytwo_button, twentyone_twentytwo_gridpane);
        
        // COMPRUEBA LAS PISTAS
        
        comprobarPista(pista, date);
        
        
        // CONFIGURA EL CALENDARIO
        
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
        calendar_date_picker.setShowWeekNumbers(false);
        
        
        }catch(Exception e){
            System.out.println("Problemas en initialize: " + e);
        }
         
        // MENÚ
        
        pane_slide.setTranslateX(-490);
        menu_button1.setVisible(true);
        menu_button2.setVisible(false);
        ir_Ver.setDisable(true);
        ir_Actualizar.setDisable(true);
        ir_Reservar.setDisable(true);
        cerrar_sesion_label.setDisable(true);
        
        // CURSORES
        
        ir_Actualizar.setOnMouseEntered(event -> {
                ir_Actualizar.setCursor(Cursor.HAND);
        });
        
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
        cerrar_sesion_label.setOnMouseEntered(event -> {
                cerrar_sesion_label.setCursor(Cursor.HAND);
        });
        
        cerrar_sesion_label.setOnMouseExited(event ->{
                cerrar_sesion_label.setCursor(Cursor.DEFAULT);
        });
        exit_button_Reservar.setOnMouseEntered(event -> {
                exit_button_Reservar.setCursor(Cursor.HAND);
        });
        
        exit_button_Reservar.setOnMouseExited(event ->{
                exit_button_Reservar.setCursor(Cursor.DEFAULT);
        });
        
        
        
        // PONER EL NICKNAME
        
        nickname_label.setText(member.getNickName());
        
        // BUSCADOR EN TIEMPO REAL
        
        find_hour_textfield.textProperty().addListener((observable, oldValue, newValue) ->{
            
        boolean correcto = true;
        //Comprobar que el formato está bien
        if(!find_hour_textfield.getText().isEmpty()){
            String hour = find_hour_textfield.getText();
            //if(hour.equals(null)){verBotones();}
            if(!utils.isNumeric(hour)){correcto = false;}
            if(correcto){
                int hourInt = Integer.parseInt(hour);
                if(hourInt <= 21){
                    buscarHora(hour);
                }else{
                    // NO ESTÁ EN EL RANGO DE HORAS
                }
                
            }else{
                // NO HA PUESTO UN NÚMERO
            }
            
            
        }else{verBotones();}
        });
        
        // SIEMPRE VA A HABER UNA PISTA SELECCIONADA
        
        pistas.selectedToggleProperty().addListener((observable, oldValue, newValue)->{
            if(newValue == null){
                pistas.selectToggle(oldValue);
            }
        });
        
        // COLOCAR FOTO DE PERFIL
        
        Image selectedFile = member.getImage();
        avatar_circle.setFill(new ImagePattern(selectedFile));
        
        // DISABLED LAS HORAS QUE YA HAN PASADO
        
        if(date == LocalDate.now()){
            LocalTime now = LocalTime.now();
            now.getHour();
            System.out.println(now.getHour());
            
        }
        
    } 
    
    
 
    
    private void exit_clicked(MouseEvent event) {
        Platform.exit();
    }

    
    


    // CUANDO PULSAS UNA HORA

    @FXML
    private void hour_clicked(MouseEvent event) {
        Button button = null;
        
        //se guarda la hora seleccionada en una variable (puede haber hasta dos)
        if(event.getSource() instanceof Button){
            button = (Button) event.getSource(); 
        }
        
        if(button.equals(clicked1_button) || button.equals(clicked2_button)){
                GridPane grid = map2.get(button);
                grid.setStyle("-fx-background-color: #FFFFFF");
                
                if(button.equals(clicked1_button)){
                    if(clicked2 != -1){
                        clicked1 = clicked2;
                        clicked1_button = clicked2_button;
                        clicked2 = -1;
                        clicked2_button = null;
                    }else{
                        clicked1 = -1;
                        clicked1_button = null;
                    }
                }else{
                    clicked2 = -1;
                    clicked2_button = null;
                }
            }else{
        
                if(clicked1 == -1 || clicked2 == -1){
        

                    String id = button.getId();
                    GridPane grid = map2.get(button);
                    grid.setStyle("-fx-background-color: #D1A7D4");


                    switch(id){
                        case "nine_ten_button": 
                            if(clicked1 != -1){clicked2 = 9; clicked2_button = nine_ten_button;}
                            else{clicked1 = 9; clicked1_button = nine_ten_button;}
                            break;
                        case "ten_eleven_button": 
                            if(clicked1 != -1){clicked2 = 10; clicked2_button = ten_eleven_button;}
                            else{clicked1 = 10; clicked1_button = ten_eleven_button;}
                            break;
                        case "eleven_twelve_button": 
                            if(clicked1 != -1){clicked2 = 11; clicked2_button = eleven_twelve_button;}
                            else{clicked1 = 11; clicked1_button = eleven_twelve_button;}
                            break;
                        case "twelve_thirdteen_button": 
                            if(clicked1 != -1){clicked2 = 12; clicked2_button = twelve_thirdteen_button;}
                            else{clicked1 = 12; clicked1_button = twelve_thirdteen_button;}
                            break;
                        case "thirdteen_fourteen_button": 
                            if(clicked1 != -1){clicked2 = 13; clicked2_button = thirdteen_fourteen_button;}
                            else{clicked1 = 13; clicked1_button = thirdteen_fourteen_button;}
                            break;
                        case "fourteen_fifteen_button": 
                            if(clicked1 != -1){clicked2 = 14; clicked2_button = fourteen_fifteen_button;}
                            else{clicked1 = 14; clicked1_button = fourteen_fifteen_button;}
                            break;
                        case "fifteen_sixteen_button": 
                            if(clicked1 != -1){clicked2 = 15; clicked2_button = fifteen_sixteen_button;}
                            else{clicked1 = 15; clicked1_button = fifteen_sixteen_button;}
                            break;
                        case "sixteen_seventeen_button": 
                            if(clicked1 != -1){clicked2 = 16; clicked2_button = sixteen_seventeen_button;}
                            else{clicked1 = 16; clicked1_button = sixteen_seventeen_button;}
                            break;
                        case "seventeen_eighteen_button": 
                            if(clicked1 != -1){clicked2 = 17; clicked2_button = seventeen_eighteen_button;}
                            else{clicked1 = 17; clicked1_button = seventeen_eighteen_button;}
                            break;
                        case "eighteen_nineteen_button": 
                            if(clicked1 != -1){clicked2 = 18; clicked2_button = eighteen_nineteen_button;}
                            else{clicked1 = 18; clicked1_button = eighteen_nineteen_button;}
                            break;
                        case "nineteen_twenty_button": 
                            if(clicked1 != -1){clicked2 = 19; clicked2_button = nineteen_twenty_button;}
                            else{clicked1 = 19; clicked1_button = nineteen_twenty_button;}
                            break;
                        case "twenty_twentyone_button": 
                            if(clicked1 != -1){clicked2 = 20; clicked2_button = twenty_twentyone_button;}
                            else{clicked1 = 20; clicked1_button = twenty_twentyone_button;}
                            break;
                        case "twentyone_twentytwo_button": 
                            if(clicked1 != -1){clicked2 = 21; clicked2_button = twentyone_twentytwo_button;}
                            else{clicked1 = 21; clicked1_button = twentyone_twentytwo_button;}
                            break;
                    }
            }
         }
        
    }
    
    // CAMBIAR DE PISTA
    @FXML
    private void pista1_toggle_button_clicked(MouseEvent event) {
        pista = "Pista 1";
        title_num_pista_label.setText("01");
        comprobarPista(pista, date);
        restablecerBotones();
    }
    @FXML
    private void pista4_toggle_button_clicked(MouseEvent event) {
        pista = "Pista 4";
        title_num_pista_label.setText("04");
        comprobarPista(pista, date);
        restablecerBotones();
    }
    @FXML
    private void pista2_toggle_button_clicked(MouseEvent event) {
        pista = "Pista 2";
        title_num_pista_label.setText("02");
        comprobarPista(pista, date);
        restablecerBotones();
    }
    @FXML
    private void pista5_toggle_button_clicked(MouseEvent event) {
        pista = "Pista 5";
        title_num_pista_label.setText("05");
        comprobarPista(pista, date);
        restablecerBotones();
    }
    @FXML
    private void pista3_toggle_button_clicked(MouseEvent event) {
        pista = "Pista 3";
        title_num_pista_label.setText("03");
        comprobarPista(pista, date);
        restablecerBotones();
    }
    @FXML
    private void pista6_toggle_button_clicked(MouseEvent event) {
        pista = "Pista 6";
        title_num_pista_label.setText("06");
        comprobarPista(pista, date);
        restablecerBotones();
    }
    
    // CAMBIAR DE FECHA EN EL CALENDARIO
    @FXML
    private void calendar_on_action(ActionEvent event) {
        
        date = calendar_date_picker.getValue();
        resetButtons();
        comprobarPista(pista, date);
        restablecerBotones();
        
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
            if(paid){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                //cambiar el icono
                Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                stage.getIcons().add(new Image(this.getClass().getResourceAsStream("/img/Pelota.png")));
                alert.getDialogPane().setMaxWidth(600);
                alert.getDialogPane().setMinWidth(550);
                alert.getDialogPane().setMaxHeight(200);
                alert.getDialogPane().setMinHeight(150);
                
                //añadir hoja de estilo
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(getClass().getResource("/values/reservarfxml.css").toExternalForm());
                
                //asignar la clase al contenedor principal del diálogo
                alert.getDialogPane().getStyleClass().add("myAlert");
                
                //configurar el contenido del diálogo
                alert.setTitle("Aviso de Reserva");
                alert.setHeaderText("Al darle a aceptar la reserva se pagará automáticamente.");
                alert.setContentText("¿Está seguro de que quiere realizarla?");
                
                
                Optional<ButtonType> result = alert.showAndWait();
                
                    if(result.get() == ButtonType.CANCEL){
                        if(clicked1_button != null){
                            GridPane grip = map2.get(clicked1_button);
                            grip.setStyle("-fx-background-color: #FFFFFF");
                        }
                        if(clicked2_button != null){
                            System.out.println("hay algo el clicked2");
                            GridPane grip = map2.get(clicked2_button);
                            grip.setStyle("-fx-background-color: #FFFFFF");
                        }
                        alert.close();
                    }
                if(result.get() == ButtonType.OK){
                    try{
                        if(clicked2 != -1){
                            club.registerBooking(bookingDate, day, hour, paid, court, member);
                            hour = LocalTime.of(clicked2, 0);
                            club.registerBooking(bookingDate, day, hour, paid, court, member);
                            comprobarPista(pista, date);
                        }else{
                            club.registerBooking(bookingDate, day, hour, paid, court, member);
                            comprobarPista(pista, date);

                        }
                    }catch(Exception e){
                        System.out.println("Problemas en los registros pagados: " + e);
                    }
                }
            }else{
                try{
                    if(clicked2 != -1){
                        club.registerBooking(bookingDate, day, hour, paid, court, member);
                        hour = LocalTime.of(clicked2, 0);
                        club.registerBooking(bookingDate, day, hour, paid, court, member);
                        comprobarPista(pista, date);
                    }else{
                        club.registerBooking(bookingDate, day, hour, paid, court, member);
                        comprobarPista(pista, date);

                    }
                }catch(Exception e){
                    System.out.println("Problemas en los registros sin pagar: " + e);
                }
            }
        }
        
        
        //vuelve a poner el fondo de los botones a blanco
        if(clicked1_button != null){
            GridPane grip = map2.get(clicked1_button);
            grip.setStyle("-fx-background-color: #FFFFFF");
        }
        if(clicked2_button != null){
            GridPane grip = map2.get(clicked2_button);
            grip.setStyle("-fx-background-color: #FFFFFF");
        }
        
        //restablece las variables para próximas reservas
        clicked1 = -1;
        clicked1_button = null;
        clicked2 = -1;
        clicked2_button = null;
        
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
    
    
    
    // CAMBIAR EL CURSOR Y EL COLOR AL PASAR SOBRE UN BOTÓN
    @FXML
    private void button_entered(MouseEvent event) {
        
        Object source = event.getSource();
        if(source instanceof Button){
            Button hour = (Button) source;
            hour.setStyle("-fx-background-color: #98609c");
            utils.cambiarCursor(event, hour);
        }
        
    }
    
    // CANBIAR EL CURSOR Y EL COLOR AL SALIR DEL BOTÓN
    @FXML
    private void button_exited(MouseEvent event) {
        
        Object source = event.getSource();
        if(source instanceof Button){
            Button hour = (Button) source;
            hour.setStyle("-fx-background-color: #822f87");
        }
    }
    
    
    // IR A ACTUALIZAR DATOS
    private void actualizar_datos_clicked(MouseEvent event) {
        
        try{
            Stage stage;
            stage = main.getStage();
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/actualizarDatosFXML.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 1200, 750);
            stage.setScene(scene);
                    
        }catch(Exception e){System.out.println("Problemas en ir aactualizar los datos: " + e);}
        
    }

    // IR A MIS RESERVAS
    private void mis_reservar_clicked(MouseEvent event) {
        
        try{
            Stage stage;
            stage = main.getStage();
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/verMisReservasFXML.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 1200, 750);
            stage.setScene(scene);
                    
        }catch(Exception e){System.out.println("Problemas en el botón a mis reservas: " + e);}
        
    }


    @FXML
    private void cerrar_sesion_clicked(MouseEvent event) {
        
        try{
            // HAY QUE PONER EL MEMBER A NULL, HACE FALTA UN MÉTODO SET MEMBER EN AUTENTICARSE
            
            Stage stage;
            stage = main.getStage();
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/disponibilidadDelDiaFXML.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 1200, 750);
            stage.setScene(scene);
                    
        }catch(Exception e){System.out.println("Problemas en cerrar sesión: " + e);}
        
    }

    @FXML
    private void hour_entered(MouseEvent event) {
        
        Object aux = event.getSource();
        if(aux instanceof Button){
            Button button = (Button) aux;
            Cursor actual = button.getCursor();
            button.setCursor(Cursor.HAND);
        }
    }

    @FXML
    private void run1(MouseEvent event) {
        ir_Ver.setDisable(false);
        ir_Actualizar.setDisable(false);
        ir_Reservar.setDisable(false);
        cerrar_sesion_label.setDisable(false);
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
        ir_Ver.setDisable(true);
        ir_Actualizar.setDisable(true);
        ir_Reservar.setDisable(true);
        cerrar_sesion_label.setDisable(true);
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
                
                stage.getIcons().add(new Image(this.getClass().getResourceAsStream("/img/Pelota.png")));
            
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/actualizarDatosFXML.fxml"));
                Parent root = loader.load();
                  
                Scene scene = new Scene(root, 1200, 750);
                stage.setScene(scene);

                    
            }catch(Exception e){System.out.println("Problemas en ir a actualizar: " + e);}
    }

    @FXML
    private void irVer(MouseEvent event) {
        try{
                Stage stage;
                stage = main.getStage();
                
                stage.getIcons().add(new Image(this.getClass().getResourceAsStream("/img/Pelota.png")));
            
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/verMisReservasFXML.fxml"));
                Parent root = loader.load();
                  
                Scene scene = new Scene(root, 1200, 750);
                stage.setScene(scene);

                    
            }catch(Exception e){System.out.println("Problemas en ir a ver: " + e);}
    }

    @FXML
    private void irReservar(MouseEvent event) {
        try{
                Stage stage;
                stage = main.getStage();
                
                stage.getIcons().add(new Image(this.getClass().getResourceAsStream("/img/Pelota.png")));
            
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/reservarFXML.fxml"));
                Parent root = loader.load();
                  
                Scene scene = new Scene(root, 1200, 750);
                stage.setScene(scene);

                    
            }catch(Exception e){System.out.println("Problemas en ir a reservar: " + e);}
    }


    @FXML
    private void exitReservar(MouseEvent event) {
        Stage stage = (Stage) exit_button_Reservar.getScene().getWindow();
            stage.close();
    }
    
    // BÚSQUEDA
    
    private void buscarHora(String hour){
        
        for(Button button: horasObservable){
            String buscar = String.valueOf(map.get(button));
            if(buscar.startsWith(hour)){
                button.setVisible(true);
                button.setManaged(true);
            }else{
                button.setVisible(false);
                button.setManaged(false);
            }
        }
        
    }
    
    private void verBotones(){
        for(Button button: horasObservable){
            button.setVisible(true);
            button.setManaged(true);
        }
    }

    @FXML
    private void pista_exited(MouseEvent event) {
        Object source = event.getSource();
        if(source instanceof ToggleButton){
            ToggleButton hour = (ToggleButton) source;
            utils.cambiarCursor(event, hour);
        }
    }

    @FXML
    private void pista_entered(MouseEvent event) {
        Object source = event.getSource();
        if(source instanceof ToggleButton){
            ToggleButton hour = (ToggleButton) source;
            utils.devolverCursor(event, hour);
        }
    }
    
    // VOLVER A PONER LOS BOTONES EN COLOR BLANCO
    
    private void restablecerBotones(){
        if(clicked1_button != null){
            clicked1 = -1;
            GridPane grid = map2.get(clicked1_button);
            grid.setStyle("-fx-background-color: #FFFFFF");
        }
        if(clicked2_button != null){
            clicked2 = -1;
            GridPane grid = map2.get(clicked2_button);
            grid.setStyle("-fx-background-color: #FFFFFF");
        }
    }
    
    
}
