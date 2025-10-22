package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GetUserTest {

    @Test
    public void testGetUsers() {
        //Base URL
        RestAssured.baseURI = "https://reqres.in";

        // Step 1: Send GET Request
        Response response = RestAssured
                .given()
                .when()
                    .get("/api/users?page=2")
                .then()
                .extract().response();

        // Step 2: Print response details
        System.out.println("Status Code: "+response.getStatusCode());
        System.out.println("Response Body: "+response.asPrettyString());

        // Step 3: Assertions
        Assert.assertEquals(response.getStatusCode(),200, "Status code is not 200");
        Assert.assertTrue(response.asString().contains("Michael"), "User not found in response");
    }

}
