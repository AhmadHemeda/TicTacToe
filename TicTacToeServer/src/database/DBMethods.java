/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.ArrayList;

/**
 *
 * @author SOHA
 */
public interface DBMethods {
    
     public String getPlayers();
     public String registerPlayer(Player player); 
     public String loginPlayer(String Name,String password); 

    
}
