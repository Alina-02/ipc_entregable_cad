/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxmlapplication;

import com.sun.tools.javac.Main;
import ipc_project.main;
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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
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
import javafx.stage.Stage;

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
    private Button back_button_registro;
    @FXML
    private Button exit_button_registro;
    @FXML
    private TextField nameTF;
    @FXML
    private TextField lastNameTF;
    @FXML
    private TextField userTF;
    @FXML
    private TextField phoneTF;
    @FXML
    private PasswordField passwordTF;
    @FXML
    private TextField creditCardTF;
    @FXML
    private TextField cvvTF;
    @FXML
    private Button register_button;
    
    private Club club;
    private Image im;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{club = Club.getInstance();
        }catch (ClubDAOException ex){
            Logger.getLogger(RegistroFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex){
            Logger.getLogger(RegistroFXMLController.class.getName()).log(Level.SEVERE, null, ex);}
    
        back_button_registro.setOnMouseEntered(event -> {
                back_button_registro.setCursor(Cursor.HAND);
        });
        
        back_button_registro.setOnMouseExited(event ->{
                back_button_registro.setCursor(Cursor.DEFAULT);
        });
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
    }    

    @FXML
    private void showChange(MouseEvent event) {
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
        if(club.existsLogin(userTF.getText())){
            club.getMemberByCredentials(userTF.getText(), passwordTF.getText()).setImage(im);
        }
    }

    @FXML
    private void backRegistro(MouseEvent event) {
        try{
            Stage stage;
            stage = main.getStage();
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/autenticarseFXML.fxml"));
            Parent root = loader.load();
                  
            Scene scene = new Scene(root, 1200, 750);
            stage.setScene(scene);

                    
            }catch(Exception e){System.out.println(e);}
    }

    @FXML
    private void exitRegistro(MouseEvent event) {
        Stage stage = (Stage) exit_button_registro.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void registerMember(ActionEvent event) throws ClubDAOException {
        String nm = nameTF.getText();
        String sn = lastNameTF.getText();
        String us = userTF.getText();
        String pn = phoneTF.getText();
        String cc = creditCardTF.getText();
        String pw = passwordTF.getText();
        String cvv = cvvTF.getText();
        int cvvInt = -1;
        if(!isInteger(pn) || !isInteger(cc) || !isInteger(cvv)) formatError();
        if(cvv.length() != 3 && isInteger(cvv)) errorCVV();
        else cvvInt = Integer.parseInt(cvv);
        if(!(nm).isEmpty()&&!(sn).isEmpty()&&!(us).isEmpty()&&!(pn).isEmpty()&&!(pw).isEmpty()){
            if(club.existsLogin(us)) registeredError();
            else{club.registerMember(nm, sn, pn, us, pw, cc, cvvInt, im);}
            //System.out.println("De locos guachin");
        }
        else errorRegistry();
        System.out.println("Bien");
    }
 
    public void errorRegistry(){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Diálogo de excepción");
        String missing = "";
        if((nameTF.getText()).isEmpty()){missing += "Nombre " + "\n";}
        if((lastNameTF.getText()).isEmpty()){missing += "Apellido " + "\n";}
        if((userTF.getText()).isEmpty()){missing += "Usuario " + "\n";}
        if((phoneTF.getText()).isEmpty()){missing += "Numero de telefono " + "\n";}
        if((passwordTF.getText()).isEmpty()){missing += "Contraseña " + "\n";} 
        alert.setHeaderText("Faltan los siguiente datos");
        alert.setContentText(missing);
        alert.showAndWait();
    }
    
    public void errorCVV(){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("El cvv es incorrecto");
        alert.showAndWait();
        cvvTF.clear();
    }
    
    public boolean isInteger( String input ) {
    try {
        Integer.parseInt( input );
        return true;
    }
    catch( Exception e ) {
        return false;
    }
}
    
    public void formatError(){
        Alert alert = new Alert(AlertType.ERROR);
        String error = "Formato incorrecto: \n";
        alert.setTitle("Error");
        if(!isInteger(phoneTF.getText())){
            phoneTF.clear();
            error += "Numero de telefono \n";
        }
        if(!isInteger(creditCardTF.getText())){
            creditCardTF.clear();
            error += "Tarjeta de credito \n";
        }
        if(!isInteger(cvvTF.getText())){
            cvvTF.clear();
            error += "CVV \n";
        }
        alert.setHeaderText(error);
        alert.showAndWait();
    };
    
    public void registeredError(){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("El usuario ya esta registrado");
        userTF.clear();
        alert.showAndWait();

    }


}

