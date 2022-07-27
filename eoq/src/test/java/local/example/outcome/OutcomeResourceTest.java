package local.example.outcome;

import io.quarkus.test.junit.QuarkusTest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class OutcomeResourceTest {

    private static final String BASE_PATH = "/outcome";
    private static final String JSON_DATA = """
            
            """;

    @Test
    public void testReadEndpoint() {
        given()
          .when().get("/outcome")
          .then()
             .statusCode(200)
             .body(is(""));
    }
}