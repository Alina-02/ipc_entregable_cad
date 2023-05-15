/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxmlapplication;

import com.sun.javafx.logging.PlatformLogger.Level;
import java.io.IOException;
import java.lang.System.Logger;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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
    private TextField userTF;
    private TextField passwordTF;
    
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


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        /*        try{club = Club.getInstance();
        }catch (ClubDAOException ex){
            Logger.getLogger(RegistroFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex){
            Logger.getLogger(RegistroFXMLController.class.getName()).log(Level.SEVERE, null, ex);}*/
    }    

    @FXML
    private void login(ActionEvent event) {
        String name = userTF.getText();
        String password = passwordTF.getText();
        /*if(Club.getMemberByCredentials(name, password) instanceof Member){
            
            }*/
            
    }

    @FXML
    private void registerUser(MouseEvent event) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/registroFXML.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }    }

    @FXML
    private void iniciar_sesion_clicked(MouseEvent event) {
    }
}
