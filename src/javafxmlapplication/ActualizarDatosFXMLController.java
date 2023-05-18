/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxmlapplication;

import javafx.scene.image.Image;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author nymok
 */
public class ActualizarDatosFXMLController implements Initializable {

    @FXML
    private Circle user_image_circle;
    @FXML
    private Button back_button;
    @FXML
    private Button exit_button;

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
    private void exit_clicked(MouseEvent event) {
    } 
    
}

/*a*/
