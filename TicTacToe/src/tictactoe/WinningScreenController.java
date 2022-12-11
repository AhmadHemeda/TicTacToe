/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import LocalData.TwoGame;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.time.LocalTime;
import LocalData.TwoGame;

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
    LocalDate date ;
    LocalTime time;
    public void initialize(URL url, ResourceBundle rb) {
        getRow();
    }    

    @FXML
    private void playAgainButton(ActionEvent event) {
        try {
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
    public TwoGame getRow(){
        
        String playerOneName=TwoPlayerName.getPlayerOne();
        String playerTwoName=TwoPlayerName.getPlayerTwo();
        String winnerName=this.winnerName.getText();
        date=java.time.LocalDate.now();
        time=java.time.LocalTime.now();
        String timeString=time.toString();
        String timeSubString=timeString.substring(0,5);
        TwoGame twoGame=new TwoGame(playerOneName,playerTwoName,date,winnerName,timeSubString);
        return twoGame;
    }    
 
}
