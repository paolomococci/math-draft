package local.example.outcome;

import io.netty.handler.codec.http.HttpResponseStatus;
import io.quarkus.test.junit.QuarkusTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

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
    public void computeEndpointTest() {
        String json = "{\"items\":[{\"key\":1,\"name\":\"one\"},{\"key\":2,\"name\":\"two\"},{\"key\":3,\"name\":\"three\"}]}";
        Response response = given()
                .contentType(ContentType.JSON)
                .body(json)
                .when().post("/outcome/sorting")
                .then().extract().response();
        Assertions.assertEquals(
                HttpResponseStatus.OK.code(),
                response.statusCode()
        );
    }
}
