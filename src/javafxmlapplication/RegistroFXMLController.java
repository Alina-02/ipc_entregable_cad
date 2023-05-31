

package javafxmlapplication;

import ipc_project.main;
import ipc_project.utils;
import java.io.File;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import model.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
    private Member m;
    
    private boolean contraseñaEditado;
    
    String nm;
    String sn;
    String us;
    String pn;
    String cc;
    String pw;
    String pwc;

    private Image defaultImageAux;
   
    static boolean registroGo = false;
    @FXML
    private Button menu_button1;
    @FXML
    private Circle pictureFrame2;
    @FXML
    private Button mensaje_foto;
    @FXML
    private VBox fotos_menu;
    @FXML
    private Button subir_foto_button;
    @FXML
    private AnchorPane pane_slide;
    @FXML
    private Button menu_button2;
    @FXML
    private Circle pictureFrame1;
    @FXML
    private Label nickname_label;
    @FXML
    private Button ir_Actualizar;
    @FXML
    private Button ir_Ver;
    @FXML
    private Button ir_Reservar;
    @FXML
    private Label cerrar_sesion_label;
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
    @FXML
    private VBox confirmacion_box;
    @FXML
    private Label error_confirmacion_label;
    @FXML
    private Label error_tarjeta_label;
    @FXML
    private Label error_svc_label;
    @FXML
    private Label general_error_label;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //miembro acutal
        m = AutenticarseFXMLController.getMember();
        
        //inicializo variables
        contraseñaEditado = false;
        nickname_label.setText(m.getNickName());
        
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

        user_text.setEditable(false);
        
        //Conexion bidireccional entre el textfield de la contraseña con la opcion para verla
        password_text.textProperty().bindBidirectional(password_ver_text.textProperty());
        
        // COLOCAR FOTO DE PERFIL
        Image selectedFile = m.getImage();
        pictureFrame.setFill(new ImagePattern(selectedFile));
        pictureFrame2.setFill(Color.WHITE);
        pictureFrame.setStrokeWidth(0);
        pictureFrame2.setStrokeWidth(20);
        pictureFrame2.setStroke(Color.WHITE);
        
        
        pictureFrame.setOnMouseEntered(event -> mensaje_foto.setVisible(true));
        mensaje_foto.setOnMouseExited(event -> mensaje_foto.setVisible(false));
        
        
        
        
        
        Shadow shadow = new Shadow();
        shadow.setColor(Color.GREY); 
        shadow.setBlurType(BlurType.GAUSSIAN); 
        
        try{
        Image image = new Image(getClass().getResourceAsStream("img/Avatar.jpg"));
        System.out.println("eyey");
        pictureFrame.setFill(new ImagePattern(image));
        }catch(Exception e){System.out.println("la imagen guachin");}
        
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
        pictureFrame.setOnMouseEntered(event ->{
               pictureFrame.setCursor(Cursor.HAND);
               pictureFrame.setOpacity(0.75);
        });
         pictureFrame.setOnMouseExited(event ->{
               pictureFrame.setCursor(Cursor.DEFAULT);
               pictureFrame.setOpacity(1);
        });
         register_button.disableProperty().bind(name_text.textProperty().isEmpty().or(last_name_text.textProperty().isEmpty()).or(user_text.textProperty().isEmpty()).or(phone_text.textProperty().isEmpty()).or(password_text.textProperty().isEmpty()).or(password_comprobar_text.textProperty().isEmpty()));
         
    }    

    @FXML
    private void showChange(MouseEvent event){
    }

    @FXML
    private void changeProfile(MouseEvent event) {
        //Cuestiones para abrir los archivos
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Abrir fichero");
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Imágenes", "*.png", "*.jpg", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(((Node)event.getSource()).getScene().getWindow());
        //Para colocar la imagen 
        Label label = new Label();
        if (selectedFile != null){label.setText(selectedFile.getAbsolutePath());}
        String fn = label.getText();
        im = new Image(fn);
        pictureFrame.setFill(new ImagePattern(im));
        //Para gaurdarla en el perfil del usuario
        if(club.existsLogin(user_text.getText())){
            club.getMemberByCredentials(user_text.getText(), password_text.getText()).setImage(im);
        }
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
        if(contraseñaEditado){
        if(!password_comprobar_text.getText().isEmpty()){
        if(!utils.confirmacionBien(password_text.getText(),password_comprobar_text.getText())){
            error_confirmacion_label.setVisible(true);
        }else {error_confirmacion_label.setVisible(false); }
        }
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
    private void passClick(MouseEvent event) {
        contraseñaEditado = true;
        confirmacion_box.setVisible(true);
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
    private void seleccionarFoto(MouseEvent event) {
        fotos_menu.setVisible(true);
    }

    @FXML
    private void selectAvatar(MouseEvent event) {
        
        Button b = (Button) event.getSource();
        Image avatar = ((ImageView) b.getGraphic()).getImage();
        pictureFrame.setFill(new ImagePattern(avatar));
        AutenticarseFXMLController.getMember().setImage(avatar);
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
        Image im = new Image(fn);
        pictureFrame.setFill(new ImagePattern(im));
        AutenticarseFXMLController.getMember().setImage(im);
    }

    @FXML
    private void aparecer(MouseEvent event) {
        //mensaje_foto.setVisible(true);
        
        
    }

    @FXML
    private void closeMenuAvatares(MouseEvent event) {
        fotos_menu.setVisible(false);
    }


   
    


    @FXML
    private void irActualizar(MouseEvent event) {
    }

    @FXML
    private void irVer(MouseEvent event) {
    }

    @FXML
    private void irReservar(MouseEvent event) {
    }

    @FXML
    private void cerrar_sesion_clicked(MouseEvent event) {
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


}

