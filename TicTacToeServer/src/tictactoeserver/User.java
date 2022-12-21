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
    Socket cs;
    DataInputStream dis;
    PrintStream ps;
    ArrayList<Player> player=new ArrayList<Player>();
  
    static Vector<User> playerVector=new Vector<User>();
    
   
    String name;
    
    boolean isOnline=false;
    public User(Socket cs) {
        try {
            isOnline=true;
            this.cs=cs;
            dis = new DataInputStream(cs.getInputStream());
            ps = new PrintStream(cs.getOutputStream());

            User.playerVector.add(this);
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
                reply=checkRequestType(str);
                
                sendMessageToAll(reply);
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
    
    public void sendPlayRequest(String nameO) {
        for (int i = 0; i < playerVector.size(); i++) {
           if( playerVector.get(i).name.equals(nameO)){
               playerVector.get(i).ps.println("Do you want to play with me?");
           }
            
            System.out.println(playerVector.get(i));

        }

    }

    public String checkRequestType(String msg) {

        String checkLogin ="DataBase Connection Error";
        String[] data = msg.split(",");

        if (data[0].equals("login")) {
            System.out.println(data);
            name=data[1];
            try {
                DataAccessLayer dataAccess = new DataAccessLayer();
                checkLogin = dataAccess.loginPlayer(data[1], data[2]);
                ps.print(checkLogin);
                System.out.println(checkLogin);
               
                
                
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }

        }else if (data[0].equals("onlineplayers")) {
            try {
                
                DataAccessLayer dataAcessLayer = new DataAccessLayer();
                checkLogin = dataAcessLayer.getPlayers();
                ps.print(checkLogin);
               

            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }

        } 
        
        else if (data[0].equals("signUp")) {
            try {
                Player player = new Player();
                player.setName(data[1]);
                player.setMail(data[2]);
                player.setPassword(data[3]);
                DataAccessLayer dataAcessLayer = new DataAccessLayer();
                checkLogin = dataAcessLayer.registerPlayer(player);
                ps.print(checkLogin);
                System.out.println(checkLogin);

            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        else if (data[0].equals("SaveGame")) {
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

            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
        else if (data[0].equals("SaveStep")) {
            try {
                Steps step = new Steps();
                step.setGameID(Integer.parseInt(data[1]));
                step.setButton(data[2]);
                step.setText(data[3]);
                
                DataAccessLayer dataAcessLayer = new DataAccessLayer();
                checkLogin = dataAcessLayer.SaveStep(step);
                System.out.println(checkLogin);

            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        else if(data[0].equals("Invite")){
            sendPlayRequest("Ahmed");
        
        
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
 
}
