/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author noha Ali
 */
public class DefficultyController implements Initializable {

    @FXML
    private Button singlePlayerButton;
    @FXML
    private Button twoPlayerButton;
    @FXML
    private ImageView arrowBack;
    @FXML
    private ImageView historyIcon;
    @FXML
    private ImageView historyIcon1;
    @FXML
    private Button backButton;
      private Stage stage;
    private Scene scene;
    private Parent root;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    public void easyButton(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SinglePlayerBoard.fxml"));
            root = loader.load();
            SinglePlayerBoardController SingleBoardController = loader.getController();
            SingleBoardController.setPlayerOneNameText(TwoPlayerName.getPlayerOne());
            
            
            
            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(DefficultyController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void switchToSinglePlayerScene(ActionEvent event) {
         try {
            root = FXMLLoader.load(getClass().getResource("SinglePlayerName.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ScenesNavigator.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        
    }
     @FXML
    private void hardButton(ActionEvent event) {
         Alert a = new Alert(Alert.AlertType.WARNING);
                a.setHeaderText("Coming Soon!");
                a.setTitle("Pay Attention");
                Optional<ButtonType> result = a.showAndWait();

        
    }
    
}
