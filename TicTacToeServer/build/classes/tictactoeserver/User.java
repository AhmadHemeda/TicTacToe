/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeserver;

import database.DataAccessLayer;
import database.Game;
import database.Player;
import database.Steps;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User extends Thread {

    private Socket cs;
    private DataInputStream dis;
    private PrintStream ps;
    private static Vector<User> playerVector = new Vector<User>();
    private String name;
    private boolean isOnline = false;

    public Socket getCs() {
        return cs;
    }

    public void setCs(Socket cs) {
        this.cs = cs;
    }

    public PrintStream getPs() {
        return ps;
    }

    public void setPs(PrintStream ps) {
        this.ps = ps;
    }
    

    public User(Socket cs) {
        try {
            isOnline = true;
            this.cs = cs;
            dis = new DataInputStream(cs.getInputStream());
            ps = new PrintStream(cs.getOutputStream());
            User.playerVector.add(this);
            System.out.println(playerVector.size());
            start();
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public User() {
    }

    public void run() {
        while (true) {
            String str;
            String reply;
            try {
                str = dis.readLine();
                System.out.println(str);
                reply = checkRequestType(str);
                
                
               
            } catch (IOException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void sendMessageToAll(String msg) {
        for (int i = 0; i < playerVector.size(); i++) {
            playerVector.get(i).ps.println(msg);

            System.out.println(playerVector.get(i));

        }

    }

    public void sendAllOnlinePlayers() {
        String playerMail = "";
        for (int i = 0; i < playerVector.size(); i++) {

            playerMail += "onlineplayers" + "," + playerVector.get(i).getNames() + ",";
            System.out.println(playerMail);

        }
        ps.println(playerMail);

    }

    public String sendPlayRequest(String player,String sender) {
        String playerName = "";
         Socket cs=null;
         PrintStream ps=null;
        for (int i = 0; i < playerVector.size(); i++) {
            System.out.println("name of Player " + i + playerVector.get(i).getNames());
            if (playerVector.get(i).getNames().equals(player)) {
                playerName=playerVector.get(i).getNames();
                cs=playerVector.get(i).getCs();
                ps=playerVector.get(i).getPs();
                System.out.println("name of Player to invite " + playerName);
                System.out.println("name of sender " + playerName);
                
            }
            
        }
            System.out.println("player socket "+cs );
            System.out.println("player printStream "+ps );
            ps.println("PlayWithMe" + "," + playerName+","+sender);
            System.out.println("players name sent");
            return playerName;
    }

    public void sendOk(String player1, String player2) {
        String playerName1="";
        String playerName2="";
        PrintStream ps1=null;
        PrintStream ps2=null;
        for (int i = 0; i < playerVector.size(); i++) {
            System.out.println("name of Player " + i + playerVector.get(i).getNames());
            if (playerVector.get(i).getNames().equals(player1)) {
               playerName1=playerVector.get(i).getNames();
               ps1=playerVector.get(i).getPs();
                
            }
            else if(playerVector.get(i).getNames().equals(player1)){
              playerName2=playerVector.get(i).getNames();
               ps2=playerVector.get(i).getPs();
            }
           

        }
        ps1.println("ok");
        ps2.println("ok");
            System.out.println("Player 1"+playerName1);
            System.out.println("Player 1 ps"+ps1);
            System.out.println("Player 2"+playerName2);
            System.out.println("Player 2 ps"+ps2);
            System.out.println("ok");

    }

    public void sendCancel(String player1, String player2) {
        for (int i = 0; i < playerVector.size(); i++) {
            System.out.println("name of Player " + i + playerVector.get(i).getNames());
            if (playerVector.get(i).getNames().equals(player1) || playerVector.get(i).getNames().equals(player2)) {
                playerVector.get(i).ps.println("cancel");
            }

            System.out.println(playerVector.get(i));
            System.out.println("ok");

        }

    }

    public String checkRequestType(String msg) {

        String checkLogin = "DataBase Connection Error";
        String[] data = msg.split(",");

        if (data[0].equals("login")) {
            System.out.println(data);
            
            try {
                DataAccessLayer dataAccess = new DataAccessLayer();
                checkLogin = dataAccess.loginPlayer(data[1], data[2]);
                if (checkLogin == "true") {
                    setNames(data[1]);
                    setIsOnline(true);
                      sendMessageToAll(checkLogin);
                }
                sendMessageToAll(checkLogin);
                //ps.print(checkLogin);
                System.out.println(checkLogin);
                System.out.println(getNames());

            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (data[0].equals("onlineplayers")) {

            checkLogin = "onlineplayers";
             sendAllOnlinePlayers();

        } else if (data[0].equals("signUp")) {
            try {
                Player player = new Player();
                player.setName(data[1]);
                player.setMail(data[2]);
                player.setPassword(data[3]);
                DataAccessLayer dataAcessLayer = new DataAccessLayer();
                checkLogin = dataAcessLayer.registerPlayer(player);
                sendMessageToAll(checkLogin);
                //ps.print(checkLogin);
                System.out.println(checkLogin);

            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (data[0].equals("SaveGame")) {
            try {
                Game game = new Game();
                game.setGameID(Integer.parseInt(data[1]));
                game.setPlayerOneName(data[2]);
                game.setPlayerTwoName(data[3]);
                game.setDate(data[4]);
                game.setWinner(data[5]);
                game.setTime(data[6]);
                DataAccessLayer dataAcessLayer = new DataAccessLayer();
                checkLogin = dataAcessLayer.SaveGame(game);
                System.out.println(checkLogin);
                sendMessageToAll(checkLogin);

            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (data[0].equals("SaveStep")) {
            try {
                Steps step = new Steps();
                step.setGameID(Integer.parseInt(data[1]));
                step.setButton(data[2]);
                step.setText(data[3]);

                DataAccessLayer dataAcessLayer = new DataAccessLayer();
                checkLogin = dataAcessLayer.SaveStep(step);
                System.out.println(checkLogin);
                sendMessageToAll(checkLogin);

            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (data[0].equals("invite")) {
            sendPlayRequest(data[1],data[2]);
            System.out.println("invite " + data[1]+"the one who wants to play "+data[2]);
        } else if (data[0].equals("ok")) {
            sendOk(data[1], data[2]);
        } else if (data[0].equals("cancel")) {

            sendCancel(data[1], data[2]);
        }

        return checkLogin;

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
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getNames() {
        return name;
    }

    public void setNames(String name) {
        this.name = name;
    }

    public boolean isIsOnline() {
        return isOnline;
    }

    public void setIsOnline(boolean isOnline) {
        this.isOnline = isOnline;
    }

}
