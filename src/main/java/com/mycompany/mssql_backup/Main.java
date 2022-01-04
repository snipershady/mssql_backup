/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.mssql_backup;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import service.BackupMSSQL;
import service.PromptMessageHandler;

/**
 *
 * @author Stefano Perrini <perrini.stefano@gmail.com>
 */
public class Main {

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

        int numberOfArguments = args.length;

        if (numberOfArguments == 0) {
            System.out.println("Connessione al db in corso...");
            BackupMSSQL.getDbVersion();
            System.out.println("Avvia lo script con la flag -h");
        }

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
                LinkedList<String> ll = BackupMSSQL.getDbNamesFromMasterServer();
                ll.forEach(System.out::println);
                BackupMSSQL.backupDb(ll);
                System.exit(0);
            }
            if (param.compareToIgnoreCase("--list") == 0 || param.compareToIgnoreCase("-l") == 0) {
                
                System.err.println("List of all DB accessible with your credentials\n");
                LinkedList<String> ll = BackupMSSQL.getDbNamesFromMasterServer();
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
                BackupMSSQL.backupDb(ll);
                System.out.println("Operation Completed Succesfully");
                System.exit(0);
            }
        }

    }

}
