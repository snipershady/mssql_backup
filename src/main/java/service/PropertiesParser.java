
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
    private static final String PROPFILENAME = "config/config.properties";
    
    private PropertiesParser(){}
    
    
    private static String getValue(String key) throws FileNotFoundException, IOException {
       
    String result = null;
    Properties p = new Properties();
    File f =  new File(PROPFILENAME); 

        try {
            FileInputStream fIn = new FileInputStream(f);
            p.load(fIn);
            result = p.getProperty(key); //Get the field db_name from Property file
        } catch (IOException e) {
             System.err.println("Errore: "+e.getMessage());
             System.out.println("Please confiure a proper file inside your config folder");
             System.exit(0);
        }

    return result;
    }
    
    /**
     * 
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static String getDbName() throws FileNotFoundException, IOException {
       
    String result = null;
    Properties p = new Properties();
    File f =  new File(PROPFILENAME); 

        try {
            FileInputStream fIn = new FileInputStream(f);
            p.load(fIn);
            result = p.getProperty("db_name"); //Get the field db_name from Property file
        } catch (IOException e) {
             System.err.println("Errore: "+e.getMessage());
             System.out.println("Please confiure a proper file inside your config folder");
             System.exit(0);
        }

    return result;
    }
    
    
    /**
     *
     * @param dBname
     */
    public static void setDbName(String dBname) {
        try {
            Properties p = new Properties();
            p.setProperty("db_name", dBname);

            File file = new File("config.properties");
             try (FileOutputStream fOut = new FileOutputStream(file)) {
                 p.store(fOut, null);
             }
        } catch (FileNotFoundException e) {
            System.err.println("Errore: "+e.getMessage());
            System.exit(0);
        } catch (IOException e) {
            System.err.println("Errore: "+e.getMessage());
            System.exit(0);
        }
    }
    
    /**
     * 
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static String getDbHost() throws FileNotFoundException, IOException {
       
    String result = null;
    Properties p = new Properties();
    File f =  new File(PROPFILENAME);

        try {
            FileInputStream fIn = new FileInputStream(f);
            p.load(fIn);
            result = p.getProperty("db_host"); //Get the field db_host from Property file
        } catch (IOException e) {
             System.err.println("Errore: "+e.getMessage());
        }

    return result;
    }
    
    
    /**
     *
     * @param dBhost
     */
    public static void setDbHost(String dBhost) {
        try {
            Properties p = new Properties();
            p.setProperty("db_host", dBhost);

            File file = new File("config.properties");
             try (FileOutputStream fOut = new FileOutputStream(file)) {
                 p.store(fOut, null);
             }
        } catch (FileNotFoundException e) {
            System.err.println("Errore: "+e.getMessage());
        } catch (IOException e) {
            System.err.println("Errore: "+e.getMessage());
        }
    }
    
    /**
     * 
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static String getDbPass() throws FileNotFoundException, IOException {
       
    String result = null;
    Properties p = new Properties();
    File f =  new File(PROPFILENAME);

        try {
            FileInputStream fIn = new FileInputStream(f);
            p.load(fIn);
            result = p.getProperty("db_pass"); //Get the field db_pass from Property file
        } catch (IOException e) {
             System.err.println("Errore: "+e.getMessage());
        }

    return result;
    }
    
    
    /**
     *
     * @param dBpass
     */
    public static void setDbPass(String dBpass) {
        try {
            Properties p = new Properties();
            p.setProperty("db_pass", dBpass);

            File file = new File("config.properties");
             try (FileOutputStream fOut = new FileOutputStream(file)) {
                 p.store(fOut, null);
             }
        } catch (FileNotFoundException e) {
            System.err.println("Errore: "+e.getMessage());
        } catch (IOException e) {
            System.err.println("Errore: "+e.getMessage());
        }
    }
    
    
    /**
     * 
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static String getDbUser() throws FileNotFoundException, IOException {
       
    String result = null;
    Properties p = new Properties();
    File f =  new File(PROPFILENAME);

        try {
            FileInputStream fIn = new FileInputStream(f);
            p.load(fIn);
            result = p.getProperty("db_user"); //Get the field db_user from Property file
        } catch (IOException e) {
             System.err.println("Errore: "+e.getMessage());
        }

    return result;
    }
    
    
    /**
     * 
     * @param dBuser 
     */
    public static void setDbUser(String dBuser) {
        try {
            Properties p = new Properties();
            p.setProperty("db_user", dBuser);

            File file = new File("config.properties");
             try (FileOutputStream fOut = new FileOutputStream(file)) {
                 p.store(fOut, null);
             }
        } catch (FileNotFoundException e) {
            System.err.println("Errore: "+e.getMessage());
        } catch (IOException e) {
            System.err.println("Errore: "+e.getMessage());
        }
    }
    
    /**
     * 
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static String getDbPort() throws FileNotFoundException, IOException {
    String result = null;
    Properties p = new Properties();
    File f =  new File(PROPFILENAME);

        try {
            FileInputStream fIn = new FileInputStream(f);
            p.load(fIn);
            result = p.getProperty("db_port"); //Get the field db_port from Property file
        } catch (IOException e) {
             System.err.println("Errore: "+e.getMessage());
        }

    return result;
    }
    
    
    /**
     * 
     * @param dBport 
     */
    public static void setDbPort(String dBport) {
        try {
            Properties p = new Properties();
            p.setProperty("db_port", dBport);

            File file = new File("config.properties");
             try (FileOutputStream fOut = new FileOutputStream(file)) {
                 p.store(fOut, null);
             }
        } catch (FileNotFoundException e) {
            System.err.println("Errore:  "+e.getMessage());
        } catch (IOException e) {
            System.err.println("Errore: "+e.getMessage());
        }
    }
   
    
    /**
     * 
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static String getServerPath() throws FileNotFoundException, IOException {
    String result = null;
    Properties p = new Properties();
    File f =  new File(PROPFILENAME);

        try {
            FileInputStream fIn = new FileInputStream(f);
            p.load(fIn);
            result = p.getProperty("server_path"); //Get the field server_path from Property file
        } catch (IOException e) {
             System.err.println("Errore: "+e.getMessage());
        }

    return result;
    }
    
    
    /**
     *
     * @param serverPath
     */
    public static void setServerPath(String serverPath) {
        try {
            Properties p = new Properties();
            p.setProperty("server_path", serverPath);

            File file = new File("config.properties");
             try (FileOutputStream fOut = new FileOutputStream(file)) {
                 p.store(fOut, null);
             }
        } catch (FileNotFoundException e) {
            System.err.println("Errore: "+e.getMessage());
        } catch (IOException e) {
            System.err.println("Errore: "+e.getMessage());
        }
    }
    
//    public static String getLicenseIntro() throws FileNotFoundException, IOException {
//        return getValue("license_intro");
//    }
//    
//    public static String getAuthors() throws FileNotFoundException, IOException {
//        return getValue("authors");
//    }
//    
//    public static String getLicenseFooter() throws FileNotFoundException, IOException {
//        return getValue("license_footer");
//    }
//    
//    public static String getVersion()throws FileNotFoundException, IOException {
//        return getValue("version") + "." + getValue("build");
//    }
    
}
