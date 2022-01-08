
package com.mycompany.mssql_backup;

import java.io.IOException;
import java.sql.SQLException;
import service.ArgumentParser;
import service.BackupListRetriever;
import service.MSSQLServiceManager;
import service.PromptMessageHandler;
import service.PropertiesInizializer;

/**
 *
 * @author Stefano Perrini <perrini.stefano@gmail.com>
 */
public class Main {

    /**
     *
     * @param args
     * @throws IOException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

        int numberOfArguments = args.length;
        ArgumentParser ap = new ArgumentParser(args);
        
        if (ap.isInitRequest()) {
            PropertiesInizializer pi = new PropertiesInizializer();
            pi.init();
            System.exit(0);
        }
        
        MSSQLServiceManager ms = new MSSQLServiceManager();
        
        if (numberOfArguments == 0) {
            System.out.println("DB Connection in progress...");
            ms.getDbVersion();
            System.exit(0);
        }
       
        if (ap.isHelpRequest()) {
            PromptMessageHandler.displayHelpInformation();
            System.exit(0);
        }

        if (ap.isVersionRequest()) {
            PromptMessageHandler.displayVersion();
            System.exit(0);
        }

        if (ap.hasConfigFlag()) {
            String config;
            config = ap.getConfigFilePath();
            System.out.println(config);
        }

        if (ap.isListsRequest()) {
            PromptMessageHandler.listAllDbOfTheServer();
            System.exit(0);
        }

        if (ap.isRunAllDatabaseBackupsRequest()) {
            ms.backupAll();
            System.out.println("Operation Completed Succesfully");
            System.exit(0);
        }

        if (ap.isBackupListsRequest()) {
            BackupListRetriever blr = new BackupListRetriever(ap);
            ms.backupDb(blr.getDbList());
            System.out.println("Operation Completed Succesfully");
            System.exit(0);
        }

        System.out.println("\nPlease run command with -h or --help to dispay help menu\n");

    }

}
