/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxmlapplication;

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
    private Button back_button_actualizar;
    @FXML
    private Button exit_button_actualizar;
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
    private PasswordField passwordCTF;
    @FXML
    private TextField creditCardTF;
    @FXML
    private PasswordField svcPF;
    @FXML
    private Button register_button1;
    @FXML
    private Button register_button12;
    @FXML
    private Button register_button11;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Image im = new Image(getClass().getResourceAsStream("/img/Avatar.jpg"));
        user_image_circle.setFill(new ImagePattern(im));
        //user_image_circle.setEffect(new DropShadow(+25d, 0d, +2d, Color.GREY));
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
    private void backAutenticarse(MouseEvent event) {
    }

    @FXML
    private void exitAutenticarse(MouseEvent event) {
    }

    @FXML
    private void registerMember(ActionEvent event) {
    }

    
}

/*a*/
