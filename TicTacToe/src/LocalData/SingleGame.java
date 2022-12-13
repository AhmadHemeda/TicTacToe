/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LocalData;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author SOHA
 */
public class SingleGame {
    
    private String playerOneName;
    private String difficulty;
    private Date date;
    private String winner;
    private Time time;

    public SingleGame() {
    }

    public SingleGame( String playerOneName, String difficulty, Date date, String winner, Time time) {
        
        this.playerOneName = playerOneName;
        this.difficulty = difficulty;
        this.date = date;
        this.winner = winner;
        this.time = time;
    }

    

    public String getPlayerOneName() {
        return playerOneName;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public Date getDate() {
        return date;
    }

    public String getWinner() {
        return winner;
    }

    public Time getTime() {
        return time;
    }

    

    public void setPlayerOneName(String playerOneName) {
        this.playerOneName = playerOneName;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
