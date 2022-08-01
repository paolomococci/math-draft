package local.example.outcome

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import org.apache.http.HttpStatus
import org.hamcrest.CoreMatchers.`is`
import org.json.JSONArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class OutcomeResourceTest {

    @Test
    @Order(1)
    fun testReadEndpoint() {
        given()
            .`when`().get(BASE_PATH)
            .then().statusCode(HttpStatus.SC_OK)
    }

    @Test
    @Order(2)
    fun testComputeEndpoint() {
        given().contentType(ContentType.JSON)
            .body(JSON_DATA).`when`().post(BASE_PATH)
            .then().statusCode(HttpStatus.SC_OK)
            .body(`is`(JSON_OUTCOME))
    }

    @Test
    @Order(3)
    fun testComputedGeoMu() {
        val response = given().contentType(ContentType.JSON)
            .body(
                "{\"values\":[1.065,-1.09,1.1,1.12]}"
            ).`when`().post(BASE_PATH)
            .then().statusCode(HttpStatus.SC_OK).extract().body()
        val jsonArray = JSONArray(response.asString())
        val jsonObject = when {
            jsonArray.length() > 1 -> {
                jsonArray.getJSONObject(1)
            } else -> {
                jsonArray.getJSONObject(0)
            }
        }
        assertEquals(
            (1.09357).toString(),
            jsonObject["geoMu"].toString()
        )
    }

    companion object {
        private const val BASE_PATH = "/outcome"
        private const val JSON_DATA =
            "{\"values\":[1.065,1.09,1.1,1.12]}"
        private const val JSON_OUTCOME =
            "[{\"values\":[1.065,1.09,1.1,1.12],\"geoMu\":1.09357}]"
    }
}
