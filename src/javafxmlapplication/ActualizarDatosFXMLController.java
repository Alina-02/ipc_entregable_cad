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
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import model.Member;
import javafx.scene.Scene;

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
    private Button ojo_cerrado_button;
    @FXML
    private Button ojo_abierto_button;
    @FXML
    private TextField password_ver_text;
    
       private Member m;
    
    @FXML
    private VBox vbox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //miembro acutal
        m = AutenticarseFXMLController.getMember();
        //quitar la visibilidad de los botones
        aceptar_edicion_button.setVisible(false);
        cancelar_button.setVisible(false);
        confirmacion_box.setVisible(false);
        ojo_abierto_button.setVisible(false);
        password_ver_text.setVisible(false);
        
        //quitar el evento del raton en los botones
        name_text.setMouseTransparent(true);
        last_name_text.setMouseTransparent(true);
        phone_text.setMouseTransparent(true);
        password_text.setMouseTransparent(true);
        card_text.setMouseTransparent(true);
        svc_text.setMouseTransparent(true);
        
        
        //cambiar el cursor
        back_button_actualizar.setOnMouseEntered(event -> {
                back_button_actualizar.setCursor(Cursor.HAND);
        });
        
        back_button_actualizar.setOnMouseExited(event ->{
                back_button_actualizar.setCursor(Cursor.DEFAULT);
        });
        exit_button_actualizar.setOnMouseEntered(event -> {
                exit_button_actualizar.setCursor(Cursor.HAND);
        });
        
        exit_button_actualizar.setOnMouseExited(event ->{
                exit_button_actualizar.setCursor(Cursor.DEFAULT);
        });
        ojo_cerrado_button.setOnMouseEntered(event -> {
                ojo_cerrado_button.setCursor(Cursor.HAND);
        });
        
        ojo_cerrado_button.setOnMouseExited(event ->{
                ojo_cerrado_button.setCursor(Cursor.DEFAULT);
        });
        ojo_abierto_button.setOnMouseEntered(event -> {
                ojo_abierto_button.setCursor(Cursor.HAND);
        });
        
        ojo_abierto_button.setOnMouseExited(event ->{
                ojo_abierto_button.setCursor(Cursor.DEFAULT);
        });
        cancelar_button.setOnMouseEntered(event -> {
                cancelar_button.setCursor(Cursor.HAND);
        });
        
        cancelar_button.setOnMouseExited(event ->{
                cancelar_button.setCursor(Cursor.DEFAULT);
        });
        aceptar_edicion_button.setOnMouseEntered(event -> {
                aceptar_edicion_button.setCursor(Cursor.HAND);
        });
        
        aceptar_edicion_button.setOnMouseExited(event ->{
                aceptar_edicion_button.setCursor(Cursor.DEFAULT);
        });
        modificar_button.setOnMouseEntered(event -> {
                modificar_button.setCursor(Cursor.HAND);
        });
        
        modificar_button.setOnMouseExited(event ->{
                modificar_button.setCursor(Cursor.DEFAULT);
        });
        
        
        name_text.setEditable(false);
        name_text.setText(m.getName());
        last_name_text.setEditable(false);
        last_name_text.setText(m.getSurname());
        user_text.setEditable(false);
        user_text.setText(m.getNickName());
        phone_text.setEditable(false);
        phone_text.setText(m.getTelephone());
        password_text.setEditable(false);
        password_text.setText(m.getPassword());
        card_text.setEditable(false);
        card_text.setText(m.getCreditCard());
        svc_text.setEditable(false);
        svc_text.setText(String.valueOf(m.getSvc()));
        password_ver_text.setText(m.getPassword());
        
        
        /**name_text.focusedProperty().addListener((observable, oldValue, newValue) ->{
            if (!newValue) {
                System.out.println(utils.nombreBien(name_text.getText()));
            }
        });*/
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
        //habilito la visibilidad de algunos botones
        cancelar_button.setVisible(true);
        aceptar_edicion_button.setVisible(true);
        modificar_button.setVisible(false);
        confirmacion_box.setVisible(true);
        
        //habilito que pueda editar los espacios te texto
        name_text.setEditable(true);
        last_name_text.setEditable(true);
        user_text.setEditable(true);
        phone_text.setEditable(true);
        password_text.setEditable(true);
        card_text.setEditable(true);
        svc_text.setEditable(true);
        
        //habilito las acciones de raton sobre los campos de texto
        name_text.setMouseTransparent(false);
        last_name_text.setMouseTransparent(false);
        phone_text.setMouseTransparent(false);
        password_text.setMouseTransparent(false);
        card_text.setMouseTransparent(false);
        svc_text.setMouseTransparent(false);
        
        //cambio la hoja de estilo para los campos de texto
        name_text.getStyleClass().remove("visualizar-text");
        last_name_text.getStyleClass().remove("visualizar-text");
        phone_text.getStyleClass().remove("visualizar-text");
        card_text.getStyleClass().remove("visualizar-text");
        svc_text.getStyleClass().remove("visualizar-text");
        password_text.getStyleClass().remove("visualizar-text");
        password_comprobar_text.getStyleClass().remove("visualizar-text");
        password_ver_text.getStyleClass().remove("visualizar-text");
        
        name_text.getStyleClass().add("basic-text");
        last_name_text.getStyleClass().add("basic-text");
        phone_text.getStyleClass().add("basic-text");
        card_text.getStyleClass().add("basic-text");
        svc_text.getStyleClass().add("basic-text");
        password_comprobar_text.getStyleClass().add("basic-text");
        password_ver_text.getStyleClass().add("basic-text");
        password_text.getStyleClass().add("basic-text");

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
        ojo_cerrado_button.setVisible(false);
        ojo_abierto_button.setVisible(true);
        password_ver_text.setVisible(true);
    }

    @FXML
    private void ocultarContraseña(MouseEvent event) {
        ojo_cerrado_button.setVisible(true);
        ojo_abierto_button.setVisible(false);
        password_ver_text.setVisible(false);
    }

    @FXML
    private void nombreComprobar(MouseEvent event) {
        if(!name_text.getText().isEmpty()){
        if(!utils.nombreBien(name_text.getText())){
            error_name_label.setVisible(true);
        }else error_name_label.setVisible(false);  
        }
            
    }
   

    
}

