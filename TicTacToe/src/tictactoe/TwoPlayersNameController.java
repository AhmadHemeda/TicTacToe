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
import javafx.stage.Stage;

public class TwoPlayersNameController implements Initializable {

    @FXML
    private TextField textFieldPlayerName1;
    @FXML
    private TextField textFieldPlayerName2;
    @FXML
    private Button nextButton;
    @FXML
    private Button historyIcon;
    @FXML
    private Button backButton1;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void NextButtonTwoPlayer(ActionEvent event) {
        CounterTwoPlayers.setCounterPlayer1(0);
        CounterTwoPlayers.setCounterPlayer2(0);
        try {

            if (textFieldPlayerName1.getText().isEmpty() && textFieldPlayerName2.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Please enter players names");
                alert.setTitle("Pay Attention");
                Optional<ButtonType> result = alert.showAndWait();

            } else if (textFieldPlayerName1.getText().isEmpty()) {
                TwoPlayerName.setPlayerTwo(textFieldPlayerName2.getText());
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Please enter player 1 name");
                alert.setTitle("Pay Attention");
                Optional<ButtonType> result = alert.showAndWait();

            } else if (textFieldPlayerName2.getText().isEmpty()) {
                TwoPlayerName.setPlayerOne(textFieldPlayerName1.getText());
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Please enter player 2 name");
                alert.setTitle("Pay Attention");
                Optional<ButtonType> result = alert.showAndWait();

            } else {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("TwoPlayerBoard.fxml"));
                root = loader.load();
                TwoPlayerBoardController twoPlayerBoardController = loader.getController();
                twoPlayerBoardController.setPlayerOneNameText(textFieldPlayerName1.getText());
                twoPlayerBoardController.setPlayerTwoNameText(textFieldPlayerName2.getText());

                TwoPlayerName.setPlayerOne(textFieldPlayerName1.getText());
                TwoPlayerName.setPlayerTwo(textFieldPlayerName2.getText());
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
    public void historyTwoPlayer(ActionEvent event) {

        try {
            root = FXMLLoader.load(getClass().getResource("HistoryTwo.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(TwoPlayerBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void backArrow(ActionEvent event) {
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

}
