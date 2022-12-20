/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import LocalData.SingleGame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SOHA
 */
public class HistorySingleController implements Initializable {
    private String line;
    private ObservableList<SingleGame> observableList=FXCollections.observableArrayList();

    @FXML
    private TableView<SingleGame> table;
    @FXML
    private TableColumn<SingleGame, Integer> idCol;
    @FXML
    private TableColumn<SingleGame,String> dateCol;
    @FXML
    private TableColumn<SingleGame,String> timeCol;
    @FXML
    private TableColumn<SingleGame, String> playerOneCol;
    @FXML
    private TableColumn<SingleGame, String> playerTwoCol;
    @FXML
    private TableColumn<SingleGame, String> winnerCol;
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        gettingDataFromFile();
    }    
    public void gettingDataFromFile(){
        try {
            BufferedReader reader=new BufferedReader(new FileReader(new File("src/SystemFile/HistoryDataSingle.txt")));
            
            Integer counter=new Integer(1);
            while((line=reader.readLine())!=null){
                String []game=line.split(",");
                
                
                idCol.setCellValueFactory(new PropertyValueFactory<SingleGame,Integer>("id"));
                playerOneCol.setCellValueFactory(new PropertyValueFactory<SingleGame,String>("PlayerOneName"));
                playerTwoCol.setCellValueFactory(new PropertyValueFactory<SingleGame,String>("difficulty"));
                timeCol.setCellValueFactory(new PropertyValueFactory<SingleGame,String>("Time"));
                dateCol.setCellValueFactory(new PropertyValueFactory<SingleGame,String>("Date"));
                winnerCol.setCellValueFactory(new PropertyValueFactory<SingleGame,String>("Winner"));
                
                
                
                //TwoGame twoGame=new TwoGame(counter,game[2],game[4],game[0],game[1],game[3]);
                //System.out.println(twoGame.getPlayerOneName());
                
                observableList.add(new SingleGame(counter,game[0],game[1],game[4],game[3],game[2]));
               
                
                counter++;
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HistorySingleController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HistorySingleController.class.getName()).log(Level.SEVERE, null, ex);
        }
        table.setItems(observableList);
    
    
    }
    @FXML
    public void backArrow(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("SinglePlayerName.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(SinglePlayerNameController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    
}
