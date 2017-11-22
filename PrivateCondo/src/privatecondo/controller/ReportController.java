/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privatecondo.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mujill
 */
public class ReportController implements Initializable {
    private static final Logger LOGGER = Logger.getLogger(ReportController.class.getName());
    
    private Stage thisStage;
    private Scene thisScene;

    public ReportController() {
    }

    public ReportController(Stage thisStage, Scene thisScene) {
        this.thisStage = thisStage;
        this.thisScene = thisScene;
    }

    public Stage getThisStage() {
        return thisStage;
    }

    public void setThisStage(Stage thisStage) {
        this.thisStage = thisStage;
    }

    public Scene getThisScene() {
        return thisScene;
    }

    public void setThisScene(Scene thisScene) {
        this.thisScene = thisScene;
    }
    
    @FXML
    public void callReport(Stage stage,Scene scene) {
        
        Parent root = null;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/Report.fxml"));
        stage.setTitle("Private Condo");
        try {
            root = (Parent) fxmlLoader.load();
            scene.setRoot(root);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "root : callReport Failed");
        }

        ReportController controller = fxmlLoader.<ReportController>getController();
        
        controller.setThisStage(stage);
        controller.setThisScene(scene);
        
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
