package tictactoe;


import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
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
    private String dataSignUP;
    private Parent root;
    private Stage stage;
    private Scene scene;
    public static ServerConnection signltone;

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

                dataSignUP = dis.readLine();
                System.out.println(dataSignUP);
                Platform.runLater(() -> {
                    
                    if (dataSignUP.equals("registerNotSuccess")) {
                        Alert a = new Alert(Alert.AlertType.WARNING);
                        a.setHeaderText("This mail already registered before");
                        a.setTitle("Invalid Email!");
                        Optional<ButtonType> result = a.showAndWait();
                      
                    }

                });

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
  

}
