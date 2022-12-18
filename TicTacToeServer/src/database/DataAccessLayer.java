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
            prepStatment = con.prepareStatement("SELECT * FROM PLAYER");
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
        String registerState = "registerNotSuccess";
        try {
            prepStatment = con.prepareStatement("INSERT INTO PLAYER(ID,MAIL,PASSWORD,NAME)VALUES(?,?,?,?)");
            prepStatment.setInt(1, getNewId());
            prepStatment.setString(2, player.getMail());
            prepStatment.setString(3, player.getPassword());
            prepStatment.setString(4, player.getName());
            prepStatment.executeUpdate();
            con.commit();
            registerState = "registerSuccess";
            

        } catch (SQLException ex) {
            registerState="registerNotSuccess";
        }
        System.out.println(registerState);
        return registerState;
    }
    
    @Override
    public String loginPlayer(String mail, String password) {
        String check = "LoginNotFound";
        try {
            prepStatment = con.prepareStatement("SELECT * FROM PLAYER where MAIL=? and PASSWORD=?");
            prepStatment.setString(1, mail);
            prepStatment.setString(2, password);
            resultSet = prepStatment.executeQuery();
            while (resultSet.next()) {
                check = "LoginFound";
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }
    
    
    public ArrayList<Game> getHistGames() {
        ArrayList<Game> games = new ArrayList();
        try {
            prepStatment = con.prepareStatement("SELECT * FROM GAME");
            resultSet = prepStatment.executeQuery();
            while (resultSet.next()) {
                games.add(new Game(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6)
                ));

            }

        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return games;
    }
    

    
    public String SaveGame(Game game) {
        String SaveGameState = "Game Not Saved";
        try {
            prepStatment = con.prepareStatement("INSERT INTO GAME VALUES(?,?,?,?,?,?)");
            prepStatment.setInt(1, getNewGameId());
            prepStatment.setString(2, game.getPlayerOneName());
            prepStatment.setString(3, game.getPlayerTwoName());
            prepStatment.setString(4, game.getDate());
            prepStatment.setString(5, game.getWinner());
            prepStatment.setString(6, game.getTime());
            prepStatment.executeUpdate();
            SaveGameState = "Game saved successfully";

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return SaveGameState;
    }
    
    public String SaveStep(Steps step) {
        String SaveGameState = "Step Not Saved";
        try {
            prepStatment = con.prepareStatement("INSERT INTO STEPS VALUES(?,?,?)");
            prepStatment.setInt(1, step.getGameID());
            prepStatment.setString(2, step.getButton());
            prepStatment.setString(3, step.getText());
            
            prepStatment.executeUpdate();
            SaveGameState = "Step saved successfully";

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return SaveGameState;
    }
    
    
    public ArrayList<Steps> getGameSteps(int gameId) {
        ArrayList<Steps> steps = new ArrayList();
        try {
            prepStatment = con.prepareStatement("SELECT * FROM STEPS WHERE GAME_ID=?");
            resultSet = prepStatment.executeQuery();
            while (resultSet.next()) {
                steps.add(new Steps(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                ));

            }

        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return steps;
    }
    
    private static Player getPlayer() {
        try {
            player = new Player(
                    resultSet.getInt("ID"),
                    resultSet.getString("MAIL"),
                    resultSet.getString("PASSWORD"),
                    resultSet.getString("NAME")
                   
                    );
                     
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return player;
    }
    
    private static Game getGame() {
        Game game = null;
        try {
            game = new Game(
                    resultSet.getInt("GAME_ID"),
                    resultSet.getString("PLAYERONENAME"),
                    resultSet.getString("PLAYERTWONAME"),
                    resultSet.getString("DATE"),
                    resultSet.getString("WINNER"),
                    resultSet.getString("TIME")
                   
                    );
                     
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return game;
    }
    
    public static Player nextContact() throws SQLException {
            if(resultSet.isLast()){
                throw new SQLException("last contact");
        
            }
            resultSet.next();
            return  getPlayer();
      
    }
    
    public int getNewId() throws SQLException{
        Statement statment=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        resultSet =statment.executeQuery("SELECT * FROM PLAYER");
        int id = 1;
        if(resultSet.last()){
         id = getPlayer().getID()+1;
        }
        return id;
    }
    
    public int getNewGameId() throws SQLException{
        Statement statment=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        resultSet =statment.executeQuery("SELECT * FROM GAME");
        int id = 1;
        if(resultSet.last()){
         id = getGame().getGameID()+1;
        }
        return id;
    }

    
   

    
}
