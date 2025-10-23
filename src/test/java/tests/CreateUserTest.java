// Package declaration for test classes
package tests;

// Import required libraries for REST API testing and assertions
import io.restassured.RestAssured; // RestAssured for API testing
import io.restassured.response.Response; // To handle API responses
import org.testng.Assert; // TestNG assertions for validating test results
import org.testng.annotations.Test; // TestNG annotation for test methods
import utils.ConfigReader; // Custom utility to read configuration properties
import java.util.HashMap; // HashMap for creating the request body
import java.util.Map; // Map interface for the request body

// Test class for creating a user via a POST API request
public class CreateUserTest {

    // TestNG test method to create a user
    @Test
    public void createUser() {
        // Retrieve the API key from configuration using ConfigReader
        // The key is expected to be stored in a configuration file under "reqresAPIKey"
        String apiKeyValue = ConfigReader.get("reqresAPIKey");

        // Validate that the API key is not null or empty
        // Throws a RuntimeException to fail the test if the key is invalid
        if (apiKeyValue == null || apiKeyValue.isEmpty()) {
            throw new RuntimeException("API key is null or empty in configuration");
        }

        // Create a HashMap to hold the request body for the POST request
        Map<String, String> requestBody = new HashMap<>();
        // Add user details to the request body
        requestBody.put("name", "Priyanka"); // Set the user's name
        requestBody.put("job", "House wife"); // Set the user's job title

        // Send a POST request to create a user using RestAssured
        Response response = RestAssured
                .given() // Start building the request
                .header("x-api-key", apiKeyValue) // Add API key to the request header
                .header("Content-Type", "application/json") // Set content type to JSON
                .body(requestBody) // Attach the request body (serialized to JSON)
                .log().all() // Log all request details for debugging
                .when() // Perform the request
                .post("/api/users") // Send POST request to the /api/users endpoint
                .then() // Validate the response
                .log().all() // Log all response details for debugging
                .extract().response(); // Extract the response object

        // Print the response in a formatted JSON string for debugging
        System.out.println("Response: " + response.asPrettyString());

        // Validate the HTTP status code is 201 (Created)
        // Includes a descriptive message with the actual status code if the assertion fails
        Assert.assertEquals(response.getStatusCode(), 201,
                "Expected HTTP status code is 201 but received: " + response.statusCode());

        // Validate that the response contains the correct name
        // Compares the "name" field in the response with the expected value "Priyanka"
        Assert.assertEquals(response.jsonPath().getString("name"), "Priyanka",
                "Name in response does not match, returned name is " + response.jsonPath().getString("name"));

        // Validate that the response contains the correct job title
        // Compares the "job" field in the response with the expected value "House wife"
        Assert.assertEquals(response.jsonPath().getString("job"), "House wife",
                "Job in response does not match, returned job is " + response.jsonPath().getString("job"));
    }
}