package tictactoe;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;

public class RecordSingleController implements Initializable {

    @FXML
    private Button backHistory;

    @FXML
    private ImageView recordBackArrow;

    @FXML
    private TableColumn<?, ?> recordDate;

    @FXML
    private TableColumn<?, ?> recordDifficulty;

    @FXML
    private TableColumn<?, ?> recordID;

    @FXML
    private TableColumn<?, ?> recordPlayerName;

    @FXML
    private TableView<?> recordTable;

    @FXML
    private TableColumn<?, ?> recordTime;

    @FXML
    private TableColumn<?, ?> recordWinner;

    @FXML
    void backArrow(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
