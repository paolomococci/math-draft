package local.example.outcome;

import io.quarkus.test.junit.QuarkusTest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class OutcomeResourceTest {

    private static final String
            MESSY = "{\"items\":[{\"key\":7,\"name\":\"seven\"},{\"key\":2,\"name\":\"two\"},{\"key\":4,\"name\":\"four\"},{\"key\":1,\"name\":\"one\"},{\"key\":5,\"name\":\"five\"},{\"key\":3,\"name\":\"three\"}]}";

    @Test
    public void feedbackEndpointTest() {
        given()
          .when().get("/outcome")
          .then()
             .statusCode(200)
             .body(is("--- sample feedback ---"));
    }

    @Test
    public void readEndpointTest() {
        given()
                .when().get("/outcome/items")
                .then()
                .statusCode(200);
    }

    @Test
    public void sortingEndpointTest() {
        // TODO
    }
}
