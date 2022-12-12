package tictactoe;

import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class HistoryController implements Initializable {
    
    @FXML
    private TableColumn<User, Integer> ID;

    @FXML
    private TableColumn<User, Date> date;

    @FXML
    private TableColumn<User, String> dificulty;

    @FXML
    private TableColumn<User, String> player;

    @FXML
    private TableView<User> table;

    @FXML
    private TableColumn<User, Time> time;

    @FXML
    private TableColumn<User, String> winner;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        ID.setCellValueFactory(new PropertyValueFactory<User, Integer>("ID"));
//        date.setCellValueFactory(new PropertyValueFactory<User, Date>("date"));
//        dificulty.setCellValueFactory(new PropertyValueFactory<User, String>("dificulty"));
//        player.setCellValueFactory(new PropertyValueFactory<User, String>("player"));
//        time.setCellValueFactory(new PropertyValueFactory<User, Time>("time"));
//        winner.setCellValueFactory(new PropertyValueFactory<User, String>("winner"));
    }    
    
}
