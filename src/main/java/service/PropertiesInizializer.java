/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.Properties;

/**
 *
 * @author shady
 */
public class PropertiesInizializer {

    public boolean init() {
        Properties p = new Properties();
        p.setProperty("db_user", "sa");
        p.setProperty("db_pass", "");
        p.setProperty("db_host", "");
        p.setProperty("db_port", "1433");
        p.setProperty("db_name", "master");
        p.setProperty("server_path", "");
        p.setProperty("backuplist", "");

        PropertiesParser pp = new PropertiesParser();
        return pp.initAllRequiredParameters(p);
    }
}
