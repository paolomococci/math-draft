package local.example.outcome;

import io.quarkus.test.junit.QuarkusTest;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class OutcomeResourceTest {

    private static final String BASE_PATH = "/outcome";
    private static final String JSON_DATA = """
            {"demand":2000,"costOfIssuing":125,"price":23,"interestRate":0.1}
            """;

    @Test
    public void testReadEndpoint() {
        given()
          .when().get(BASE_PATH)
          .then().statusCode(HttpStatus.SC_OK);
    }
}