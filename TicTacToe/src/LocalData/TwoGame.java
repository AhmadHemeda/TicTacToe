/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LocalData;


/**
 *
 * @author SOHA
 */
public class TwoGame {
    
    private int ID;
    private String date;
    private String time;
    private String playerOneName;
    private String playerTwoName;
    private String winner;
    

    public TwoGame() {
    }

    public TwoGame( int id,String date, String time, String playerOneName, String playerTwoName, String winner) {
        
        this.ID=id;
        this.date = date;
        this.time = time;
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
        this.winner = winner;
        
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

   

    

    

    public void setPlayerOneName(String playerOneName) {
        this.playerOneName = playerOneName;
    }

    public void setPlayerTwoName(String playerTwoName) {
        this.playerTwoName = playerTwoName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public void setTime(String time) {
        this.time= time;
    }

    

    public String getPlayerOneName() {
        return playerOneName;
    }

    public String getPlayerTwoName() {
        return playerTwoName;
    }

    public String getDate() {
        return date;
    }

    public String getWinner() {
        return winner;
    }

    public String getTime() {
        return time;
    }
}
