/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WinningScreenSingleController implements Initializable {

    String recState;

    @FXML
    private MediaView playingVedio;
    @FXML
    private Button resetBtn;
    @FXML
    private Button exitBtn;
    @FXML
    private Text winnerName;
    private Parent root;
    private Stage stage;
    private Scene scene;
    private int counter1 = CounterTwoPlayers.getCounterPlayer1();
    private int counter2 = CounterTwoPlayers.getCounterPlayer2();
    LocalDate date;
    LocalTime time;
    private File file;
    private MediaPlayer mediaplayer;
    private Media media;
    @FXML
    private Text congrats;
    Boolean record;
    String playerOneName;
    String playerTwoName;
    String winer;
    String dt;
    String timeString;
    String timeSubString;
    private String videoPath;
    FileOutputStream fileOutputStream;
    private File anotherFile;
    private File  recordfile; 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SinglePlayerBoard.fxml"));
            root = loader.load();

            SinglePlayerBoardController SinglePlayerBoardController = loader.getController();
            record = SinglePlayerBoardController.isRecord();

            if (WinnerPlayer.getWinnerName().equals(TwoPlayerName.getPlayerOne())) {
                videoPath = "test2.mp4";
            } else {
                videoPath = "test3.mp4";
            }
            //System.out.println(tictactoe.TicTacToe.class.getResource(videoPath).toExternalForm());
            media = new Media(tictactoe.TicTacToe.class.getResource(videoPath).toExternalForm());
            mediaplayer = new MediaPlayer(media);
            playingVedio.setMediaPlayer(mediaplayer);
            mediaplayer.play();
            getRow();
        } catch (IOException ex) {
            Logger.getLogger(WinningScreenSingleController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void playAgainButton(ActionEvent event) {
        try {

            mediaplayer.stop();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SinglePlayerBoard.fxml"));
            root = loader.load();

            SinglePlayerBoardController SinglePlayerBoardController = loader.getController();
            SinglePlayerBoardController.setPlayerOneNameText(TwoPlayerName.getPlayerOne());
            SinglePlayerBoardController.setPlayerCounter1(counter1++);
            SinglePlayerBoardController.setPlayerCounter2(counter2++);

            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(WinningScreenSingleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void exitButton(ActionEvent event) {
        Platform.exit();
    }

    public void setWinnerNameText(String playerName) {
        this.winnerName.setText(playerName);

    }

    public void getRow() {
        playerOneName = TwoPlayerName.getPlayerOne();
        playerTwoName = TwoPlayerName.getPlayerTwo();
        SinglePlayerBoardController spc = new SinglePlayerBoardController();
        winer = WinnerPlayer.getWinnerName();
        date = java.time.LocalDate.now();
        dt = date.toString();
        time = java.time.LocalTime.now();
        timeString = time.toString();
        timeSubString = timeString.substring(0, 5);

        String data = playerOneName + "," + playerTwoName + "," + dt + "," + winer + "," + timeSubString + "\n";
        byte[] arr = data.getBytes();
        File another = new File(System.getProperty("user.home") + "/tictactoe");
        if (!another.exists()) {
            another.mkdir();
            this.anotherFile = new File(System.getProperty("user.home") + "/tictactoe", "historysingle.txt");
            try {
                fileOutputStream = new FileOutputStream(this.anotherFile);
            } catch (FileNotFoundException ex) {
            }

            try {
                fileOutputStream.write(arr);
                //Files.write(path, arr, StandardOpenOption.APPEND);

            } catch (IOException e) {
                System.out.println("Invalid path");
            }
        } else {
            Path path = Paths.get(System.getProperty("user.home") + "/tictactoe/"+"historysingle.txt");
            try {
                Files.write(path, arr, StandardOpenOption.APPEND);
            } catch (IOException ex) {

            }
        }

        System.out.println(record);
        if (record == true) {
            
     
            String recData = playerOneName + "," + playerTwoName + "," + dt + "," + winer + "," + timeSubString + "\n";
            byte[] recArr = recData.getBytes();
         
            
            
            
            
            File records = new File(System.getProperty("user.home") + "/tictactoeRecord");
            System.out.println(recArr);
            
            if (!records.exists()) {
            records.mkdir();
            this.recordfile = new File(System.getProperty("user.home") + "/tictactoeRecord", "record.txt");
            try {
                fileOutputStream = new FileOutputStream(this.recordfile);
            } catch (FileNotFoundException ex) {
            }

            try {
                fileOutputStream.write(recArr);
                //Files.write(path, arr, StandardOpenOption.APPEND);
              
            } catch (IOException e) {
                System.out.println("Invalid path");
            }
            }
       else {
             Path path = Paths.get(System.getProperty("user.home") + "/tictactoeRecord/"+"record.txt");
            try {
                Files.write(path, recArr, StandardOpenOption.APPEND);
            } catch (IOException ex) {

            }
        }
           

        }

    }

    public void setCongrats(String congrats) {
        this.congrats.setText(congrats);
    }

    public void setRecord(String recordState) {
        this.recState = recordState;
    }

}
