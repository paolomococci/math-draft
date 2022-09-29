package local.example.outcome;

import io.quarkus.test.junit.QuarkusTest;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class OutcomeResourceTest {

    private static final String BASE_PATH = "/outcome";

    @Test
    public void endpointTest() {
        given().when().get(BASE_PATH)
                .then().statusCode(HttpStatus.SC_OK);
    }
}
