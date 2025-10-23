// Package declaration for utility classes
package utils;

// Importing necessary classes for file input and properties handling
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


// Utility class to read configuration properties from a file
public class ConfigReader {

    // Static Properties object to store configuration key-value pairs
    private static Properties properties;

    // Loads properties from the config.properties file
    public static void loadProperties() {
        // Initialize the Properties object
        properties = new Properties();
        // Try-with-resources to automatically close FileInputStream
        try (FileInputStream fis = new FileInputStream("src/main/resources/config.properties")) {
            // Load properties from the file input stream
            properties.load(fis);
        } catch (IOException e) {
            // Print stack trace for debugging
            e.printStackTrace();
            // Throw a runtime exception if file loading fails
            throw new RuntimeException("❌ Failed to load config.properties file.");
        }
    }

    // Retrieves a property value by its key
    // @param key The key for the desired property
    // @return The value associated with the key, or null if not found
    public static String get(String key) {
        // Check if properties object is null, and load properties if needed
        if (properties == null) {
            loadProperties();
        }
        // Return the property value for the given key
        return properties.getProperty(key);
    }
}