package local.example.outcome

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import org.apache.http.HttpStatus
import org.hamcrest.CoreMatchers.`is`
import org.json.JSONArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

@QuarkusTest
class OutcomeResourceTest {

    @Test
    fun testReadEndpoint() {
        given()
            .`when`().get(BASE_PATH)
            .then().statusCode(HttpStatus.SC_OK)
    }

    @Test
    fun testComputeEndpoint() {
        given().contentType(ContentType.JSON)
            .body(JSON_DATA).`when`().post(BASE_PATH)
            .then().statusCode(HttpStatus.SC_OK)
            .body(`is`(JSON_OUTCOME))
    }

    @Test
    fun testComputedGeoMu() {
        val response = given().contentType(ContentType.JSON)
            .body(
                "{\"values\":[1.065,-1.09,1.1,1.12]}"
            ).`when`().post(BASE_PATH)
            .then().statusCode(HttpStatus.SC_OK).extract().body()
        val jsonArray = JSONArray(response.asString())
        val jsonObject = jsonArray.getJSONObject(0)
        assertEquals(jsonObject["geoMu"].toString(), (1.09357).toString())
    }

    companion object {
        private const val BASE_PATH = "/outcome"
        private const val JSON_DATA =
            "{\"values\":[1.065,1.09,1.1,1.12]}"
        private const val JSON_OUTCOME =
            "[{\"values\":[1.065,1.09,1.1,1.12],\"geoMu\":1.09357}]"
    }
}
