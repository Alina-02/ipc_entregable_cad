


package ipc_project;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafxmlapplication.AutenticarseFXMLController;
import javafxmlapplication.DisponibilidadDelDiaFXMLController;
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
        FXMLLoader loader= new  FXMLLoader(getClass().getResource("/views/DisponibilidadDelDiaFXML.fxml"));
        Parent root = loader.load();
        //======================================================================
        // 2- creación de la escena con el nodo raiz del grafo de escena
        Scene scene = new Scene(root);
        
        DisponibilidadDelDiaFXMLController controllerDisponibilidad = loader.getController();
        controllerDisponibilidad.setStage(stage);
       
        //======================================================================
        // 3- asiganación de la escena al Stage que recibe el metodo 
        //     - configuracion del stage
        //     - se muestra el stage de manera no modal mediante el metodo show()
        stage.setScene(scene);
        
        
        stage.setMinWidth(1200);
        stage.setMinHeight(750);
        

        
        stage.getIcons().add(new Image(this.getClass().getResourceAsStream("/img/Pelota.png")));
        
        stage.setTitle("GreenBall");
        
        
        controllerDisponibilidad.resizable();
        
        stage.show();
        
        /*PauseTransition delay = new PauseTransition(Duration.seconds(1));
        
        loader = new  FXMLLoader(getClass().getResource("/views/DisponibilidadDelDiaFXML.fxml"));
        root = loader.load();*/
        
        //Scene scene2 = new Scene(root);
        
        /*delay.setOnFinished(event -> stage.setScene(scene2));
        delay.play();*/
        
        
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