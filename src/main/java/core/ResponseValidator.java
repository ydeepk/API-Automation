package core;

import io.restassured.response.Response;
import org.testng.Assert;

/**
 * Utility class for validating API responses.
 */
public final class ResponseValidator {

    private ResponseValidator() {
        // Utility class; prevent instantiation.
    }

    /** Validates that the response status code matches the expected value. */
    public static void validateStatus(Response response, int expectedStatus) {
        Assert.assertEquals(response.statusCode(), expectedStatus, "Status code mismatch");
    }
}
