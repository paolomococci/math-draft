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
             .statusCode(200)
    }
}
