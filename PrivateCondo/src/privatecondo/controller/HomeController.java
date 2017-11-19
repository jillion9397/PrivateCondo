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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mujill
 */
public class HomeController implements Initializable {
    private static final Logger LOGGER = Logger.getLogger(ReportController.class.getName());
    public ReportController rc = new ReportController();
    
    @FXML
    private Label user_name;

    @FXML
    private Label user_room;

    @FXML
    private Button homeBtn;

    @FXML
    private Button reportBtn;

    @FXML
    private Button abtBtn;

    @FXML
    private Button serviceBtn;

    @FXML
    private VBox listNews;
    
    private Stage thisStage;
    private Scene thisScene;

    public HomeController() {
    }

    public HomeController(Stage thisStage, Scene thisScene) {
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
    public void callHome() {
        Stage stage = new Stage();
        Parent root = null;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/Home.fxml"));
        stage.setTitle("Private Condo");
        try {
            root = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "root : callHome Failed");
        }

        HomeController controller = fxmlLoader.<HomeController>getController();
        System.out.println("callHome");
        Scene scene = new Scene(root);
        controller.setThisStage(stage);
        controller.setThisScene(scene);
        
        
        try {
            stage.setScene(scene);
        } catch (Exception e) {
            System.out.println("Exception");
        }
        stage.show();
    }
    @FXML
    public void clickReport(){
        rc.callReport(thisStage,thisScene);
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
