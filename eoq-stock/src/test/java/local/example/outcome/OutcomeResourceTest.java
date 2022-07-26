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
            {"demand":800,"costOfIssuing":14,"price":73,"interestRate":0.12,"costOfStock":1}
            """;
    private static final String JSON_OUTCOME =
            "[{\"demand\":800.0,\"costOfIssuing\":14.0,\"price\":73.0,\"interestRate\":0.12,\"costOfStock\":1.0,\"quantity\":46,\"ordersToProcess\":17}]";

    @Test
    public void testReadEndpoint() {
        given()
          .when().get(BASE_PATH)
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
