
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class SinglePlayerNameController implements Initializable {

    @FXML
    private ImageView arrowBack;
    @FXML
    private Button HistorySingle;
    @FXML
    private Button backButton;
    @FXML
    private TextField textFieldPlayerName;
    @FXML
    private Button nextButton;
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     @FXML
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
     @FXML
    public void NextButtonSinglePlayer(ActionEvent event) {
          CounterTwoPlayers.setCounterPlayer1(0);
          CounterTwoPlayers.setCounterPlayer2(0);
        try {
           
            if (textFieldPlayerName.getText().isEmpty() ) {
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setHeaderText("Please enter player name");
                a.setTitle("Pay Attention");
                Optional<ButtonType> result = a.showAndWait();

                if (result.get() == ButtonType.OK) {

                    root = FXMLLoader.load(getClass().getResource("SinglePlayerName.fxml"));
                }

            } else {
                TwoPlayerName.setPlayerOne(textFieldPlayerName.getText());
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Defficulty.fxml"));
                root = loader.load();
             
                
                
      
            }

        } catch (IOException ex) {
            Logger.getLogger(ScenesNavigator.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
         
           

    }
    @FXML
   public void historySinglePlayer(ActionEvent event) {

       try {
            root = FXMLLoader.load(getClass().getResource("HistorySingle.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(TwoPlayerBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        }

}
