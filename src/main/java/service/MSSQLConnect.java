
package service;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;



/**
 * Connection to RDBMS MSSQL useing MSSQL official jdbc driver
 * 
 * @author Stefano Perrini <perrini.stefano@gmail.com>
 *  
 */
public final class MSSQLConnect {
    private static String host;
    private static String port;
    private static String dbname;
    private static String user;
    private static String pass;
    private static String URL; 
    private static Connection conn = null;
    
    /**
     * Private constructor
     */
    private MSSQLConnect(){}
    
    /**
     * Check if connection is closed, then it return a new connection
     * 
     * @throws SQLException if handshake is gone wrong
     * @return db connection
     */
    public static Connection getConnection() throws SQLException{
        if(conn==null || conn.isClosed())
            connect();
        return conn;
    }
    /**
     * Establishes a connection handshake with MYSQL DB
     * @throws SQLException if handshake is gone wrong
     */
    private static void connect() throws SQLException {
        try {
            host=PropertiesParser.getDbHost();
            dbname=PropertiesParser.getDbName();
            user=PropertiesParser.getDbUser();
            pass=PropertiesParser.getDbPass();
            port=PropertiesParser.getDbPort();
            MSSQLConnect.URL="jdbc:sqlserver://" +  host + ":" + port + ";databaseName=" + dbname + ";user=" + user + ";password=" + pass;

            MSSQLConnect.conn = DriverManager.getConnection(URL);            
            //System.out.println("Connesso");            
        } catch (IOException ex) {
            System.err.println("IOException "+ex.getMessage());
        }
    }
    
    /**
     * Force disconnection from db.
     * @throws java.sql.SQLException if handshake is gone wrong
     */
    public static void DatabaseDestructor() throws SQLException{
        if(conn!=null){ 
            MSSQLConnect.conn.close();
            MSSQLConnect.conn = null;
        }
    }
}
