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
                jsonObject["costOfStock"].toString().toDouble(),
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
                (377).toString(),
                eoq.quantity.toString()
            )
            Assertions.assertEquals(
                (145).toString(),
                eoq.ordersToProcess.toString()
            )
            Assertions.assertEquals(
                (750).toString(),
                eoq.cycleStock.toString()
            )
            Assertions.assertEquals(
                (501).toString(),
                eoq.safetyStock.toString()
            )
            Assertions.assertEquals(
                (1251).toString(),
                eoq.reorderLevel.toString()
            )
        }
    }

    companion object {
        private const val BASE_PATH = "/outcome"
        private const val JSON_DATA =
            """
                {"demand":54750,"sigmaDemand":15,"procurementLeadTime":10,"sigmaProcurementLeadTime":2.0,"serviceLevelKey":1.65,"costOfIssuing":14,"price":73,"interestRate":0.12,"costOfStock":1}
            """
        private const val JSON_OUTCOME =
            "[{\"id\":\"0\",\"demand\":54750.0,\"sigmaDemand\":15.0,\"procurementLeadTime\":10.0,\"sigmaProcurementLeadTime\":2.0,\"serviceLevelKey\":1.65,\"costOfIssuing\":14.0,\"price\":73.0,\"interestRate\":0.12,\"costOfStock\":1.0,\"quantity\":377,\"ordersToProcess\":145,\"cycleStock\":750,\"safetyStock\":501,\"reorderLevel\":1251}]"
    }
}
