

package database;

import database.Player;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.derby.jdbc.ClientDriver;

public class DataAccessLayer {
     static public Player player;
    public static Connection con;
    static Statement stmt ;
    static ResultSet rs;
    static PreparedStatement prepStatement;
    public static void  Connect() throws SQLException{
        DriverManager.registerDriver(new ClientDriver());
        con =DriverManager.getConnection("jdbc:derby://localhost:1527/Player","root","root");
        SelectSQL();
    }
     public static void SelectSQL()throws SQLException{
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        rs = stmt.executeQuery("select * from PLAYER");
    }
   
   
        public static boolean insertPlayer(Player play) throws SQLException{
        prepStatement = con.prepareStatement("insert into PLAYER VALUES(?,?,?,?)");
        prepStatement.setInt(1, play.getID());
        prepStatement.setString(2, play.getMail());
        prepStatement.setString(3, play.getPassword());
        prepStatement.setString(4, play.getName());
        
       
        return prepStatement.execute();
     }
        public static String checkLogin(String name,String password)throws SQLException{
        String check="";
        prepStatement = con.prepareStatement("select * from PLAYER WHERE NAME=? AND PASSWORD=? ");
        prepStatement.setString(1, name);
        prepStatement.setString(2, password);
        prepStatement.executeQuery();
        check="Found";
        return check;
    }
     
}