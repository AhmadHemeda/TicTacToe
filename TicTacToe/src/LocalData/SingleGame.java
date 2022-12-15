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
    
    private int id;
    private String playerOneName;
    private String difficulty;
    private String date;
    private String winner;
    private String time;

    public SingleGame() {
    }

    public SingleGame( int id,String playerOneName, String difficulty, String date, String winner, String time) {
        
        this.id = id;
        this.playerOneName = playerOneName;
        this.difficulty = difficulty;
        this.date = date;
        this.winner = winner;
        this.time = time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    

    public String getPlayerOneName() {
        return playerOneName;
    }

    public String getDifficulty() {
        return difficulty;
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

    

    public void setPlayerOneName(String playerOneName) {
        this.playerOneName = playerOneName;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
