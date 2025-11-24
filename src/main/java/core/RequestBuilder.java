package core;

import config.ConfigManager;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.HttpClientConfig;

/**
 * Builds and returns pre-configured RestAssured request specifications.
 *
 * Default configuration includes base URI, content type, logging, and timeout.
 * Timeout is read from configuration properties.
 *
 */
public class RequestBuilder {

    /**
     * Returns a RequestSpecification with default headers, base URI, logging, and timeout.
     *
     * @return pre-configured RequestSpecification
     */
    public static RequestSpecification getRequest() {
        // Read timeout from configuration (in milliseconds)
        int timeout = Integer.parseInt(ConfigManager.get("default_timeout"));

        // Build request specification with base URI, headers, logging, and timeout
        return given()
                .baseUri(ConfigManager.get("reqresBaseURI"))
                .header("Content-Type", "application/json")
                .header("x-api-key", "reqres-free-v1")
                .log().all()
                .config(RestAssuredConfig.config()
                        .httpClient(HttpClientConfig.httpClientConfig()
                                .setParam("http.connection.timeout", timeout)
                                .setParam("http.socket.timeout", timeout)
                                .setParam("http.connection-manager.timeout", timeout)));
    }
}
