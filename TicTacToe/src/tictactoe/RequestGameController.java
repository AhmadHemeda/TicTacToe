package tictactoe;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import tictactoe.PlayerLoggedIn;

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

    private String currentPlayer;
    private Vector<String> onlinePlayers;
    private ServerConnection connection;
    private String onlinePlayer;
    @FXML
    private Button refreshButton;
    private static String mailToInvite;
    private static String myMail;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            connection = ServerConnection.getInstance("127.0.0.1");

            connection.requestAllOnlinePlayers();
            Platform.runLater(() -> {

                try {
                    Thread.sleep(1000);
                    new Thread(() -> {

                        requestList.getItems().addAll(connection.getOnline());

                    }).start();
                } catch (InterruptedException ex) {
                    Logger.getLogger(RequestGameController.class.getName()).log(Level.SEVERE, null, ex);
                }

            });

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

    @FXML
    public void refreshButton(ActionEvent e) {
        try {
            connection = ServerConnection.getInstance("127.0.0.1");

            Platform.runLater(() -> {
                connection.requestAllOnlinePlayers();
                try {
                    Thread.sleep(2000);

                    requestList.getItems().clear();
                    requestList.getItems().addAll(connection.getOnline());

                } catch (InterruptedException ex) {
                    Logger.getLogger(RequestGameController.class.getName()).log(Level.SEVERE, null, ex);
                }

            });
        } catch (IOException ex) {
            Logger.getLogger(RequestGameController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void requestToPlayButton(ActionEvent e) {
        
            mailToInvite = requestList.getSelectionModel().getSelectedItem();
            myMail = PlayerLoggedIn.getMail();
            setMailToInvite(mailToInvite);
            setMyMail(myMail);
            connection.requestToPlay(mailToInvite,myMail);
            System.out.println("mail to invite "+mailToInvite);
            System.out.println("my mail "+myMail);
            Platform.runLater(() -> {
                
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(RequestGameController.class.getName()).log(Level.SEVERE, null, ex);
                }
                    String[] str = connection.getData().split(",");
                    System.out.println(str);
                    System.out.println("name of the player wants to play before if con "+str[1]);
                   
                 
            });
        
    }

    public static String getMailToInvite() {
        return mailToInvite;
    }

    public static void setMailToInvite(String mailToInvite) {
        RequestGameController.mailToInvite = mailToInvite;
    }

    public static String getMyMail() {
        return myMail;
    }

    public static void setMyMail(String myMail) {
        RequestGameController.myMail = myMail;
    }

  
    
}
