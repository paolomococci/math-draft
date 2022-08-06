package local.example.outcome

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import local.example.outcome.model.Eoq
import org.apache.http.HttpStatus
import org.hamcrest.CoreMatchers.`is`
import org.json.JSONArray
import org.junit.jupiter.api.*

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
                jsonObject["sigmaDemand"].toString().toDouble(),
                jsonObject["procurementLeadTime"].toString().toDouble(),
                jsonObject["sigmaProcurementLeadTime"].toString().toDouble(),
                jsonObject["serviceLevelKey"].toString().toDouble(),
                jsonObject["costOfIssuing"].toString().toDouble(),
                jsonObject["price"].toString().toDouble(),
                jsonObject["interestRate"].toString().toDouble(),
                jsonObject["stockRate"].toString().toDouble(),
                jsonObject["spaceRate"].toString().toDouble(),
                jsonObject["quantity"].toString().toLong(),
                jsonObject["ordersToProcess"].toString().toLong(),
                jsonObject["cycleStock"].toString().toLong(),
                jsonObject["safetyStock"].toString().toLong(),
                jsonObject["reorderLevel"].toString().toLong(),
            )
            Assertions.assertEquals(
                (0).toString(),
                eoq.id
            )
            Assertions.assertEquals(
                (308).toString(),
                eoq.quantity.toString()
            )
            Assertions.assertEquals(
                (14).toString(),
                eoq.ordersToProcess.toString()
            )
            Assertions.assertEquals(
                (154).toString(),
                eoq.cycleStock.toString()
            )
            Assertions.assertEquals(
                (66).toString(),
                eoq.safetyStock.toString()
            )
            Assertions.assertEquals(
                (166).toString(),
                eoq.reorderLevel.toString()
            )
        }
    }

    companion object {
        private const val BASE_PATH = "/outcome"
        private const val JSON_DATA =
            """
                {"demand":4400.0,"sigmaDemand":11.18,"procurementLeadTime":5.0,"sigmaProcurementLeadTime":1.0,"serviceLevelKey":2.06,"costOfIssuing":20.5,"price":10.0,"interestRate":0.12,"stockRate":0.01,"spaceRate":0.06}
            """
        private const val JSON_OUTCOME =
            "[{\"id\":\"0\",\"demand\":4400.0,\"sigmaDemand\":11.18,\"procurementLeadTime\":5.0,\"sigmaProcurementLeadTime\":1.0,\"serviceLevelKey\":2.06,\"costOfIssuing\":20.5,\"price\":10.0,\"interestRate\":0.12,\"stockRate\":0.01,\"spaceRate\":0.06,\"quantity\":308,\"ordersToProcess\":14,\"cycleStock\":154,\"safetyStock\":66,\"reorderLevel\":166,\"stockMaintenanceCost\":418.0,\"totalCostOfIssuingOrders\":null,\"totalCostOfStock\":null}]"
    }
}
