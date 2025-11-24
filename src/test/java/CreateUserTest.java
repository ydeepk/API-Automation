import core.ApiClient;
import core.EndPoints;
import core.ResponseValidator;
import io.restassured.response.Response;
import models.CreateUserRequest;
import org.testng.annotations.Test;
import utils.FakerUtils;

/**
 * Test class for creating a new user.
 */
public class CreateUserTest {

    /** Validates that a user can be created successfully. */
    @Test
    public void createUser() {
        CreateUserRequest requestBody = new CreateUserRequest(
                FakerUtils.randomName(),
                "AI Engineer"
        );

        Response response = ApiClient.post(EndPoints.CREATE_USER, requestBody);

        ResponseValidator.validateStatus(response, 201);

        System.out.println("Response: " + response.asString());
    }
}
