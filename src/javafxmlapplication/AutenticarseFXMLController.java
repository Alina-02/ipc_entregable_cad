/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxmlapplication;

import com.sun.javafx.logging.PlatformLogger.Level;
import ipc_project.main;
import java.io.IOException;
import java.lang.System.Logger;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.*;

/**
 * FXML Controller class
 *
 * @author nymok
 */
public class AutenticarseFXMLController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    
    private Club club;
    @FXML
    private TextField usuario_text_field;
    @FXML
    private TextField contraseña_text_field;
    @FXML
    private Button inicia_sesion_button;
    @FXML
    private Text registrarse_text;
    @FXML
    private Label usuario_mal_button;
    @FXML
    private Label contraseña_mal_button;
    @FXML
    private Button exit_button_autenticarse;
    @FXML
    private Button back_button_autenticarse;
    
    private static Member member;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
            club = Club.getInstance();
        }catch (ClubDAOException | IOException ex)
        {java.util.logging.Logger.getLogger(AutenticarseFXMLController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}
        
        // ESTABLECER TODOS LOS BOTONES
        
        inicia_sesion_button.setOnMouseEntered(event -> {
                inicia_sesion_button.setCursor(Cursor.HAND);
        });
        
        inicia_sesion_button.setOnMouseExited(event ->{
                inicia_sesion_button.setCursor(Cursor.DEFAULT);
        });
        registrarse_text.setOnMouseEntered(event -> {
                registrarse_text.setCursor(Cursor.HAND);
                registrarse_text.setStyle("-fx-fill: #abbb35");
        });
        
        registrarse_text.setOnMouseExited(event ->{
                registrarse_text.setCursor(Cursor.DEFAULT);
                registrarse_text.setStyle("-fx-fill: BLACK");
        });
        
        exit_button_autenticarse.setOnMouseEntered(event -> {
                exit_button_autenticarse.setCursor(Cursor.HAND);
        });
        
        exit_button_autenticarse.setOnMouseExited(event ->{
                exit_button_autenticarse.setCursor(Cursor.DEFAULT);
        });
        back_button_autenticarse.setOnMouseEntered(event -> {
                back_button_autenticarse.setCursor(Cursor.HAND);
        });
        
        back_button_autenticarse.setOnMouseExited(event ->{
                back_button_autenticarse.setCursor(Cursor.DEFAULT);
        });
        
    }   
    
    // VOLVER A VER DISPONIBILIDAD
    
    @FXML
    private void backAutenticarse(MouseEvent event) {
        try{
                Stage stage;
                stage = main.getStage();
                
                stage.getIcons().add(new Image(this.getClass().getResourceAsStream("/img/Pelota.png")));
            
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/disponibilidadDelDiaFXML.fxml"));
                Parent root = loader.load();
                  
                Scene scene = new Scene(root, 1200, 750);
                stage.setScene(scene);

                    
            }catch(Exception e){System.out.println("Fallo en backAutenticarse: " + e);}
    }

    // SALIR DEL PROGRAMA
    
    @FXML
    private void exitAutenticarse(MouseEvent event) {
        Stage stage = (Stage) exit_button_autenticarse.getScene().getWindow();
        stage.close();
    }
    
    // COMPROBAR QUE EXISTE EL USUARIO E IR A RESERVAR PISTA

    @FXML
    private void iniciar_sesion_clicked(MouseEvent event) {
        usuario_mal_button.setVisible(false);
        contraseña_mal_button.setVisible(false);
        
        String nickname = usuario_text_field.getText();
        String password = contraseña_text_field.getText();
        List<Member> members = club.getMembers();
        //List<Member> iterator = members.iterator();
        Boolean esta = false;
        Boolean contraseñaCorrecta = false;
        for(Member member: members){
            String existe = member.getNickName();
            String contraseña = member.getPassword();
            if(existe.equals(nickname) && contraseña.equals(password)){
                esta = true;
                contraseñaCorrecta = true;
                break;
            }else if(existe.equals(nickname) && !contraseña.equals(password)){
                esta = true;
                break;
            }    
        }
        
        if(esta && contraseñaCorrecta){
            //hay que comprobar si la contraseña es correcta
            
            member = club.getMemberByCredentials(nickname, password);
            try{
                Stage stage;
                stage = main.getStage();
            
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/reservarFXML.fxml"));
                Parent root = loader.load();
                  
                Scene scene = new Scene(root, 1200, 750);
                stage.setScene(scene);

                    
            }catch(Exception e){System.out.println(e);}
        
        }else if(!esta){
            usuario_mal_button.setVisible(true);
        }else{
            contraseña_mal_button.setVisible(true);
        }
    }

    // IR A LA PANTALLA DE REGISTRAR USUARIO
    
    @FXML
    private void registerUser(MouseEvent event) {
        try{
            Stage stage;
            stage = main.getStage();
            
            FXMLLoader loader= new  FXMLLoader(getClass().getResource("/views/registroFXML.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 1200,750);
            stage.setScene(scene);
            
        }catch(Exception e){System.out.println("Fallo en registerUser: " + e);}
    }
    
    public static Member getMember(){
        return member;
    }
}
