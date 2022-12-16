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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SOHA
 */
public class HistoryTwoPlController implements Initializable {

    private String line;
    private ObservableList<TwoGame> list = FXCollections.observableArrayList();
    private int counter;

    @FXML
    private TableView<TwoGame> STable;
    @FXML
    private TableColumn<TwoGame, Integer> idCol;
    @FXML
    private TableColumn<TwoGame, String> playerx;
    @FXML
    private TableColumn<TwoGame, String> playery;
    @FXML
    private TableColumn<TwoGame, String> winnerCol;
    @FXML
    private TableColumn<TwoGame, String> dateCol;
    @FXML
    private TableColumn<TwoGame, String> timeCol;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Group back;
    @FXML
    private Button arrowBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gettingSDataFromFile();
    }

    public void gettingSDataFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("src/SystemFile/HistoryData.txt")));

            counter = new Integer(1);
            while ((line = reader.readLine()) != null) {
                String[] game = line.split(",");

                idCol.setCellValueFactory(new PropertyValueFactory<TwoGame, Integer>("ID"));
                playerx.setCellValueFactory(new PropertyValueFactory<TwoGame, String>("playerOneName"));
                playery.setCellValueFactory(new PropertyValueFactory<TwoGame, String>("playerTwoName"));
                winnerCol.setCellValueFactory(new PropertyValueFactory<TwoGame, String>("Winner"));
                dateCol.setCellValueFactory(new PropertyValueFactory<TwoGame, String>("Date"));
                timeCol.setCellValueFactory(new PropertyValueFactory<TwoGame, String>("Time"));

                list.add(new TwoGame(counter, game[0], game[1], game[3], game[2], game[4]));

                counter++;

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HistoryTwoPlController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HistoryTwoPlController.class.getName()).log(Level.SEVERE, null, ex);
        }

        STable.setItems(list);

    }

    @FXML
    public void backFromHist(ActionEvent event) {
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

}
