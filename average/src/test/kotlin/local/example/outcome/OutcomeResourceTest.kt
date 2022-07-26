package local.example.outcome

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import io.restassured.http.ContentType

import org.apache.http.HttpStatus

import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

@QuarkusTest
class OutcomeResourceTest {

    @Test
    fun testReadEndpoint() {
        given()
          .`when`().get("/outcome")
          .then()
             .statusCode(HttpStatus.SC_OK)
    }

    @Test
    fun testComputeEndpoint() {
        given().contentType(ContentType.JSON)
            .body(JSON_DATA).`when`().post(BASE_PATH)
            .then().statusCode(HttpStatus.SC_OK)
            .body(`is`(JSON_OUTCOME))
    }

    companion object {
        private const val BASE_PATH = "/outcome"
        private const val JSON_DATA =
            "{\"values\":[2.3,7.1,3.5,6.2,9.0]}"
        private const val JSON_OUTCOME =
            "[{\"values\":[2.3,7.1,3.5,6.2,9.0],\"mu\":5.619999999999999}]"
    }
}
