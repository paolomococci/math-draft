package local.example.outcome;

import io.netty.handler.codec.http.HttpResponseStatus;
import io.quarkus.test.junit.QuarkusTest;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class OutcomeResourceTest {

    private static final String
            MESSY = "{\"items\":[{\"key\":98,\"name\":\"ninety eight\"},{\"key\":783,\"name\":\"seven hundred eighty three\"},{\"key\":32,\"name\":\"thirty two\"},{\"key\":457,\"name\":\"four hundred and fifty-seven\"},{\"key\":344,\"name\":\"three hundred and forty-four\"},{\"key\":4,\"name\":\"four\"}]}";

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
        given()
            .contentType(ContentType.JSON)
            .body(MESSY)
            .when().post("/outcome/sorting")
            .then().statusCode(HttpResponseStatus.OK.code())
            .body("items.key[0][0]", equalTo(4))
            .body("items.name[0][0]", equalTo("four"))
            .body("items.key[0][5]", equalTo(783))
            .body("items.name[0][5]", equalTo("seven hundred eighty three"));
    }
}
