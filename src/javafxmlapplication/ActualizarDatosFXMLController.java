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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import model.Member;

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
    private TextField name_text;
    @FXML
    private Text errorMSGT;
    @FXML
    private Button cancelar_button;
    @FXML
    private Button aceptar_edicion_button;
    @FXML
    private Button modificar_button;
    @FXML
    private Label error_name_label;
    private Member m;
    @FXML
    private TextField last_name_text;
    @FXML
    private TextField user_text;
    @FXML
    private TextField phone_text;
    @FXML
    private VBox contraseña_box;
    @FXML
    private PasswordField password_text;
    @FXML
    private VBox confirmacion_box;
    @FXML
    private PasswordField password_comprobar_text;
    @FXML
    private TextField card_text;
    @FXML
    private PasswordField svc_text;
    @FXML
    private Button back_button_actualizar;
    @FXML
    private Button exit_button_actualizar;
    @FXML
    private VBox vbox;
    @FXML
    private TextField password_ver_text;
    @FXML
    private Button ojo_cerrado_button;
    @FXML
    private Button ojo_abierto_button;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        m = AutenticarseFXMLController.getMember();
        aceptar_edicion_button.setVisible(false);
        cancelar_button.setVisible(false);
        contraseña_box.setVisible(false);
        confirmacion_box.setVisible(false);
        name_text.setDisable(true);
        
        name_text.setEditable(false);
        name_text.setText(m.getName());
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

    @FXML
    private void apellidoComprobar(MouseEvent event) {
    }

    @FXML
    private void telefonoComprobar(MouseEvent event) {
    }

    @FXML
    private void contraseñaComprobar(MouseEvent event) {
    }

    @FXML
    private void contraseñaConfirmarContraseña(MouseEvent event) {
    }

    @FXML
    private void tarjetaComprobar(MouseEvent event) {
    }

    @FXML
    private void svcComprobar(MouseEvent event) {
    }

    @FXML
    private void verContraseña(MouseEvent event) {
    }

    @FXML
    private void ocultarContraseña(MouseEvent event) {
    }

    
}

/*a*/
