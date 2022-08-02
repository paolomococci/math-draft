package local.example.outcome

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import local.example.outcome.model.Eoq
import org.apache.http.HttpStatus
import org.hamcrest.CoreMatchers.`is`
import org.json.JSONArray
import org.junit.jupiter.api.*
import java.util.*

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class OutcomeResourceTest {

    @Test
    @Order(1)
    fun testReadEndpoint() {
        given()
            .`when`().get(BASE_PATH)
            .then()
            .statusCode(HttpStatus.SC_OK)
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
    fun testReadObjectStoredSoFar() {
        val response = given()
            .`when`().get(BASE_PATH)
            .then().statusCode(HttpStatus.SC_OK).extract().body()
        val jsonArray = JSONArray(response.asString())
        if (!jsonArray.isEmpty) {
            val jsonObject = jsonArray.getJSONObject(0)
            val eoq = Eoq(
                jsonObject["id"].toString(),
                jsonObject["demand"].toString().toDouble(),
                jsonObject["standardDeviationPerDay"].toString().toDouble(),
                jsonObject["procurementLeadTime"].toString().toDouble(),
                jsonObject["serviceLevelKey"].toString().toDouble(),
                jsonObject["costOfIssuing"].toString().toDouble(),
                jsonObject["price"].toString().toDouble(),
                jsonObject["interestRate"].toString().toDouble(),
                jsonObject["costOfStock"].toString().toDouble(),
                jsonObject["quantity"].toString().toLong(),
                jsonObject["ordersToProcess"].toString().toLong(),
                jsonObject["safetyStock"].toString().toLong(),
                jsonObject["reorderLevel"].toString().toLong(),
            )
            Assertions.assertEquals(
                (0).toString(),
                eoq.id
            )
            Assertions.assertEquals(
                (338).toString(),
                eoq.quantity.toString()
            )
            Assertions.assertEquals(
                (130).toString(),
                eoq.ordersToProcess.toString()
            )
            Assertions.assertEquals(
                (622).toString(),
                eoq.safetyStock.toString()
            )
            Assertions.assertEquals(
                (1702).toString(),
                eoq.reorderLevel.toString()
            )
        }
    }

    companion object {
        private const val BASE_PATH = "/outcome"
        private const val JSON_DATA =
            """
                {"demand":43800,"standardDeviationPerDay":100.6,"procurementLeadTime":9,"serviceLevelKey":2.06,"costOfIssuing":14,"price":73,"interestRate":0.12,"costOfStock":1}
            """
        private const val JSON_OUTCOME =
            "[{\"id\":\"0\",\"demand\":43800.0,\"standardDeviationPerDay\":100.6,\"procurementLeadTime\":9.0,\"serviceLevelKey\":2.06,\"costOfIssuing\":14.0,\"price\":73.0,\"interestRate\":0.12,\"costOfStock\":1.0,\"quantity\":338,\"ordersToProcess\":130,\"safetyStock\":622,\"reorderLevel\":1702}]"
    }
}
