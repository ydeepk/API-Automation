// Package declaration for test classes
package tests;

// Importing RestAssured for API testing, handling API responses, Assert for validation and test methods
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


// Test class for validating GET user API requests
public class GetUserTest {

    // Test method to verify the GET users API endpoint
    @Test
    public void testGetUsers() {
        // Set the base URI for the API
        RestAssured.baseURI = "https://reqres.in";

        // Step 1: Send GET request to fetch users from page 2
        Response response = RestAssured
                .given() // Initialize request specifications
                    .header("x-api-key", "reqres-free-v1")
                .when() // Define the HTTP method and endpoint
                .get("/api/users?page=2")
                .then() // Extract the response
                    .extract().response();

        // Step 2: Print response details for debugging
        System.out.println("Status Code: " + response.getStatusCode()); // Log the HTTP status code
        System.out.println("Response Body: " + response.asPrettyString()); // Log the formatted response body

        // Step 3: Validate the response
        Assert.assertEquals(response.getStatusCode(), 200, "Status code is not 200"); // Verify status code is 200 (OK)
        Assert.assertTrue(response.asString().contains("Michael"), "User not found in response"); // Verify user "Michael" is in the response
    }
}