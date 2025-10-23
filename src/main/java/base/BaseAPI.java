// Package declaration for base test classes
package base;

// Importing RestAssured for API testing functionality, set up methods and reading configuration properties
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import utils.ConfigReader;


// Base test class for setting up common test configurations
public class BaseAPI {

    // Setup method to initialize test configurations before test class execution
    @BeforeClass
    public static void setup() {
        // Load configuration properties from the config file
        ConfigReader.loadProperties();
        // Set the base URI for RestAssured using the value from config properties
        RestAssured.baseURI = ConfigReader.get("baseURI");
        // Log the base URI for debugging purposes
        System.out.println("Base URI set to: " + RestAssured.baseURI);
    }
}
