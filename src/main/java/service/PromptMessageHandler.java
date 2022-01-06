package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author Stefano Perrini <perrini.stefano@gmail.com>
 */
public class PromptMessageHandler {

    public static void displayHelpInformation() throws IOException {
        System.out.println("*******************************************************");
        System.out.println(SoftwareInformation.licenseHeader);
        System.out.println(SoftwareInformation.authors);
        System.out.println(SoftwareInformation.licenseFooter);
        System.out.println("VERSION: " + SoftwareInformation.version + "." + SoftwareInformation.build);
        System.out.println("*******************************************************");
        System.out.println("Usage: java -jar mssqlbackup.jar [OPTION]");
        System.out.println("Usage: java -jar mssqlbackup.jar -bl [DBNAME]... [DBNAME]...");
        System.out.println("Example: java -jar mssqlbackup.jar -bl database1 database2 database3 ");
        System.out.println("Example: java -jar mssqlbackup.jar -h (to display help menu)\n");
        System.out.println("Option selection and interpretation\n");
        System.out.println("-h \t --help\t\t\t to display this \"help\" menu");
        System.out.println("-? \t\t\t\t to display this \"help\" menu");
        System.out.println("-v \t --version\t\t to display version");
        System.out.println("-a \t --all\t\t\t to Backup of all DB accessible with your credentials");
        System.out.println("-l \t --list\t\t\t to List all DB accessible with your credentials");
        System.out.println("-bl\t --backuplist\t\t to Backup a specified list all DB accessible with your credentials\n");
    }

    public static void displayVersion() throws IOException {
        System.out.println("*******************************************************");
        System.out.println(SoftwareInformation.licenseHeader);
        System.out.println(SoftwareInformation.authors);
        System.out.println(SoftwareInformation.licenseFooter);
        System.out.println("VERSION: " + SoftwareInformation.version + "." + SoftwareInformation.build);
        System.out.println("*******************************************************");
    }

    public static void listAllDbOfTheServer() throws SQLException, ClassNotFoundException, IOException {
        System.err.println("List of all DB accessible with your credentials\n");
        MSSQLServiceManager ms = new MSSQLServiceManager();
        LinkedList<String> ll = ms.getDbNamesFromMasterServer();
        ll.forEach(System.out::println);
    }
}
