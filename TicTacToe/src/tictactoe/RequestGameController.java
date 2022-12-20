package tictactoe;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;

public class RequestGameController implements Initializable {

    @FXML
    private ImageView backArrow;

    @FXML
    private Label playerName;

    @FXML
    private ListView<String> requestList;
    
    @FXML
    private Button requrstButton;

    String[] players = {"Soha", "Mo'men", "Youssuf", "Ahmad", "Beshoy"};

    String currentPlayer;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        requestList.getItems().addAll(players);

        requestList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                currentPlayer = requestList.getSelectionModel().getSelectedItem();

                playerName.setText("Click request to invite " + currentPlayer + " for a game");
            }

        });
    }

}
