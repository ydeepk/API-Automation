// Package declaration for test classes
package tests;

// Importing required libraries and utilities for API testing and validation
import base.BaseAPI; // Base class for API test setup (e.g., base URI configuration)
import io.restassured.RestAssured; // RestAssured for building and executing API requests
import io.restassured.response.Response; // To handle and process API responses
import org.testng.Assert; // TestNG assertions for validating test outcomes
import org.testng.annotations.Test; // TestNG annotation to mark test methods
import utils.ConfigReader; // Custom utility to read configuration properties (e.g., API key)

// Test class for validating GET user API requests, extending BaseAPI for shared setup
public class GetUserTest extends BaseAPI {

    // Test method to verify the GET users API endpoint
    @Test
    public void testGetUsers() {
        // Retrieve the API key from configuration using ConfigReader
        // Assumes "reqresAPIKey" is defined in a configuration file
        String apiKey = ConfigReader.get("reqresAPIKey");

        // Validate that the API key is not null or empty
        // Throws a RuntimeException to fail the test if the key is invalid
        if(apiKey == null || apiKey.isEmpty()) {
            throw new RuntimeException("api key is null or empty in the configuration");
        }

        // Step 1: Send GET request to fetch users from page 2
        Response response = RestAssured
                .given() // Initialize request specifications
                .log().all() // Log all request details (headers, URI, etc.) for debugging
                .header("x-api-key", apiKey) // Add API key to the request header
                .when() // Define the HTTP method and endpoint
                .get("/api/users?page=2") // Send GET request to the /api/users endpoint with page=2 query parameter
                .then() // Process the response
                .log().all() // Log all response details (status, body, headers) for debugging
                .extract().response(); // Extract the response object for further validation

        // Step 2: Print response details for debugging
        System.out.println("Status Code: " + response.getStatusCode()); // Log the HTTP status code (e.g., 200 for OK)
        System.out.println("Response Body: " + response.asPrettyString()); // Log the formatted JSON response body

        // Step 3: Validate the response
        // Verify that the HTTP status code is 200 (OK), indicating a successful request
        Assert.assertEquals(response.getStatusCode(), 200, "Status code is not 200");

        // Verify that the response contains the name "Michael" (assumes a user named Michael is on page 2)
        // Uses response.asString() to check for the presence of "Michael" in the response body
        Assert.assertTrue(response.asString().contains("Michael"), "User not found in response");
    }
}