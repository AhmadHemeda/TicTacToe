package database;

import java.sql.Date;
import java.sql.Time;

public class Game {
    private int gameID;
    private String playerOneName;
    private String playerTwoName;
    private String date;
    private String winner;
    private String time;

    public Game() {
    }

    public Game(int gameID, String playerOneName, String playerTwoName, String date, String winner, String time) {
        this.gameID = gameID;
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
        this.date = date;
        this.winner = winner;
        this.time = time;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
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
