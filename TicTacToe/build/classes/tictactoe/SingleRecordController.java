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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SOHA
 */
public class SingleRecordController implements Initializable {

    private String line;
    public static int counterOfGame;
    ObservableList<SingleGame> obsList = FXCollections.observableArrayList();
    @FXML
    private TableView<SingleGame> recordTable;
    @FXML
    private TableColumn<SingleGame, Integer> recordID;
    @FXML
    private TableColumn<SingleGame, String> recordDate;
    @FXML
    private TableColumn<SingleGame, String> recordTime;
    @FXML
    private TableColumn<SingleGame, String> recordPlayerOne;
    @FXML
    private TableColumn<SingleGame, String> recordPlayerTwo;
    @FXML
    private TableColumn<SingleGame, String> recordWinner;
    @FXML
    private Button backHistory;
    @FXML
    private ImageView recordBackArrow;
    private Stage stage;
    private Scene scene;
    private Parent root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        getData();
    }

    public void getData() {
        try {
           BufferedReader reader=new BufferedReader(new FileReader(new File(System.getProperty("user.home") + "/tictactoeRecord/record.txt")));

            counterOfGame = new Integer(1);
            while ((line = reader.readLine()) != null) {
                String[] game = line.split(",");
                System.out.println(line);

                recordID.setCellValueFactory(new PropertyValueFactory<SingleGame, Integer>("id"));
                recordPlayerOne.setCellValueFactory(new PropertyValueFactory<SingleGame, String>("PlayerOneName"));
                recordPlayerTwo.setCellValueFactory(new PropertyValueFactory<SingleGame, String>("difficulty"));
                recordDate.setCellValueFactory(new PropertyValueFactory<SingleGame, String>("Date"));
                recordTime.setCellValueFactory(new PropertyValueFactory<SingleGame, String>("Time"));
                recordWinner.setCellValueFactory(new PropertyValueFactory<SingleGame, String>("Winner"));

                obsList.add(new SingleGame(counterOfGame , game[0], game[1], game[2], game[3], game[4]));

                counterOfGame++;

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HistorySingleController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HistorySingleController.class.getName()).log(Level.SEVERE, null, ex);
        }
        recordTable.setItems(obsList);
        recordTable.setRowFactory(s -> {
            TableRow<SingleGame> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY
                        && event.getClickCount() == 2) {

                    int clickedRow = row.getItem().getId();
                    GameID.setGameId(clickedRow);
                    navToPlayRecord(event);
                    System.out.println(clickedRow);

                }

            });

            return row;
        });

    }

    public void navToPlayRecord(MouseEvent event) {

        try {
            System.out.println(FXMLLoader.load(getClass().getResource("PlayRecord.fxml")).toString());
            root = FXMLLoader.load(getClass().getResource("PlayRecord.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ScenesNavigator.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void backArrow(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("SinglePlayerName.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(TwoPlayerBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
