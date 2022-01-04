/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author @author Stefano Perrini <perrini.stefano@gmail.com>
 */
public class BackupMSSQL {

    private static String serverPath;

    /**
     * Private constructor
     */
    private BackupMSSQL() {
    }

    public static void setServerPath(String serverPath) {
        BackupMSSQL.serverPath = serverPath;
    }

    /**
     * Backup a single db directly on the server
     *
     * @param dbName
     * @throws java.sql.SQLException
     * @throws java.io.IOException
     */
    public static void backupDb(String dbName) throws SQLException, IOException {
        if (serverPath == null) {
            serverPath = PropertiesParser.getServerPath();
        }
        String prefix = DateHelper.getDateTimeForFileName();      //20171109_101744 format
        String sql = "BACKUP DATABASE " + dbName + " TO  DISK = N'" + BackupMSSQL.serverPath + "" + prefix + "_" + dbName + ".bak' WITH NOFORMAT, INIT,  NAME = N'" + dbName + "', SKIP, NOREWIND, NOUNLOAD, NO_COMPRESSION,  STATS = 10;";

        try {
            PreparedStatement ps = MSSQLConnect.getConnection().prepareStatement(sql);
            ps.execute();
        } catch (SQLException e) {
            System.err.println("Eccezione backupDb: " + e.getMessage());
        } finally {
            MSSQLConnect.DatabaseDestructor();
        }
    }

    /**
     * Backup all db handled by the user connected to the server
     *
     * @param dbList Linked list with all dbname to backup
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws java.io.IOException
     */
    public static void backupDb(LinkedList<String> dbList) throws SQLException, ClassNotFoundException, IOException {
        ListIterator<String> listIterator = dbList.listIterator();

        while (listIterator.hasNext()) {
            backupDb(listIterator.next());
        }

    }

    /**
     * Retrieve dbVersion from Microsoft SQL Server instance
     * @throws SQLException 
     */
    public static void getDbVersion() throws SQLException {

        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT @@VERSION AS version;";
        try {
            ps = MSSQLConnect.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("VERSIONE: " + rs.getString("version"));
            }

            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.err.println("Eccezione getDbNameFromMasterServer: " + e);
        } finally {
            MSSQLConnect.DatabaseDestructor();
        }
    }

    /**
     * Retrieve from persistence of a Micrsoft SQL Server list of all databases
     *
     * @return LinkedList with all db names
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static LinkedList<String> getDbNamesFromMasterServer() throws SQLException, ClassNotFoundException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        /* Linked List with all db names */
        LinkedList<String> linkedlist = new LinkedList<>();

        String sql = "SELECT name FROM master.dbo.sysdatabases;";

        try {
            ps = MSSQLConnect.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                if (rs.getString("name").compareToIgnoreCase("tempdb") != 0 && rs.getString("name").compareToIgnoreCase("master") != 0) {   //temp and master cannot be backupped or restored
                    linkedlist.add(rs.getString("name"));
                    //System.out.println("NomeDb: " + rs.getString("name"));
                }
            }

            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.err.println("Eccezione getDbNamesFromMasterServer: " + e);
        } finally {
            MSSQLConnect.DatabaseDestructor();
        }
        return linkedlist;
    }
}
