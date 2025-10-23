// Package declaration for test classes
package tests;

import base.BaseAPI;
// Importing RestAssured for API testing functionality
import io.restassured.RestAssured;
// Importing Response class for handling API responses
import io.restassured.response.Response;
// Importing TestNG Assert for response validation
import org.testng.Assert;
// Importing TestNG annotation for test methods
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
// Importing custom ConfigReader utility for reading configuration properties
import utils.ConfigReader;

// Test class for validating GET requests to the Weather One Call API
public class WeatherAPIOverviewTest extends BaseAPI {



    // Test method to verify the Weather One Call API response
    @Test
    public void getWeatherOverview() {
        // Retrieve configuration properties for API request parameters
        String latitude = ConfigReader.get("defaultLat"); // Get default latitude from config (Delhi: 28.6139)
        String longitude = ConfigReader.get("defaultLon"); // Get default longitude from config (Delhi: 77.2090)
        String apiKey = ConfigReader.get("apiKey"); // Get API key for authentication
        String units = ConfigReader.get("units"); // Get units for measurement (metric for Celsius, km/h, etc.)

        // Log retrieved configuration properties for debugging and verification
        System.out.println("Retrieved properties: " + "Lat: " + latitude + ", Lon: " + longitude + ", apiKey: " + apiKey + ", units: " + units);

        // Log the full URL for debugging
        System.out.println("Request URL: "+RestAssured.baseURI+"/data/2.5/weather?lat="+latitude+"&lon="+longitude+"&appid="+apiKey);


        // Send GET request to the Weather One Call API with required query parameters
        Response response = RestAssured
                .given() // Initialize request specifications
                .queryParam("lat", latitude) // Add latitude coordinate as query parameter
                .queryParam("lon", longitude) // Add longitude coordinate as query parameter
                .queryParam("appid", apiKey) // Add API key for OpenWeatherMap authentication
                .when() // Define the HTTP method and endpoint
                .get("/data/2.5/weather") // Send GET request to the data 2.5 weather endpoint
                .then() // Extract the response from the API call
                .extract().response();


        // Log the HTTP status code of the API response
        System.out.println("Get Weather API, Status code: " + response.getStatusCode());
        // Log the formatted JSON response body for debugging and verification
        System.out.println("Get Weather API, Response Body: " + response.asPrettyString());

        // Validate that the API request was successful with HTTP status code 200 (OK)
        Assert.assertEquals(response.getStatusCode(), 200, "Expected HTTP status code is 200.");
    }
}