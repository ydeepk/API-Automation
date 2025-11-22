package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Loads configuration properties from base and environment-specific files.
 */
public class ConfigManager {

    private static final Properties properties = new Properties();
    private static Environment currentEnv;

    // Static initializer loads configuration once at startup.
    static {
        loadBaseConfig();
        loadEnvironmentConfig();
    }

    /**
     * Loads the base configuration and determines the active environment.
     */
    private static void loadBaseConfig() {
        load("config.properties");
        String envValue = properties.getProperty("env", "qa").toUpperCase();
        currentEnv = Environment.valueOf(envValue);
    }

    /**
     * Loads environment-specific configuration based on the active environment.
     */
    private static void loadEnvironmentConfig() {
        load("config-" + currentEnv + ".properties");
    }

    /**
     * Loads a properties file into the shared properties object.
     *
     * @param filename the name of the file to load
     */
    private static void load(String filename) {
        String filepath = "src/main/resources/" + filename;
        try (FileInputStream fis = new FileInputStream(filepath)) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Unable to load config file: " + filename, e);
        }
    }

    /**
     * Returns a property value for the given key.
     */
    public static String get(String key) {
        return properties.getProperty(key);
    }

    /**
     * Returns the active environment.
     */
    public static Environment getEnvironment() {
        return currentEnv;
    }
}
