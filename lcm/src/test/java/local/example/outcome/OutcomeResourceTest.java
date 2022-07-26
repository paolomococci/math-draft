package local.example.outcome;

import io.quarkus.test.junit.QuarkusTest;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class OutcomeResourceTest {

    private static final String BASE_PATH = "/outcome";
    private static final String JSON_DATA = """
            
            """;
    private static final String JSON_OUTCOME =
            "";

    @Test
    public void readEndpointTest() {
        given()
          .when().get("/outcome")
          .then()
             .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void testComputeEndpoint() {
        given().contentType(ContentType.JSON)
                .body(JSON_DATA).when().post(BASE_PATH)
                .then().statusCode(HttpStatus.SC_OK)
                .body(is(JSON_OUTCOME));
    }
}
