package core.utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public final class PropertiesManager {
    private static PropertiesManager propertiesManager;
    private Properties properties;

    private PropertiesManager() {
        init();
    }


    public static PropertiesManager getInstance() {
        if (propertiesManager == null) {
            propertiesManager = new PropertiesManager();
        }
        return propertiesManager;
    }

    private void init() {
        properties = new Properties();
        try (InputStream input = new FileInputStream("gradle.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getEnvValue(String var) {
        String property = System.getProperty(var);
        return property == null ? properties.getProperty(var) : property;
    }

    public String getProperties(String property) {
        return getEnvValue(property);
    }
}
