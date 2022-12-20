/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import LocalData.TwoGame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import static tictactoe.HistoryTwoController.gameTwoNum;

/**
 * FXML Controller class
 *
 * @author SOHA
 */
public class PlayRecordController implements Initializable {

    @FXML
    private Button backButton1;
    @FXML
    private Button btn11;
    @FXML
    private Button btn21;
    @FXML
    private Button btn31;
    @FXML
    private Button btn12;
    @FXML
    private Button btn32;
    @FXML
    private Button btn13;
    @FXML
    private Button btn23;
    @FXML
    private Button btn22;
    @FXML
    private Button btn33;
    private int gameNum;
    private Stage stage;
    private Scene scene;
    private Parent root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gameNum=GameID.getGameId();
        getStepsData(gameNum);
    }

    @FXML
    private void backArrow(ActionEvent event) {
        
        try {
            root = FXMLLoader.load(getClass().getResource("SingleRecord.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ScenesNavigator.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void getStepsData(int gameId) {
        try {
            BufferedReader read = new BufferedReader(new FileReader(new File("src/SystemFile/RecordedSteps.txt")));
            String line;
            Integer counter = new Integer(1);
            while ((line = read.readLine()) != null) {
                String[] step = line.split(",");
                
                if(Integer.parseInt(step[0])==gameNum){
                    
                    playSteps(step[1], step[2]);
                    
                    
                
                }
                
                //Thread.sleep(1000);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HistoryTwoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HistoryTwoController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private void playSteps(String btn,String val){
        switch(btn){
            case "btn11":
                btn11.setText(val);
            break;
            case "btn12":
                btn12.setText(val);
            break;
            case "btn13":
                btn13.setText(val);
            break;
            case "btn21":
                btn21.setText(val);
            break;
            case "btn22":
                btn22.setText(val);
            break;
            case "btn23":
                btn23.setText(val);
            break;
            case "btn31":
                btn31.setText(val);
            break;
            case "btn32":
                btn32.setText(val);
            break;
            case "btn33":
                btn33.setText(val);
            break;
        
        
        }
    
    }



}
