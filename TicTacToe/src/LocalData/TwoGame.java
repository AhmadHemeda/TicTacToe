/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LocalData;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

/**
 *
 * @author SOHA
 */
public class TwoGame {
    
    private String playerOneName;
    private String playerTwoName;
    private LocalDate date;
    private String winner;
    private String time;

    public TwoGame() {
    }

    public TwoGame(String playerOneName, String playerTwoName, LocalDate date, String winner, String time) {
        
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
        this.date = date;
        this.winner = winner;
        this.time = time;
    }

    

    public void setPlayerOneName(String playerOneName) {
        this.playerOneName = playerOneName;
    }

    public void setPlayerTwoName(String playerTwoName) {
        this.playerTwoName = playerTwoName;
    }

    public void setDate(Date date) {
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

    public Date getDate() {
        return date;
    }

    public String getWinner() {
        return winner;
    }

    public String getTime() {
        return time;
    }
}
