package local.example.outcome;

import io.quarkus.test.junit.QuarkusTest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class OutcomeResourceTest {

    @Test
    public void testReadEndpoint() {
        given()
          .when().get("/outcome")
          .then()
             .statusCode(200)
             .body(is(""));
    }
}