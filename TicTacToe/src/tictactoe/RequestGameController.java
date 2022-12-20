package tictactoe;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import tictactoe.AlertClass;
import tictactoe.ServerConnection;
import tictactoe.SignUpController;

public class RequestGameController implements Initializable {

    @FXML
    private ImageView backArrow;

    @FXML
    private Label playerName;

    @FXML
    private ListView<String> requestList;
    
    @FXML
    private Button requrstButton;
     private ServerConnection connection;

   ArrayList<String> players ;
   

    String currentPlayer;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            connection = ServerConnection.getInstance("127.0.0.1");
            connection.writeDatagetAllPlayers();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    
                    
                    while(true){
                        
                        try {
                            String Data=connection.getDis().readLine();
                            String[] DataPlayers=Data.split(",");
                            players.add(DataPlayers[1]);
                        } catch (IOException ex) {
                            Logger.getLogger(RequestGameController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                    
                }
            }).start();
            requestList.getItems().addAll(players);
            
            requestList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    
                    currentPlayer = requestList.getSelectionModel().getSelectedItem();
                    
                    playerName.setText("Click request to invite " + currentPlayer + " for a game");
                }
                
            });
        } catch (IOException ex) {
            Logger.getLogger(RequestGameController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void SendRequest(ActionEvent event){
    
        connection.invetation("Ahmed");
        
    
    
    
    }
}
