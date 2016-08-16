package net.company.my.resource;

import java.util.ResourceBundle;

/**
 *
 * @author Kostya
 */
public class ConfigurationManager {

    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("resource.config");

    private ConfigurationManager() {
    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
