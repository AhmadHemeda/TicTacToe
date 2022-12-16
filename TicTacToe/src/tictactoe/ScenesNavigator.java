package tictactoe;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ScenesNavigator {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private TextField textFieldPlayerName2;
    private TextField textFieldPlayerName1;
    private TextField textFieldPlayerName;
    @FXML
    private Button twoPlayerButton;
    @FXML
    private Button playOnlineButton;
    @FXML
    private Button singlePlayerButton;
    
    

    public void backArrow(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("choosingModeScene.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ScenesNavigator.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void homeButton(ActionEvent event) {

        try {
            root = FXMLLoader.load(getClass().getResource("choosingModeScene.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ScenesNavigator.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

   

    


    

    public void exitButton(ActionEvent event) {
        Platform.exit();
    }

    public String getTextFieldPlayerName2() {
        return this.textFieldPlayerName2.getText();
    }

    public String getTextFieldPlayerName1() {
        return this.textFieldPlayerName1.getText();
    }

    

    
  
  
}
