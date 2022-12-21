/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author noha Ali
 */
public class RequestFromServ {
    Socket userSockect;
    DataInputStream dis;
    PrintStream ps;
    String ip;
    String requestType;
    
    public void connectServer(String ip) {
        try {
          
            userSockect = new Socket(ip, 5005);
            dis = new DataInputStream(userSockect.getInputStream());
            ps = new PrintStream(userSockect.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(SignUpConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void RequestSign(String name,String mail,String password){
        requestType="signUp";
        try {
            
            ps.println(requestType+","+name+","+mail+","+password);
            String server = dis.readLine();
        } catch (IOException ex) {
            Logger.getLogger(RequestFromServ.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    public String RequestLogin(String name,String password){
        requestType="login";
        String server="";
        
        try {
            
            ps.println(requestType+","+name+","+password);
            server = dis.readLine();
            
        } catch (IOException ex) {
            Logger.getLogger(RequestFromServ.class.getName()).log(Level.SEVERE, null, ex);
        }
        return server;
        
    
    
    }
    
}
