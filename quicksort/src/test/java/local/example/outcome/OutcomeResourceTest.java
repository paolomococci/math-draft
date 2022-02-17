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

    @Test
    public void feedbackEndpointTest() {
        given()
          .when().get("/outcome")
          .then()
             .statusCode(200)
             .body(is("-- outcome feedback --"));
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
        String messy = "{\"items\":[{\"key\":7,\"name\":\"seven\"},{\"key\":2,\"name\":\"two\"},{\"key\":4,\"name\":\"four\"},{\"key\":1,\"name\":\"one\"},{\"key\":5,\"name\":\"five\"},{\"key\":3,\"name\":\"three\"}]}";
        given()
                .contentType(ContentType.JSON)
                .body(messy)
                .when().post("/outcome/sorting")
                .then().statusCode(HttpResponseStatus.OK.code())
                .body("items.key[0][0]", equalTo(1));
    }
}
