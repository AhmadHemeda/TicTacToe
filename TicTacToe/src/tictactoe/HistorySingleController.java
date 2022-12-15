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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author SOHA
 */
public class HistorySingleController implements Initializable {
    String line;
    ObservableList<SingleGame> list=FXCollections.observableArrayList();
    Integer counter;

    @FXML
    private TableView<SingleGame> STable;
    @FXML
    private TableColumn<SingleGame,Integer> idSCol;
    @FXML
    private TableColumn<SingleGame,String> playerSCol;
    @FXML
    private TableColumn<SingleGame,String> difficultySCol;
    @FXML
    private TableColumn<SingleGame,String> winnerSCol;
    @FXML
    private TableColumn<SingleGame,String> dateSCol;
    @FXML
    private TableColumn<SingleGame,String> timeSCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gettingSDataFromFile();
    }  
    public void gettingSDataFromFile(){
        try {
            BufferedReader reader=new BufferedReader(new FileReader(new File("C:\\Users\\SOHA\\Desktop\\SingleHistory.txt")));
            
            counter=new Integer(1);
            while((line=reader.readLine())!=null){
                String []game=line.split(",");
               
                
                idSCol.setCellValueFactory(new PropertyValueFactory<SingleGame,Integer>("ID"));
                playerSCol.setCellValueFactory(new PropertyValueFactory<SingleGame,String>("PlayerName"));
                difficultySCol.setCellValueFactory(new PropertyValueFactory<SingleGame,String>("Difficulty"));
                winnerSCol.setCellValueFactory(new PropertyValueFactory<SingleGame,String>("Winner"));
                dateSCol.setCellValueFactory(new PropertyValueFactory<SingleGame,String>("Date"));
                timeSCol.setCellValueFactory(new PropertyValueFactory<SingleGame,String>("Time"));
                
                
                
                
                list.add(new SingleGame(counter,game[0],game[1],game[2],game[3],game[4]));
               
                
                counter++;
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HistoryTwoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HistoryTwoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        STable.setItems(list);
    
    
    }
    
}
