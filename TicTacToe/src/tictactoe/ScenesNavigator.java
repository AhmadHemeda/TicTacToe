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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ScenesNavigator {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ImageView historyIcon;
    @FXML
    private Button backButton;
    @FXML
    private TextField textFieldPlayerName2;
    @FXML
    private TextField textFieldPlayerName1;
    @FXML
    private Button nextButton;

    public void switchToSinglePlayerScene(ActionEvent event) {
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

    public void switchToTwoPlayerScene(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("TwoPlayersName.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ScenesNavigator.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

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

    @FXML
    public void NextButtonTwoPlayer(ActionEvent event) {
        try {
            if (textFieldPlayerName1.getText().isEmpty() || textFieldPlayerName2.getText().isEmpty()) {
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setHeaderText("Please enter player name");
                a.setTitle("Pay Attention");
                Optional<ButtonType> result = a.showAndWait();

                if (result.get() == ButtonType.OK) {
<
                    root = FXMLLoader.load(getClass().getResource("TwoPlayersName.fxml"));
                }

            } else {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("TwoPlayerBoard.fxml"));
                root = loader.load();
                TwoPlayerBoardController twoPlayerBoardController = loader.getController();
                twoPlayerBoardController.setPlayerOneNameText(textFieldPlayerName1.getText());
                twoPlayerBoardController.setPlayerTwoNameText(textFieldPlayerName2.getText());

            }

        } catch (IOException ex) {
            Logger.getLogger(ScenesNavigator.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void NextButtonSinglePlayer(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("Defficulty.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ScenesNavigator.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


    public void easyButton(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("SinglePlayerBoard.fxml"));
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
}
