/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.derby.jdbc.ClientDriver;

/**
 *
 * @author SOHA
 */
public class DataBaseConn {

    private static Connection con = null;

    private DataBaseConn() {
    }

    public static Connection getConnection() throws SQLException {

        if (con == null) {
            DriverManager.deregisterDriver(new ClientDriver());
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/Player", "root", "root");

        }
        return con;
    }
    

    public static void closeConnection() throws SQLException {
        if (con != null) {
            con.close();
        }

    }

}
