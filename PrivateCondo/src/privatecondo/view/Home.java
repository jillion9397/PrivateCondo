package privatecondo.view;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
//import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.control.ListView;
import javafx.stage.Stage;
import privatecondo.controller.HomeController;



/**
 *
 * @author Mujill
 */
public class Home extends Application {
    
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = null;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));     
        try{
            root = (Parent)fxmlLoader.load(); 
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
        
        HomeController controller = fxmlLoader.<HomeController>getController();
        Scene scene = new Scene(root);
        controller.setThisScene(scene);
        controller.setThisStage(stage);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
