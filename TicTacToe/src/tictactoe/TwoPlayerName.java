/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;


public class TwoPlayerName {
   private static String playerOne; 
   private static String playerTwo; 

    public static String getPlayerOne() {
        return playerOne;
    }

    public static void setPlayerOne(String playerOne) {
        TwoPlayerName.playerOne = playerOne;
    }

    public static String getPlayerTwo() {
        return playerTwo;
    }

    public static void setPlayerTwo(String playerTwo) {
        TwoPlayerName.playerTwo = playerTwo;
    }

    
}
