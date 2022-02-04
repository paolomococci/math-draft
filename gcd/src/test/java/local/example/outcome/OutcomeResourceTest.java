package local.example.outcome;

import io.quarkus.test.junit.QuarkusTest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class OutcomeResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/outcome")
          .then()
             .statusCode(200);
    }
}
