package local.example.outcome

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.apache.http.HttpStatus
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

@QuarkusTest
class OutcomeResourceTest {

    @Test
    fun testReadEndpoint() {
        given()
            .`when`().get(BASE_PATH)
            .then().statusCode(HttpStatus.SC_OK)
    }

    companion object {
        private const val BASE_PATH = "/outcome"
    }
}
