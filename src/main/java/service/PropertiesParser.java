package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Parse a properties file
 *
 * @author Stefano Perrini <perrini.stefano@gmail.com>
 *
 */
public final class PropertiesParser {

    // Path and filename to parse
    private final String propfilename;

    public PropertiesParser(){
        this.propfilename = "config/config.properties";
    }
    
    public PropertiesParser(String propFilename) {
        this.propfilename = propFilename;
    }

    private String getValue(String key) throws FileNotFoundException, IOException {

        String result = null;
        Properties p = new Properties();
        File f = new File(this.propfilename);

        try {
            FileInputStream fIn = new FileInputStream(f);
            p.load(fIn);
            result = p.getProperty(key); //Get the field "key" from Property file
        } catch (IOException e) {
            System.err.println("Errore: " + e.getMessage());
            System.out.println("Please configure a proper file inside your config folder");
            System.exit(0);
        }

        return result;
    }

    private boolean setParameter(String key, String value) {
        try {
            Properties p = new Properties();
            p.setProperty(key, value);

            File file = new File(this.propfilename);
            try ( FileOutputStream fOut = new FileOutputStream(file)) {
                p.store(fOut, null);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Errore: " + e.getMessage());
            System.exit(0);
        } catch (IOException e) {
            System.err.println("Errore: " + e.getMessage());
            System.exit(0);
        }
        return true;
    }

    /**
     *
     * @return @throws FileNotFoundException
     * @throws IOException
     */
    public String getDbName() throws FileNotFoundException, IOException {
        return this.getValue("db_name");

    }

    /**
     *
     * @param dBname
     * @return boolean
     */
    public boolean setDbName(String dBname) {
        return this.setParameter("db_name", dBname);
    }

    /**
     *
     * @return @throws FileNotFoundException
     * @throws IOException
     */
    public String getDbHost() throws FileNotFoundException, IOException {
        return this.getValue("db_host");
    }

    /**
     *
     * @param dBhost
     * @return
     */
    public boolean setDbHost(String dBhost) {
        return this.setParameter("db_host", dBhost);
    }

    /**
     *
     * @return @throws FileNotFoundException
     * @throws IOException
     */
    public String getDbPass() throws FileNotFoundException, IOException {
        return this.getValue("db_pass");
    }

    /**
     * 
     * @return
     * @throws IOException 
     */
    public String getDbUser() throws IOException {
        return this.getValue("db_user");
    }

    /**
     *
     * @return @throws FileNotFoundException
     * @throws IOException
     */
    public String getDbPort() throws FileNotFoundException, IOException {
        return this.getValue("db_port");
    }

    /**
     *
     * @return @throws FileNotFoundException
     * @throws IOException
     */
    public String getServerPath() throws FileNotFoundException, IOException {
        return this.getValue("server_path");

    }
    
     public String getDbListCsv() throws FileNotFoundException, IOException {
        return this.getValue("backuplist");
    }

}
