package local.example.outcome

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import local.example.outcome.model.HarmonicMean
import org.apache.http.HttpStatus
import org.json.JSONArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import java.util.*

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
        assertEquals((243.25).toString(), jsonObject["harmonicMu"].toString())
    }

    @Test
    @Order(3)
    fun testReadObjectStoredSoFar() {
        val response = given()
            .`when`().get(BASE_PATH)
            .then().statusCode(HttpStatus.SC_OK).extract().body()
        val jsonArray = JSONArray(response.asString())
        if (!jsonArray.isEmpty) {
            val jsonObject = jsonArray.getJSONObject(0)
            val temporaryHarmonicMean = HarmonicMean(
                this.toArray(this.toSplit(jsonObject.get("values").toString())),
                jsonObject["harmonicMu"].toString().toDouble()
            )
            assertEquals(
                (40.0).toString(),
                temporaryHarmonicMean.values[0].toString()
            )
            assertEquals(
                (243.25).toString(),
                temporaryHarmonicMean.harmonicMu.toString()
            )
        }
    }

    private fun toArray(values: Array<String>): Array<Double> {
        val doubles = Arrays.stream(values)
            .mapToDouble {
                item: String -> item.toDouble()
        }.toArray()
        return doubles.toTypedArray()
    }

    private fun toSplit(values: String): Array<String> {
        return values.removeSurrounding("[", "]")
            .takeIf(String::isNotEmpty)
            ?.split(",")
            ?.toTypedArray()
            ?: emptyArray()
    }

    companion object {
        private const val BASE_PATH = "/outcome"
        private const val JSON_DATA =
            "{\"values\":[40,700,780,850,880,970,1000,1200]}"
    }
}
