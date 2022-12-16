package database;

import java.sql.Date;
import java.sql.Time;

public class Game {
    private int gameID;
    private String playerOneName;
    private String playerTwoName;
    private Date date;
    private String winner;
    private Time time;

    public Game() {
    }

    public Game(int gameID, String playerOneName, String playerTwoName, Date date, String winner, Time time) {
        this.gameID = gameID;
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

    public void setTime(Time time) {
        this.time = time;
    }

    public int getGameID() {
        return gameID;
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

    public Time getTime() {
        return time;
    }
    
    
}
