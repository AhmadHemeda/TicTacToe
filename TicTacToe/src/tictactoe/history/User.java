package tictactoe.history;

import java.sql.Date;
import java.sql.Time;

public class User {
    private int ID;
    private Date date;
    private String dificulty;
    private String player;
    private Time time;
    private String winner;

    public User(int ID, Date date, String dificulty, String player, Time time, String winner) {
        this.ID = ID;
        this.date = date;
        this.dificulty = dificulty;
        this.player = player;
        this.time = time;
        this.winner = winner;
    }

    public int getID() {
        return ID;
    }

    public Date getDate() {
        return date;
    }

    public String getDificulty() {
        return dificulty;
    }

    public String getPlayer() {
        return player;
    }

    public Time getTime() {
        return time;
    }

    public String getWinner() {
        return winner;
    }
    
    
}
