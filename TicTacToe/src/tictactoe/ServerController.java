package tictactoe;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

public class ServerController implements Initializable {
    
    @FXML
    private BarChart<?, ?> activePlayersChart;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        XYChart.Series set = new XYChart.Series<>();
        
        set.getData().add(new XYChart.Data<>("Online", 4));
        set.getData().add(new XYChart.Data<>("Offline", 1));
        
        activePlayersChart.getData().addAll(set);
    }
}
