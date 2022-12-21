package tictactoe;

import LocalData.SingleGame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private String winner;
    private int counterPlayer1 = CounterTwoPlayers.getCounterPlayer1();
    private int counterPlayer2 = CounterTwoPlayers.getCounterPlayer2();
    private int counterclicked = 0;
    private static boolean gameStarted = false;

    Vector<Button> buttons;
    @FXML
    private Button startRecordBtn;
    RecState record = new RecState();
    private String line;
    private int counter = 1;
    private ObservableList<SingleGame> observableList = FXCollections.observableArrayList();
    private FileOutputStream fileOutputStream;
    private File fileSteps;

    String stepsRec = "";

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
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setHeaderText("The game will not be saved");
        a.setTitle("Exit Game!");
        Optional<ButtonType> result = a.showAndWait();

        if (result.get() == ButtonType.OK) {

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

    @FXML
    private void exitButton(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setHeaderText("The game will not be saved");
        a.setTitle("Exit Game!");
        Optional<ButtonType> result = a.showAndWait();

        if (result.get() == ButtonType.OK) {

            Platform.exit();
        }

    }

    @FXML
    private void startRecord(ActionEvent event) {

        record.setRecState(true);

    }

    @FXML
    private void setUpButton(ActionEvent e) {
        try {
            String stat;
            counterclicked++;
            gameStarted = true;
            Button button = (Button) e.getSource();
            button.setText("X");
            stepsRec = stepsRec + getIdGame() + "," + button.getId().toString() + "," + button.getText().toString() + "\n";
            System.out.println(stepsRec);
            button.setDisable(true);
            ComputerMove();
            stat = checkGameOver();
            if (stat.equals("XXX") || stat.equals("OOO")) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("WinningScreenSingle.fxml"));
                    root = loader.load();
                    WinningScreenSingleController winningSceneController = loader.getController();
                    if (stat.equals("XXX")) {

                        winningSceneController.setWinnerNameText("Congratulations \t" + playerOneName.getText());
                    } else {

                        winningSceneController.setWinnerNameText("You Lose!");
                    }
                    stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(SinglePlayerBoardController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SinglePlayerBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ComputerMove() {
        int randomMove = (int) (Math.random() * (9 - counterclicked)) + 1;
        for (Button button : buttons) {
            if (button.getText().equals("")) {
                randomMove--;
                if (randomMove == 0) {
                    try {
                        button.setText("O");
                        stepsRec = stepsRec + getIdGame() + "," + button.getId().toString() + "," + button.getText().toString() + "\n";
                        System.out.println(stepsRec);
                        button.setDisable(true);
                        break;
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(SinglePlayerBoardController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        counterclicked++;
    }

    private String checkGameOver() {
        String stat = "";
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
                counterPlayer1++;
                CounterTwoPlayers.setCounterPlayer1(counterPlayer1);
                WinnerPlayer.setWinnerName(playerOneName.getText());
                playerOneScoreBtn.setText(Integer.toString(counterPlayer1));
                restartGame();
                return gameStatus;

            }
            if (gameStatus.equals("OOO")) {
                counterPlayer2++;
                CounterTwoPlayers.setCounterPlayer2(counterPlayer2);
                WinnerPlayer.setWinnerName(playerTwoName.getText());
                playerTwoScoreBtn.setText(Integer.toString(counterPlayer2));
                restartGame();
                return gameStatus;

            }
            if (isWon(gameStatus) == false && isfull() == true) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Press OK to restart game.");
                alert.setTitle("Draw!");
                Optional<ButtonType> result = alert.showAndWait();

                if (result.get() == ButtonType.OK) {
                    restartGame();
                }

            }
        }
        return stat;
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
                gameStarted = false;
                return false;
            }
        }
        return true;

    }

    private void restartGame() {

        buttons.forEach(this::resetButton);
        if (record.isRecState() == true) {

            byte[] arr = stepsRec.getBytes();

            File records = new File(System.getProperty("user.home") + "/tictactoeSteps");
            if (!records.exists()) {
                records.mkdir();
                this.fileSteps = new File(System.getProperty("user.home") + "/tictactoeSteps", "recordSteps.txt");
                try {
                    fileOutputStream = new FileOutputStream(this.fileSteps);
                } catch (FileNotFoundException ex) {
                }

                try {
                    fileOutputStream.write(arr);
                    //Files.write(path, arr, StandardOpenOption.APPEND);

                } catch (IOException e) {
                    System.out.println("Invalid path");
                }
            } else {

                Path path = Paths.get(System.getProperty("user.home") + "/tictactoeSteps/" + "recordSteps.txt");

                try {
                    Files.write(path, arr, StandardOpenOption.APPEND);
                } catch (IOException e) {
                    System.out.println("Invalid path");
                }
            }

        }

    }

    public void resetButton(Button button) {

        counterclicked = 0;
        button.setDisable(false);
        button.setText("");
        gameStarted = false;
        startRecordBtn.setVisible(true);

    }

    public void setPlayerOneNameText(String playerOneName) {
        this.playerOneName.setText(playerOneName);
    }

    public void setPlayerTwoNameText(String playerTwoName) {
        this.playerTwoName.setText(playerTwoName);
    }

    public void setPlayerCounter1(int counter1) {
        this.playerOneScoreBtn.setText(Integer.toString(counter1));
    }

    public void setPlayerCounter2(int counter2) {
        this.playerTwoScoreBtn.setText(Integer.toString(counter2));
    }

    public boolean isRecord() {
        return record.isRecState();
    }

    public int getIdGame() throws FileNotFoundException {
        int gameNum = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(System.getProperty("user.home") + "/tictactoeRecord/" + "record.txt")));

            Integer counter = new Integer(1);
            while ((line = reader.readLine()) != null) {
                String[] game = line.split(",");
                gameNum++;

            }
        } catch (IOException ex) {
            File records = new File(System.getProperty("user.home") + "/tictactoeSteps");
            records.mkdir();
            this.fileSteps = new File(System.getProperty("user.home") + "/tictactoeSteps", "recordSteps.txt");
            fileOutputStream = new FileOutputStream(this.fileSteps);
            try {
                fileOutputStream.write("".getBytes());
                //Files.write(path, arr, StandardOpenOption.APPEND);

            } catch (IOException e) {
                System.out.println("Invalid path");
            }
        }
        return ++gameNum;

    }

}
