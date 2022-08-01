package local.example.outcome

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import org.apache.http.HttpStatus
import org.json.JSONArray
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals

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
        val response = given().contentType(ContentType.JSON)
            .body(JSON_DATA).`when`().post(BASE_PATH)
            .then().statusCode(HttpStatus.SC_OK).extract().body()
        val jsonArray = JSONArray(response.asString())
        val jsonObject = jsonArray.getJSONObject(0)
        assertEquals((868.45).toString(), jsonObject["rmsMu"].toString())
    }

    companion object {
        private const val BASE_PATH = "/outcome"
        private const val JSON_DATA =
            "{\"values\":[40,-700,780,850,880,900,-970,1000,-1200]}"
    }
}
