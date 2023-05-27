/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxmlapplication;

import ipc_project.utils;
import javafx.scene.image.Image;
import java.net.URL;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nymok
 */
public class ActualizarDatosFXMLController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Circle pictureFrame;
    @FXML
    private TextField name_text;
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
    
    @FXML
    private Label error_last_label;
    @FXML
    private Label error_passwor_label;
    @FXML
    private Label error_confirmacion_label;
    @FXML
    private Label error_tarjeta_label;
    @FXML
    private Label error_svc_label;
    private Member m;
    @FXML
    private Label error_phone_label;
    @FXML
    private Label general_error_label;
   

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
        error_name_label.setVisible(false);
        error_last_label.setVisible(false);
        error_passwor_label.setVisible(false);
        error_confirmacion_label.setVisible(false);
        error_tarjeta_label.setVisible(false);
        error_svc_label.setVisible(false);
        error_phone_label.setVisible(false);
        general_error_label.setVisible(false);
        
        //quitar el evento del raton en los botones
        accionRaton(true);
        
        
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
        
        
        datosNormales();
        esEditable(false);
        user_text.setEditable(false);
        
        
        password_text.textProperty().bindBidirectional(password_ver_text.textProperty());

    }


    @FXML
    private void backRegistro(MouseEvent event) {
    }

    @FXML
    private void back(ActionEvent event) {
    }


    @FXML
    private void exit(ActionEvent event) {
    }

    
    
    @FXML
    private void cancelarEdicion(MouseEvent event) {
        //habilito la visibilidad de algunos botones
        cancelar_button.setVisible(false);
        aceptar_edicion_button.setVisible(false);
        modificar_button.setVisible(true);
        confirmacion_box.setVisible(false);
        
        //habilito que no pueda editar los espacios te texto
        esEditable(false);
        
        //habilito las acciones de raton sobre los campos de texto
        accionRaton(false);
        
        //cambio la hoja de estilo para los campos de texto
        cambioEstilo(basico, visualizar);
        datosNormales();
        
    }
    

    @FXML
    private void aceptar_Datos(MouseEvent event) {
        if(bien()){
            general_error_label.setVisible(false);
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
                alert.setTitle("Actualizacion de datos");
                alert.setContentText("¿Está seguro de que quiere modificar sus datos?");
                
                
                Optional<ButtonType> result = alert.showAndWait();
               
                    if(result.get() == ButtonType.OK){
                        AutenticarseFXMLController.getMember().setName(name_text.getText());
                        AutenticarseFXMLController.getMember().setSurname(last_name_text.getText());
                        AutenticarseFXMLController.getMember().setTelephone(phone_text.getText());
                        AutenticarseFXMLController.getMember().setPassword(password_text.getText());
                        AutenticarseFXMLController.getMember().setCreditCard(card_text.getText());
                        AutenticarseFXMLController.getMember().setSvc(Integer.valueOf(svc_text.getText()));
                        //habilito la visibilidad de algunos botones
                        cancelar_button.setVisible(false);
                        aceptar_edicion_button.setVisible(false);
                        modificar_button.setVisible(true);
                        confirmacion_box.setVisible(false);

                        //habilito que pueda editar los espacios te texto
                        esEditable(false);

                        //habilito las acciones de raton sobre los campos de texto
                        accionRaton(false);

                        //cambio la hoja de estilo para los campos de texto
                        cambioEstilo(basico, visualizar);
                    } else{
                        cancelarEdicion(event);
                    }
                    alert.close();
            
        }else general_error_label.setVisible(true);
     
    }

    @FXML
    private void modificarDatos(MouseEvent event) {
        //habilito la visibilidad de algunos botones
        cancelar_button.setVisible(true);
        aceptar_edicion_button.setVisible(true);
        modificar_button.setVisible(false);
        confirmacion_box.setVisible(true);
        
        //habilito que pueda editar los espacios te texto
        esEditable(true);
        
        //habilito las acciones de raton sobre los campos de texto
        accionRaton(false);
        
        //cambio la hoja de estilo para los campos de texto
        cambioEstilo(visualizar,basico);
    }
    
    //Metodos para comprobar los campos
    @FXML
    private void nombreComprobar(MouseEvent event) {
        if(!name_text.getText().isEmpty()){
        if(!utils.textBien(name_text.getText())){
            error_name_label.setVisible(true);
        }else error_name_label.setVisible(false);  
        }
            
    }

    @FXML
    private void apellidoComprobar(MouseEvent event) {
        if(!last_name_text.getText().isEmpty()){
        if(!utils.textBien(last_name_text.getText())){
            error_last_label.setVisible(true);
        }else error_last_label.setVisible(false);  
        }
    }

    @FXML
    private void telefonoComprobar(MouseEvent event) {
        if(!phone_text.getText().isEmpty()){
        if(!utils.numberBien(phone_text.getText(),9)){
            error_phone_label.setVisible(true);
        }else error_phone_label.setVisible(false);  
        }
    }

    @FXML
    private void contraseñaComprobar(MouseEvent event) {
        if(!password_text.getText().isEmpty()){
        if(!utils.contraseñaBien(password_text.getText())){
            error_passwor_label.setVisible(true);
        }else error_passwor_label.setVisible(false);  
        }
    }

    @FXML
    private void contraseñaConfirmarContraseña(MouseEvent event) {
        if(!password_comprobar_text.getText().isEmpty()){
        if(!utils.confirmacionBien(password_text.getText(),password_comprobar_text.getText())){
            error_confirmacion_label.setVisible(true);
        }else {error_confirmacion_label.setVisible(false); }
        }
    }

    @FXML
    private void tarjetaComprobar(MouseEvent event) {
        if(!card_text.getText().isEmpty()){
        if(!utils.numberBien(card_text.getText(),16)){
            error_tarjeta_label.setVisible(true);
        }else error_tarjeta_label.setVisible(false);  
        }
    }

    @FXML
    private void svcComprobar(MouseEvent event) {
        if(!svc_text.getText().isEmpty()){
        if(!utils.numberBien(svc_text.getText(),3)){
            error_svc_label.setVisible(true);
        }else error_svc_label.setVisible(false);  
        }
    }
    
    
    
    //Ver contraseña

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
    private void exitActualizar(MouseEvent event) {
        Stage stage = (Stage) exit_button_actualizar.getScene().getWindow();
        stage.close();
    }
    
    
    
    
    public boolean bien(){
        if(!utils.textBien(name_text.getText())) return false; 
        if(!utils.textBien(last_name_text.getText())) return false; 
        if(!utils.numberBien(phone_text.getText(),9)) return false; 
        if(!utils.contraseñaBien(password_text.getText())) return false; 
        if(!utils.confirmacionBien(password_text.getText(),password_comprobar_text.getText())) return false;
        if(!utils.numberBien(card_text.getText(),16)) return false; 
        if(!utils.numberBien(svc_text.getText(),3)) return false;
        return true;
    }
    
    private String visualizar = "visualizar-text";
    private String basico = "basic-text";
    public void cambioEstilo(String r, String a){
        name_text.getStyleClass().remove(r);
        last_name_text.getStyleClass().remove(r);
        phone_text.getStyleClass().remove(r);
        card_text.getStyleClass().remove(r);
        svc_text.getStyleClass().remove(r);
        password_text.getStyleClass().remove(r);
        password_comprobar_text.getStyleClass().remove(r);
        password_ver_text.getStyleClass().remove(r);
        
        name_text.getStyleClass().add(a);
        last_name_text.getStyleClass().add(a);
        phone_text.getStyleClass().add(a);
        card_text.getStyleClass().add(a);
        svc_text.getStyleClass().add(a);
        password_comprobar_text.getStyleClass().add(a);
        password_ver_text.getStyleClass().add(a);
        password_text.getStyleClass().add(a);
        
    }
     public void esEditable(boolean b){
        name_text.setEditable(b);
        last_name_text.setEditable(b);
        phone_text.setEditable(b);
        password_text.setEditable(b);
        card_text.setEditable(b);
        svc_text.setEditable(b);
        password_ver_text.setEditable(b);
        password_text.setEditable(b);
    }
      public void datosNormales(){
        name_text.setText(m.getName());
        last_name_text.setText(m.getSurname());
        user_text.setText(m.getNickName());
        phone_text.setText(m.getTelephone());
        password_text.setText(m.getPassword());
        card_text.setText(m.getCreditCard());
        svc_text.setText(String.valueOf(m.getSvc()));
        password_ver_text.setText(m.getPassword());
    }
      public void accionRaton(boolean b){
        /*name_text.setMouseTransparent(b);
        last_name_text.setMouseTransparent(b);
        phone_text.setMouseTransparent(b);
        password_text.setMouseTransparent(b);
        card_text.setMouseTransparent(b);
        svc_text.setMouseTransparent(b);*/
    }
    
    
}

