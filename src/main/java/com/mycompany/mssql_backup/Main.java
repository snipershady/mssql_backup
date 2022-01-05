/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.mssql_backup;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import service.ArgumentParser;
import service.MSSQLServiceManager;
import service.PromptMessageHandler;

/**
 *
 * @author Stefano Perrini <perrini.stefano@gmail.com>
 */
public class Main {

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

        int numberOfArguments = args.length;
        ArgumentParser ap = new ArgumentParser(args);
        
        MSSQLServiceManager ms = new MSSQLServiceManager();

        if (numberOfArguments == 0) {
            System.out.println("DB Connection in progress...");
            ms.getDbVersion();
        }

        if (ap.isHelpRequest()) {
            PromptMessageHandler.displayHelpInformation();
        }

        if (ap.isVersionRequest()) {
            PromptMessageHandler.displayVersion();
        }

        if (ap.hasConfigFlag()) {
            String config;
            config = ap.getConfigFilePath();
            System.out.println(config);
        }

        if (ap.isListsRequest()) {
            PromptMessageHandler.listAllDbOfTheServer();
        }

        if (ap.isRunAllDatabaseBackupsRequest()) {
            ms.backupAll();
            System.out.println("Operation Completed Succesfully");
            System.exit(0);
        }

        if (ap.isBackupListsRequest()) {
            ms.backupDb(ap.getDbList());
            System.out.println("Operation Completed Succesfully");
            System.exit(0);
        }

        System.out.println("\nPlease run command with -h or --help to dispay help menu\n");
        /*

        // With 1 param arg we will backup all databases
        if (numberOfArguments == 1) {
            String param = args[0];
            if (param.compareToIgnoreCase("--help") == 0 || param.compareToIgnoreCase("?") == 0 || param.compareToIgnoreCase("-h") == 0) {
                PromptMessageHandler.displayHelpInformation();
            }
            if (param.compareToIgnoreCase("--version") == 0 || param.compareToIgnoreCase("-v") == 0) {
                PromptMessageHandler.displayVersion();
            }
            if (param.compareToIgnoreCase("--all") == 0 || param.compareToIgnoreCase("-a") == 0) {
                System.err.println("Backup of all DB accessible with your credentials");
                LinkedList<String> ll = MSSQLServiceManager.getDbNamesFromMasterServer();
                ll.forEach(System.out::println);
                MSSQLServiceManager.backupDb(ll);
                System.exit(0);
            }
            if (param.compareToIgnoreCase("--list") == 0 || param.compareToIgnoreCase("-l") == 0) {
                
                System.err.println("List of all DB accessible with your credentials\n");
                LinkedList<String> ll = MSSQLServiceManager.getDbNamesFromMasterServer();
                ll.forEach(System.out::println);
                System.exit(0);
            }
        }

        // You can backup a list of db listed as params
        if (numberOfArguments > 1) {
            String param = args[0];
            if (param.compareToIgnoreCase("--backuplist") == 0 || param.compareToIgnoreCase("-bl") == 0) {
                
                LinkedList<String> ll = new LinkedList<>();
                for (short i = 1; i < numberOfArguments; i++) {
                    System.out.println("NomeDb: " + args[i]);
                    ll.add(args[i]);
                }
                
                System.out.println("Backup of all listed db");
                MSSQLServiceManager.backupDb(ll);
                System.out.println("Operation Completed Succesfully");
                System.exit(0);
            }
        }
         */
    }

}
