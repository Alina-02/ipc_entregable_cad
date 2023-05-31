

package javafxmlapplication;

import com.sun.tools.javac.Main;
import ipc_project.main;
import ipc_project.utils;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.Glow;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import model.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
//import img.*;

/**
 * FXML Controller class
 *
 * @author dantr
 */
public class RegistroFXMLController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Circle pictureFrame;
    @FXML
    private Button exit_button_registro;
    @FXML
    private TextField name_text;
    @FXML
    private TextField last_name_text;
    @FXML
    private TextField user_text;
    @FXML
    private TextField phone_text;
    @FXML
    private PasswordField password_text;
    @FXML
    private TextField card_text;
    @FXML
    private Button register_button;
    private Club club;
    private Image im;
    
    
    @FXML
    private PasswordField password_comprobar_text;
    @FXML
    private PasswordField svc_text;
    //Variables extra
   
    static boolean registroGo = false;
    @FXML
    private Circle pictureFrame2;
    @FXML
    private Button mensaje_foto;
    @FXML
    private VBox fotos_menu;
    @FXML
    private Button subir_foto_button;
    @FXML
    private Button back_button_actualizar;
    @FXML
    private Label error_name_label;
    @FXML
    private Label error_last_label;
    @FXML
    private Label error_phone_label;
    @FXML
    private VBox contraseña_box;
    @FXML
    private Label error_passwor_label;
    @FXML
    private TextField password_ver_text;
    @FXML
    private Button ojo_cerrado_button;
    @FXML
    private Button ojo_abierto_button;
    private VBox confirmacion_box;
    @FXML
    private Label error_confirmacion_label;
    @FXML
    private Label error_tarjeta_label;
    @FXML
    private Label error_svc_label;
    @FXML
    private Label general_error_label;
    private Label error_vario;
    @FXML
    private Label error_nickname_label;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
              
        //miembro acutal
        
        //Quitar la visibilidad de los botones
        ojo_abierto_button.setVisible(false);
        password_ver_text.setVisible(false); 
        
        
        //Cambiar el cursor
        back_button_actualizar.setOnMouseEntered(event -> {
                back_button_actualizar.setCursor(Cursor.HAND);
        });
        
        back_button_actualizar.setOnMouseExited(event ->{
                back_button_actualizar.setCursor(Cursor.DEFAULT);
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


        //Conexion bidireccional entre el textfield de la contraseña con la opcion para verla
        password_text.textProperty().bindBidirectional(password_ver_text.textProperty());
        
        // COLOCAR FOTO DE PERFIL
        
        Image image = new Image("img/pngwing.com (1).png");
        im = image;
        
        pictureFrame.setFill(new ImagePattern(im));
        pictureFrame2.setFill(Color.WHITE);
        pictureFrame.setStrokeWidth(0);
        pictureFrame2.setStrokeWidth(20);
        pictureFrame2.setStroke(Color.WHITE);
        mensaje_foto.setVisible(false);
        pictureFrame.setOnMouseEntered(event -> mensaje_foto.setVisible(true));
        mensaje_foto.setOnMouseExited(event -> mensaje_foto.setVisible(false));
        
        
        
        try{club = Club.getInstance();
        }catch (ClubDAOException ex){
            Logger.getLogger(RegistroFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex){
            Logger.getLogger(RegistroFXMLController.class.getName()).log(Level.SEVERE, null, ex);}
       
        
        exit_button_registro.setOnMouseEntered(event -> {
                exit_button_registro.setCursor(Cursor.HAND);
        });
        
        exit_button_registro.setOnMouseExited(event ->{
               exit_button_registro.setCursor(Cursor.DEFAULT);
        });
        register_button.setOnMouseEntered(event -> {
                register_button.setCursor(Cursor.HAND);
        });
        
        register_button.setOnMouseExited(event ->{
               register_button.setCursor(Cursor.DEFAULT);
        });
       
         register_button.disableProperty().bind(name_text.textProperty().isEmpty().or(last_name_text.textProperty().isEmpty()).or(user_text.textProperty().isEmpty()).or(phone_text.textProperty().isEmpty()).or(password_text.textProperty().isEmpty()).or(password_comprobar_text.textProperty().isEmpty()));
         errores(false);
    }    


       @FXML
    private void backRegistro(MouseEvent event) {
        try{
            if(AutenticarseFXMLController.getAutenticarseGo()){
                AutenticarseFXMLController.setAutenticarseGo(false);
                Stage stage;
                stage = main.getStage();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/AutenticarseFXML.fxml"));
                Parent root = loader.load();

                stage.getScene().setRoot(root);
                
            }else if(DisponibilidadDelDiaFXMLController.getDisponibilidadGo()){
                DisponibilidadDelDiaFXMLController.setDisponibilidadGo(false);
                Stage stage;
                stage = main.getStage();
            
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/DisponibilidadDelDiaFXML.fxml"));
                Parent root = loader.load();
                  
                stage.getScene().setRoot(root);
                }
            
            }catch(Exception e){System.out.println(e);}
    }

    private void exitRegistro(MouseEvent event) {
        Stage stage = (Stage) exit_button_registro.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void registerMember(ActionEvent event) throws ClubDAOException {
       
        if(bien() && !register_button.isDisable()){
            general_error_label.setVisible(false);
            club.registerMember(name_text.getText(), last_name_text.getText(), phone_text.getText(), user_text.getText(), password_text.getText(), card_text.getText(),Integer.valueOf(svc_text.getText()), im);
            usuarioRegistrado();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
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
                alert.setTitle("Registro");
                alert.setHeaderText("Registro en curso.");
                alert.setContentText("Se ha completado su registro, a continuacion inicie sesion para reservar.");
                
                
                Optional<ButtonType> result = alert.showAndWait();
                alert.close();
        }else general_error_label.setVisible(true);
        
    }
 
    private void usuarioRegistrado() {
        try{
                registroGo = true;
                Stage stage;
                stage = main.getStage();
            
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/autenticarseFXML.fxml"));
                Parent root = loader.load();
                
                stage.getScene().setRoot(root);
                    
            }catch(Exception e){System.out.println(e);}
        
    }
    
    public static boolean getRegistroGo(){
        return registroGo;
    }
    
    public static void setRegistroGo(boolean bool){
        registroGo = bool;
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
    @FXML
    private void nickNameComprobar(MouseEvent event) {
        if(!user_text.getText().isEmpty()){
        if(club.existsLogin(user_text.getText())){
            error_nickname_label.setVisible(true);
        }else error_nickname_label.setVisible(false);  
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
    private void seleccionarFoto(MouseEvent event) {
        fotos_menu.setVisible(true);
    }

    @FXML
    private void selectAvatar(MouseEvent event) {
        
        Button b = (Button) event.getSource();
        Image avatar = ((ImageView) b.getGraphic()).getImage();
        pictureFrame.setFill(new ImagePattern(avatar));
        im = avatar;
    }

    @FXML
    private void subirFoto(MouseEvent event) {
        //Cuestiones para abrir los archivos
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Abrir fichero");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Imágenes", "*.png", "*.jpg", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(((Node)event.getSource()).getScene().getWindow());
        //Para colocar la imagen 
        Label label = new Label();
        if (selectedFile != null){label.setText(selectedFile.getAbsolutePath());}
        String fn = label.getText();
        im = new Image(fn);
        pictureFrame.setFill(new ImagePattern(im));
    }

    @FXML
    private void aparecer(MouseEvent event) {
        mensaje_foto.setVisible(true);
        
        
    }

    @FXML
    private void closeMenuAvatares(MouseEvent event) {
        fotos_menu.setVisible(false);
    }


    @FXML
    private void back(ActionEvent event) {
    }

    @FXML
    private void exitActualizar(MouseEvent event) {
    }

    @FXML
    private void exit(ActionEvent event) {
    }
    
    public void errores(boolean b){
        error_name_label.setVisible(b);
        error_last_label.setVisible(b);
        error_passwor_label.setVisible(b);
        error_confirmacion_label.setVisible(b);
        error_tarjeta_label.setVisible(b);
        error_phone_label.setVisible(b);
        general_error_label.setVisible(b);
        error_svc_label.setVisible(b);
        error_nickname_label.setVisible(b);
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
    

}

