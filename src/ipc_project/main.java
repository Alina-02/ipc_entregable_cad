/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ipc_project;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafxmlapplication.VerMisReservasFXMLController;
import model.Club;
import model.ClubDAOException;

/**
 *
 * @author nymok
 */
public class main extends Application{
    
    private static Stage stage;
         
    @Override
    public void start(Stage stage) throws Exception {
        //Seleccionar el locale  por defecto
        //Locale locale = Locale.getDefault();
        //Cargar el bundle 
        //ResourceBundle bundle = ResourceBundle.getBundle("src.javafxmlapplication.strings_es_ES.properties");
        
        
        this.stage = stage;
        
       
        //======================================================================
        // 1- creación del grafo de escena a partir del fichero FXML
        FXMLLoader loader= new  FXMLLoader(getClass().getResource("/views/verMisReservasFXML.fxml"));
        Parent root = loader.load();
        //======================================================================
        // 2- creación de la escena con el nodo raiz del grafo de escena
        Scene scene = new Scene(root);
        
        
        
        //======================================================================
        // 3- asiganación de la escena al Stage que recibe el metodo 
        //     - configuracion del stage
        //     - se muestra el stage de manera no modal mediante el metodo show()
        stage.setScene(scene);
        
        
        stage.setMinWidth(1200);
        stage.setMinHeight(750);
        
        stage.setTitle("Reservar");
        stage.show();
    }

    public static Stage getStage(){
        return stage;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
}