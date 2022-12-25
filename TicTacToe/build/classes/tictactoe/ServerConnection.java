package tictactoe;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Optional;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class ServerConnection extends Thread {

    private static Socket userSockect;
    private static DataInputStream dis;
    private static PrintStream ps;
    private static String ip;
    private String data;
    private Parent root;
    private Stage stage;
    private Scene scene;
    public static ServerConnection signltone;
    private Vector<String> online = new Vector<>();

    private ServerConnection(String ip) throws IOException {
        this.ip = ip;

        userSockect = new Socket(ip, 5005);
        dis = new DataInputStream(userSockect.getInputStream());
        ps = new PrintStream(userSockect.getOutputStream());
        start();
    }

    public static ServerConnection getInstance(String ip) throws IOException {
        if (signltone == null) {
            signltone = new ServerConnection(ip);
        }
        return signltone;
    }

    @Override
    public void run() {
        while (true) {

            try {
                String str = "No Answer Yet";

                System.out.println(online.size());

                data = dis.readLine();
                System.out.println(data);
                String[] dataTypeSplit = data.split(",");
                int i = 0;
                if (dataTypeSplit[i].equals("onlineplayers")) {
                    online.clear();
                    String playerName;
                    for (i = 0; i < dataTypeSplit.length; i++) {
                        playerName = dataTypeSplit[i];
                        if (!playerName.equals("onlineplayers")) {
                            System.out.println(playerName);
                            online.add(playerName);
                            setOnline(online);
                            System.out.println("online Size " + online.size());
                        }

                    }
                } else if (dataTypeSplit[0].equals("PlayWithMe")) {
                    Platform.runLater(() -> {
                        Alert a = new Alert(Alert.AlertType.WARNING);
                        a.setHeaderText(dataTypeSplit[2] + " Wants To Play With You");
                        System.out.println("name of the player wants to play " + dataTypeSplit[2]);
                        a.setTitle("Play With Me");
                        Optional<ButtonType> result = a.showAndWait();
                        if (result.get() == ButtonType.OK ) {
                            try {
                                confirmPlay(RequestGameController.getMailToInvite(), RequestGameController.getMyMail());
                                Stage stage = TicTacToe.getStage();
                                Parent root = FXMLLoader.load(getClass().getResource("TwoPlayerBoard.fxml"));
                                Scene scene = new Scene(root);
                                stage.setScene(scene);
                                stage.show();
                            } catch (IOException ex) {
                                Logger.getLogger(ServerConnection.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        } else {
                            refusePlay(RequestGameController.getMailToInvite(), RequestGameController.getMyMail());
                        }
                    });

                }
                else if(getData().equals("ok")){
                     Platform.runLater(() -> {
                        Alert a = new Alert(Alert.AlertType.WARNING);
                        a.setHeaderText("your invitaion accepted");
                        System.out.println("data type " + getData());
                        a.setTitle("Let's Play");
                        Optional<ButtonType> result = a.showAndWait();
                        if (result.get() == ButtonType.OK ) {
                            try {
                                confirmPlay(RequestGameController.getMailToInvite(), RequestGameController.getMyMail());
                                Stage stage = TicTacToe.getStage();
                                Parent root = FXMLLoader.load(getClass().getResource("TwoPlayerBoard.fxml"));
                                Scene scene = new Scene(root);
                                stage.setScene(scene);
                                stage.show();
                            } catch (IOException ex) {
                                Logger.getLogger(ServerConnection.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        } else {
                            refusePlay(RequestGameController.getMailToInvite(), RequestGameController.getMyMail());
                        }
                    });
                
                
                }
                else {
                    setData(data);
                }
            } catch (IOException ex) {
                Logger.getLogger(ServerConnection.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public void writeData(String name, String mail, String password) {
        String playerInfo = "signUp" + "," + name + "," + mail + "," + password;
        ps.println(playerInfo);
        System.out.println("Write data out signUp");
    }

    public void writeDataLogin(String mail, String password) {
        String playerInfo = "login" + "," + mail + "," + password;
        ps.println(playerInfo);
        System.out.println("Write data out login");

    }

    public void requestAllOnlinePlayers() {

        ps.println("onlineplayers");

    }

    public void requestToPlay(String mailToInvite, String myMail) {

        ps.println("invite" + "," + mailToInvite + "," + myMail);

    }

    public void confirmPlay(String mailToInvite, String myMail) {

        ps.println("ok" + "," + mailToInvite + "," + myMail);

    }

    public void refusePlay(String mailToInvite, String myMail) {

        ps.println("cancel" + "," + mailToInvite + "," + myMail);

    }

    public void close() {
        try {
            ps.close();
            dis.close();
            userSockect.close();
            ServerConnection con = getInstance("127.0.0.1");
        } catch (IOException ex) {
            Logger.getLogger(ServerConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Vector<String> getOnline() {
        return online;
    }

    public void setOnline(Vector<String> online) {
        this.online = online;
    }

}
