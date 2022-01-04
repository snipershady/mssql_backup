package service;

import java.io.IOException;

/**
 *
 * @author Stefano Perrini <perrini.stefano@gmail.com>
 */
public class PromptMessageHandler {

    public static void displayHelpInformation() throws IOException {
        System.out.println("*******************************************************");
        System.out.println(PropertiesParser.getLicenseIntro());
        System.out.println(PropertiesParser.getAuthors());
        System.out.println(PropertiesParser.getLicenseFooter());
        System.out.println("VERSION: " + PropertiesParser.getVersion());
        System.out.println("*******************************************************");
        System.out.println("Usage: java -jar mssqlbackup.jar [OPTION]");
        System.out.println("Usage: java -jar mssqlbackup.jar [DBNAME]... [DBNAME]...");
        System.out.println("Example: java -jar mssqlbackup.jar -bl database1 database2 database3 ");
        System.out.println("Example: java -jar mssqlbackup.jar -h (to display help menu)");
        System.out.println("Option selection and interpretation\n");
        System.out.println("-h \t --help\t\t\t to display this \"help\" menu");
        System.out.println("-? \t\t\t\t to display this \"help\" menu");
        System.out.println("-v \t --version\t\t to display version");
        System.out.println("-a \t --all\t\t\t to Backup of all DB accessible with your credentials");
        System.out.println("-l \t --list\t\t\t to List all DB accessible with your credentials");
        System.out.println("-bl\t --backuplist\t\t to Backup a specified list all DB accessible with your credentials");
        System.exit(0);
    }

    public static void displayVersion() throws IOException {
        System.out.println("*******************************************************");
        System.out.println(PropertiesParser.getLicenseIntro());
        System.out.println(PropertiesParser.getAuthors());
        System.out.println(PropertiesParser.getLicenseFooter());
        System.out.println("VERSION: " + PropertiesParser.getVersion());
        System.out.println("*******************************************************");
        System.exit(0);
    }
}
