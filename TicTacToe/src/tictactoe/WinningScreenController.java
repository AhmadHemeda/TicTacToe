/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import com.sun.jndi.dns.DnsContextFactory;
import java.io.File;
import java.io.IOException;
import java.net.URL;
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


public class WinningScreenController implements Initializable {

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
     private File file;
    private MediaPlayer mediaplayer;
    private Media media;
    
    public void initialize(URL url, ResourceBundle rb) {
        file=new File("src\\Resources\\Videos\\test2.mp4 ");
        media=new Media(file.toURI().toString());
        mediaplayer=new MediaPlayer(media);
        playingVedio.setMediaPlayer(mediaplayer);
        mediaplayer.play();
        
    }    

    @FXML
    private void playAgainButton(ActionEvent event) {
        try {
            mediaplayer.stop();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TwoPlayerBoard.fxml"));
            root = loader.load();
            
           
              TwoPlayerBoardController twoPlayerBoardController = loader.getController();
              twoPlayerBoardController.setPlayerOneNameText(TwoPlayerName.getPlayerOne());
              twoPlayerBoardController.setPlayerTwoNameText(TwoPlayerName.getPlayerTwo());
              twoPlayerBoardController.setPlayerCounter1(counter1++);
              twoPlayerBoardController.setPlayerCounter2(counter2++);
              
            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(WinningScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void exitButton(ActionEvent event) {
        Platform.exit();
    }
    public void setWinnerNameText(String playerOneName){
    this.winnerName.setText(playerOneName);
    
    }

}
