package local.example.outcome

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given

import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

@QuarkusTest
class OutcomeResourceTest {

    @Test
    fun testHelloEndpoint() {
        given()
          .`when`().get("/outcome")
          .then()
             .statusCode(200)
             .body(`is`("Hello"))
    }

    @Test
    fun testHelloEndpointWithName() {
        given()
            .`when`().get("/outcome/John")
            .then()
            .statusCode(200)
            .body(`is`("Hello John"))
    }
}
