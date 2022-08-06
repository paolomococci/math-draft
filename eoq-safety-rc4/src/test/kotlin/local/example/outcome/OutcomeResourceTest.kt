package local.example.outcome

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import org.apache.http.HttpStatus
import org.hamcrest.CoreMatchers.`is`
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

    companion object {
        private const val BASE_PATH = "/outcome"
        private const val JSON_DATA =
            """
                {"demand":4400.0,"sigmaDemand":11.18,"procurementLeadTime":5.0,"sigmaProcurementLeadTime":1.0,"serviceLevelKey":2.06,"costOfIssuing":20.5,"price":10.0,"interestRate":0.12,"stockRate":0.01,"spaceRate":0.06}
            """
        private const val JSON_OUTCOME =
            "[{\"id\":\"0\",\"demand\":4400.0,\"sigmaDemand\":11.18,\"procurementLeadTime\":5.0,\"sigmaProcurementLeadTime\":1.0,\"serviceLevelKey\":2.06,\"costOfIssuing\":20.5,\"price\":10.0,\"interestRate\":0.12,\"stockRate\":0.01,\"spaceRate\":0.06,\"quantity\":308,\"ordersToProcess\":14,\"cycleStock\":154,\"safetyStock\":66,\"reorderLevel\":166}]"
    }
}
