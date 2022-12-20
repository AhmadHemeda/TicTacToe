package tictactoe;

import database.Player;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
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
    private Player player = new Player();
    private ArrayList<String> playersName = new ArrayList<String>();

    public ArrayList<String> getPlayers() {
        return playersName;
    }

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

                data = dis.readLine();
                System.out.println(data);

                try {
                    requestOnlinePlayers(data);
                    setData(data);
                    Platform.runLater(() -> {
                        if (data.equals("registerSuccessregisterSuccess")) {
                            Optional<ButtonType> resultLogin = AlertClass.logInAlert().showAndWait();
                            Thread.interrupted();
                        }

                    });
                } catch (InterruptedException ex) {
                    Logger.getLogger(ServerConnection.class.getName()).log(Level.SEVERE, null, ex);
                }

            } catch (IOException ex) {
                Logger.getLogger(ServerConnection.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public Parent getRoot() {
        return root;
    }

    public void setRoot(Parent root) {
        this.root = root;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public DataInputStream getDis() {
        return dis;
    }

    public PrintStream getPs() {
        return ps;
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

    public void invetation(String nameO) {
        String playerInfo = "RequestToPlay" + "," + nameO;
        ps.println(playerInfo);
        System.out.println("Write data out invetation");

    }

    public void writeDatagetAllPlayers() {
        String playerInfo = "onlineplayers";
        ps.println(playerInfo);
        System.out.println("Write data out online");

    }

    private void requestOnlinePlayers(String data) throws InterruptedException {
        String[] dataType = data.split(",");
        switch (dataType[0]) {

            case "registerSuccess":

//                Optional<ButtonType> resultSignUp = AlertClass.signUpAlert().showAndWait();
//                notify();
                break;
            case "registerNotSuccess":

                break;
            case "LoginNotFound":
                Optional<ButtonType> resultLogin = AlertClass.logInAlert().showAndWait();
                break;
            case "RequestToPlay":
                invetation(dataType[1]);
                break;

        }

    }
}
