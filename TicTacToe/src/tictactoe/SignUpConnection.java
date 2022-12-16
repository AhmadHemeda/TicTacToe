
package tictactoe;

import database.Player;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SignUpConnection {
   private static Socket userSockect;
   private static DataInputStream dis;
   private static PrintStream ps;
   private static String ip;

   
    public static void Connect(String ip) {
        try {
          
            userSockect = new Socket(ip, 5005);
            dis = new DataInputStream(userSockect.getInputStream());
            ps = new PrintStream(userSockect.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(SignUpConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
   
    public static void writeData(String name,String mail, String password) {
        try {
            
            
            String playerInfo="signUp"+","+name+","+mail+","+password;
            ps.println(playerInfo);
            String server = dis.readLine();
        } catch (IOException ex) {
            Logger.getLogger(SignUpConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

   public static void readData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        dis = new DataInputStream(userSockect.getInputStream());
                        String str = dis.readLine();
                       
                    } catch (IOException ex) {
                        Logger.getLogger(SignUpConnection.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }

        }).start();
    }
}
