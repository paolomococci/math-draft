package local.example.outcome;

import io.quarkus.test.junit.QuarkusTest;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class OutcomeResourceTest {

    @Test
    public void testReadEndpoint() {
        given()
          .when().get("/outcome")
          .then()
             .statusCode(HttpStatus.SC_OK);
    }
}
