/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxmlapplication;

import ipc_project.bookingButton;
import ipc_project.main;
import ipc_project.memberBooking;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.ImagePattern;
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
    @FXML
    private Button exit_button;
    @FXML
    private TableView<memberBooking> bookings_table_view;
    @FXML
    private TableColumn<memberBooking, String> dia_table_column;
    @FXML
    private TableColumn<memberBooking, String> pista_table_column;
    @FXML
    private TableColumn<memberBooking, String> entrada_table_column;
    @FXML
    private TableColumn<memberBooking, String> salida_table_column;
    @FXML
    private TableColumn<memberBooking, String> pagada_table_column;
    @FXML
    private Button cancelar_reserva_button;
    @FXML
    private Label nickname_label;
    
    
    
    
    private ObservableList<Booking> misReservas;
    
    private Club club;
    
    private Member member;
    
    List<memberBooking> bookings = new ArrayList<memberBooking>();
    
    ObservableList<memberBooking> data;

    boolean devolucion = true;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        cancelar_reserva_button.setDisable(true);
        
        
        //Consigue al miembro loggeado e inicializa club
        member = AutenticarseFXMLController.getMember();
        try{club = Club.getInstance(); 
        }catch (ClubDAOException | IOException ex){
            Logger.getLogger(VerMisReservasFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Consigue las reservas del miembro
        String login = member.getNickName();
        List<Booking> bookingList = club.getUserBookings(login);
        
        
        int i = 0;
        for(Booking b: bookingList){
            String pista = b.getCourt().getName();
            String day = "" + b.getMadeForDay().getDayOfMonth();
            String entrada = "" + b.getFromTime().getHour();
            String salida = "" + (b.getFromTime().getHour() + 1);
            String pagada; 
            if(b.getMember().getCreditCard() != null){pagada = "Pagada";}
            else{pagada = "Pendiente de pago";}
            memberBooking mB = new memberBooking(pista, day, entrada, salida, pagada);
            bookings.add(new memberBooking(pista, day, entrada, salida, pagada));
            
            i++;
            if(i >= 10){
                break;
            }
        }
        
        data = FXCollections.observableList(bookings);
        
        
        dia_table_column.setCellValueFactory(new PropertyValueFactory<>("dia"));
        pista_table_column.setCellValueFactory(new PropertyValueFactory<>("pista"));
        entrada_table_column.setCellValueFactory(new PropertyValueFactory<>("horaIni"));
        salida_table_column.setCellValueFactory(new PropertyValueFactory<>("horaFin"));
        pagada_table_column.setCellValueFactory(new PropertyValueFactory<>("pagada"));
        
        /*String css = this.getClass().getResource("/values/table-view.css").toExternalForm();
        bookings_table_view.setStyle(css);*/
        
        bookings_table_view.setItems(data);
        
        // MENÚ
        
        pane_slide.setTranslateX(-490);
        menu_button1.setVisible(true);
        menu_button2.setVisible(false);
        
        // ACTUALIZAR CURSORES
        
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
    
        // PONER DATOS DEL MENÚ
        
        Image selectedFile = member.getImage();
        pictureFrame.setFill(new ImagePattern(selectedFile));
        nickname_label.setText(member.getNickName());
        
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

    @FXML
    private void exit_clicked(MouseEvent event) {
        System.exit(0);
    }
    
    // CANCELAR RESERVA

    @FXML
    private void cancelar_reserva_clicked(MouseEvent event) {
        
        if(!devolucion){
            
        }
        
        
        
        data.remove(bookings_table_view.getSelectionModel().getSelectedItem());
        Booking booking = club.getUserBookings(member.getNickName()).get(bookings_table_view.getSelectionModel().getSelectedIndex());
        try{
            club.removeBooking(booking);
        }catch(Exception e){
            System.out.println("No se ha podido cancelar la reserva: " + e);
        }
        
    }

    @FXML
    private void bookings_clicked(MouseEvent event) {
            if(event.getClickCount() == 1){
                if(bookings_table_view.getSelectionModel().getSelectedIndex() != -1){
                    
                    Booking booking = club.getUserBookings(member.getNickName()).get(bookings_table_view.getSelectionModel().getSelectedIndex());
                    LocalDateTime now = LocalDateTime.now();
                    LocalDateTime date = LocalDateTime.of(booking.getMadeForDay(), booking.getFromTime());
                    
                    LocalDateTime unDia = now.plusHours(24);
                    if(unDia.isAfter(date)){
                        devolucion = false;
                    }else{
                        devolucion = true;
                    }
                    
                    if(date.isAfter(now)){
                        cancelar_reserva_button.setDisable(false);
                    }else{
                        cancelar_reserva_button.setDisable(true);
                    }
                }
            }
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

    
    
}


