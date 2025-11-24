import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

/**
 * Base test class for common test setup.
 */
public class BaseTest {

    /** Enables relaxed HTTPS validation before test execution. */
    @BeforeClass
    public void setUp() {
        RestAssured.useRelaxedHTTPSValidation();
    }
}
