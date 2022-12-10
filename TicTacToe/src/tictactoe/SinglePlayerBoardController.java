package tictactoe;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SinglePlayerBoardController implements Initializable {

    @FXML
    private Text playerOneName;
    @FXML
    private Text playerTwoName;
    @FXML
    private Button playerOneScoreBtn;
    @FXML
    private Button playerTwoScoreBtn;
    @FXML
    private ImageView historyIcon;
    @FXML
    private Button btn11;
    @FXML
    private Button btn12;
    @FXML
    private Button btn13;
    @FXML
    private Button btn21;
    @FXML
    private Button btn22;
    @FXML
    private Button btn23;
    @FXML
    private Button btn31;
    @FXML
    private Button btn32;
    @FXML
    private Button btn33;
    @FXML
    private Button homeButton;
    @FXML
    private Button exitButton;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private int counterPlayer1 = 0;
    private int counterPlayer2 = 0;
    private int counterclicked = 0;

    Vector<Button> buttons;

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        buttons = new Vector<Button>();
        buttons.add(btn11);
        buttons.add(btn12);
        buttons.add(btn13);
        buttons.add(btn21);
        buttons.add(btn22);
        buttons.add(btn23);
        buttons.add(btn31);
        buttons.add(btn32);
        buttons.add(btn33);

        System.out.println(buttons.size());

    }

    @FXML
    private void homeButton(ActionEvent event) {

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
    private void exitButton(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void setUpButton(ActionEvent e) {

        counterclicked++;

        Button button = (Button) e.getSource();
        button.setText("X");
        button.setDisable(true);
        ComputerMove();
        checkGameOver();

    }
    
    private void ComputerMove() {
        int randomMove = (int) (Math.random() * (9 - counterclicked)) + 1;
        for (Button button : buttons) {
            if (button.getText().equals("")) {
                randomMove--;
                if (randomMove == 0) {
                    button.setText("O");
                    button.setDisable(true);
                    break;
                }
            }
        }
        counterclicked++;
    }

    private void checkGameOver() {
        for (int i = 0; i < 8; i++) {
            String gameStatus;
            switch (i) {
                case 0:
                    gameStatus = btn11.getText() + btn12.getText() + btn13.getText();
                    break;
                case 1:
                    gameStatus = btn21.getText() + btn22.getText() + btn23.getText();
                    break;
                case 2:
                    gameStatus = btn31.getText() + btn32.getText() + btn33.getText();
                    break;
                case 3:
                    gameStatus = btn11.getText() + btn21.getText() + btn31.getText();
                    break;
                case 4:
                    gameStatus = btn12.getText() + btn22.getText() + btn32.getText();
                    break;
                case 5:
                    gameStatus = btn13.getText() + btn23.getText() + btn33.getText();
                    break;
                case 6:
                    gameStatus = btn11.getText() + btn22.getText() + btn33.getText();
                    break;
                case 7:
                    gameStatus = btn13.getText() + btn22.getText() + btn31.getText();
                    break;

                default:
                    gameStatus = null;

            }

            if (gameStatus.equals("XXX")) {

                counterPlayer1 = parseInt(playerOneScoreBtn.getText());
                counterPlayer1++;
                playerOneScoreBtn.setText(Integer.toString(counterPlayer1));
                restartGame();

            }
            if (gameStatus.equals("OOO")) {
                counterPlayer2 = parseInt(playerTwoScoreBtn.getText());
                counterPlayer2++;
                playerTwoScoreBtn.setText(Integer.toString(counterPlayer2));
                restartGame();
            }
            if (isWon(gameStatus) == false && isfull() == true) {
                restartGame();
            }
        }
    }

    private boolean isWon(String status) {
        if (status == "XXX" || status == "OOO") {
            return true;
        }
        return false;

    }

    private boolean isfull() {
        for (int i = 0; i < 8; i++) {
            if (buttons.get(i).getText() == "") {
                return false;
            }
        }
        return true;

    }

    private void restartGame() {

        buttons.forEach(this::resetButton);

    }

    public void resetButton(Button button) {
        counterclicked = 0;
        button.setDisable(false);
        button.setText("");

    }

}
