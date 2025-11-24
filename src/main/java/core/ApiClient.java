package core;

import config.ConfigManager;
import io.restassured.response.Response;

/**
 * Provides simplified methods to perform HTTP requests using RestAssured.
 *
 * Supports GET and POST requests with a centralized base URL.
 *
 */
public class ApiClient {

    /**
     * Sends a POST request to the given endpoint with the provided request body.
     *
     * @param endpoint the API endpoint (path) to send the request to
     * @param body     the request body to include in the POST request
     * @return Response object returned by the API
     */
    public static Response post(String endpoint, Object body) {
        return RequestBuilder.getRequest()
                .body(body)
                .post(endpoint);
    }

    /**
     * Sends a GET request to the given endpoint.
     *
     * @param endpoint the API endpoint (path) to send the request to
     * @return Response object returned by the API
     */
    public static Response get(String endpoint) {
        return RequestBuilder.getRequest()
                .get(endpoint);
    }
}

