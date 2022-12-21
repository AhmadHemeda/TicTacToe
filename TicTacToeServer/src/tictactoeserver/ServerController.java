package tictactoeserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class ServerController implements Initializable, Runnable {

    @FXML
    private BarChart<?, ?> activePlayersChart;
    private boolean isClosedBefore = false;
    private boolean isStartedBefore = false;
    private boolean isOpened = false;
    static ServerSocket serverSocket;
    static Thread thread;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        XYChart.Series set = new XYChart.Series<>();

        set.getData().add(new XYChart.Data<>("Online", 4));
        set.getData().add(new XYChart.Data<>("Offline", 1));

        activePlayersChart.getData().addAll(set);
    }

    @Override
    public void run() {
        try {

            serverSocket = new ServerSocket(5005);
            while (true) {

                Socket s = serverSocket.accept();

                new UserHandler(s);

            }
        } catch (IOException ex) {
            Logger.getLogger(ServerController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void exitButton(ActionEvent event) {
        isOpened = false;
        thread.suspend();
        System.out.println("closed");
//        try {
//            
//            serverSocket.close();
//           
//            for (UserHandler user : UserHandler.userVector) {
//                user.ps.close();
//                user.dis.close();
//                user.stop();
//            }
//            UserHandler.userVector.clear();
//            
//            
//            System.out.println("close");
//        } catch (IOException ex) {
//            Logger.getLogger(ServerController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public void startButton(ActionEvent event) {
        if (isStartedBefore == false) {
            System.out.println("server is working");
            thread = new Thread(this);
            thread.start();
            isStartedBefore = true;
            isOpened = true;

        } else if (isStartedBefore == true && isOpened == false) {
            System.out.println("server is working");
            thread.resume();
            isOpened = true;

        } else if (isStartedBefore == true && isOpened == true) {

            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setHeaderText("Already Started !");
            a.setTitle("Pay Attention");
            Optional<ButtonType> result = a.showAndWait();

        }

    }

}
