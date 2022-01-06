
package service;

import java.util.Properties;

/**
 *
 * @author shady
 */
public class PropertiesInizializer {

    /**
     * Create a new config.properties files with standard required params
     * @return boolean
     */
    public boolean init() {
        Properties p = new Properties();
        p.setProperty("db_user", "sa");
        p.setProperty("db_pass", "WRITE_YOUR_PASSWORD");
        p.setProperty("db_host", "IP_OF_THE_SQL_SERVER");
        p.setProperty("db_port", "1433");
        p.setProperty("db_name", "master");
        p.setProperty("server_path", "PATH_TO_SAVE_BACKUPS");
        p.setProperty("backuplist", "LIST_OF_DB_TO_BACKUP____LEAVE_IT_BLANK_TO_USE_CLI_ARGS***");

        PropertiesParser pp = new PropertiesParser();
        return pp.initAllRequiredParameters(p);
    }
}
