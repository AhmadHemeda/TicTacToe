package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataAccessLayer implements DBMethods {

    static public Player player;
    static Connection con;
    Statement stmt;
    static ResultSet resultSet;
    static int resultStatement;
    PreparedStatement prepStatment;

    public DataAccessLayer() throws SQLException {
        con = DataBaseConn.getConnection();
        stmt = con.createStatement();
    }

    @Override
    public ArrayList<Player> getPlayers() {
        ArrayList<Player> players = new ArrayList();
        try {
            prepStatment = con.prepareStatement("SELECT * FROM users");
            resultSet = prepStatment.executeQuery();
            while (resultSet.next()) {
                players.add(new Player(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                ));

            }

        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return players;
    }

    @Override
    public String registerPlayer(Player player) {
        String registerState = "register Not Success";
        try {
            prepStatment = con.prepareStatement("INSERT INTO ROOT.USERS VALUES(?,?,?,?)");
            prepStatment.setInt(1, player.getID());
            prepStatment.setString(2, player.getMail());
            prepStatment.setString(3, player.getPassword());
            prepStatment.setString(4, player.getName());

            registerState = "register Success";

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return registerState;
    }

    @Override
    public String loginPlayer(String Name, String password) {
        String check = "NotFound";
        try {
            prepStatment = con.prepareStatement("SELECT * FROM users where username=? and password=?");
            prepStatment.setString(1, Name);
            prepStatment.setString(2, password);
            resultSet = prepStatment.executeQuery();
            while (resultSet.next()) {
                check = "Found";

            }

        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

}
