/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxmlapplication;

import ipc_project.utils;
import javafx.scene.image.Image;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author nymok
 */
public class ActualizarDatosFXMLController implements Initializable {

    private Circle user_image_circle;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Circle pictureFrame;
    @FXML
    private TextField lastNameTF;
    @FXML
    private TextField userTF;
    @FXML
    private TextField phoneTF;
    @FXML
    private PasswordField passwordTF;
    @FXML
    private PasswordField passwordCTF;
    @FXML
    private TextField creditCardTF;
    @FXML
    private PasswordField svcPF;
    @FXML
    private Button back_button_registro;
    @FXML
    private Button exit_button_registro;
    @FXML
    private TextField name_text;
    @FXML
    private Text errorMSGT;
    @FXML
    private Button cancelar_button;
    @FXML
    private Button aceptar_edicion_button;
    @FXML
    private Button modificar_button;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  
    }    

    @FXML
    private void showChange(MouseEvent event) {
    }

    @FXML
    private void changePF(MouseEvent event) {
    }

    @FXML
    private void changeProfile(MouseEvent event) {
    }

    @FXML
    private void backRegistro(MouseEvent event) {
    }

    @FXML
    private void back(ActionEvent event) {
    }

    @FXML
    private void exitRegistro(MouseEvent event) {
    }

    @FXML
    private void exit(ActionEvent event) {
    }

    
    @FXML
    private void cancelarEdicion(MouseEvent event) {
    }

    @FXML
    private void aceptar_Datos(MouseEvent event) {
    }

    @FXML
    private void modificarDatos(MouseEvent event) {
    }

    

    @FXML
    private void nombreComprobar(MouseEvent event) {
        System.out.println(utils.nombreBien(name_text.getText()));
    }

    
}

/*a*/
