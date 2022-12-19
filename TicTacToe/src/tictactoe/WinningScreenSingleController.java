/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.io.File;
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
    private int counter1=CounterTwoPlayers.getCounterPlayer1();
    private int counter2=CounterTwoPlayers.getCounterPlayer2();
    LocalDate date ;
    LocalTime time;
   private File file;
    private MediaPlayer mediaplayer;
    private Media media;
    @FXML
    private Text congrats;
   @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        if(WinnerPlayer.getWinnerName().equals(TwoPlayerName.getPlayerOne()))
            
        {file=new File("src/Resources/videos/test2.mp4");}
        else
        {
            file=new File("src/Resources/videos/test3.mp4");
        }
        media=new Media(file.toURI().toString());
        mediaplayer=new MediaPlayer(media);
        playingVedio.setMediaPlayer(mediaplayer);
        mediaplayer.play();
        getRow();
        
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
    public void setWinnerNameText(String playerName){
    this.winnerName.setText(playerName);
    
    }
    
    public void getRow(){
        String playerOneName=TwoPlayerName.getPlayerOne();
        String playerTwoName=TwoPlayerName.getPlayerTwo();
        SinglePlayerBoardController spc=new SinglePlayerBoardController();
        String winer=WinnerPlayer.getWinnerName();
        date=java.time.LocalDate.now();
        String dt=date.toString();
        time=java.time.LocalTime.now();
        String timeString=time.toString();
        String timeSubString=timeString.substring(0,5);
        
        Path path=Paths.get("src/SystemFile/HistoryDataSingle.txt");
        String data=playerOneName+","+playerTwoName+","+dt+","+winer+","+timeSubString+"\n";
        byte[] arr=data.getBytes();
        try {
            Files.write(path, arr, StandardOpenOption.APPEND);
        }catch (IOException e) {
            System.out.println("Invalid path");
        }
        
    }  

    public void setCongrats(String congrats) {
        this.congrats.setText(congrats);
    }
    
 
}



