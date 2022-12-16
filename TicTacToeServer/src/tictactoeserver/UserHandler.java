/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeserver;

import database.DataAccessLayer;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserHandler extends Thread {

    DataInputStream dis;
    PrintStream ps;
    static Vector<UserHandler> playerVector = new Vector<UserHandler>();

    public UserHandler(Socket cs) {
        try {
            dis = new DataInputStream(cs.getInputStream());
            ps = new PrintStream(cs.getOutputStream());
            UserHandler.playerVector.add(this);
            start();
        } catch (IOException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public UserHandler() {
    }

    public void run() {
        String checkLogin;
        while (true) {
            String str;
            try {
                str = dis.readLine();
                String[] data = str.split(",");
                if (data[0].equals("login")) {
                    DataAccessLayer dataAccess = new DataAccessLayer();
                    checkLogin = dataAccess.loginPlayer(data[1], data[2]);
                    sendMessageToAll(checkLogin);

                }
                sendMessageToAll(str);
            } catch (IOException ex) {
                Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void sendMessageToAll(String msg) {
        for (int i = 0; i < playerVector.size(); i++) {
            playerVector.get(i).ps.println(msg);
            //System.out.println(playerVector.get(i));

        }

    }

    public void closeAll() {
        try {
            for (int i = 0; i < playerVector.size(); i++) {
                {
                    playerVector.get(i).ps.close();
                    playerVector.get(i).dis.close();

                }

            }

        } catch (IOException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
