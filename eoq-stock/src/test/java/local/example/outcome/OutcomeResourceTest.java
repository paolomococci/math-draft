package local.example.outcome;

import io.quarkus.test.junit.QuarkusTest;

import io.restassured.http.ContentType;

import org.apache.http.HttpStatus;
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
             .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void testComputeEndpoint() {
        given().contentType(ContentType.JSON)
                .body("").when().post()
                .then().statusCode(HttpStatus.SC_OK);
    }
}
