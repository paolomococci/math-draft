package local.example.outcome

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import org.apache.http.HttpStatus
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test

@QuarkusTest
class OutcomeResourceTest {

    @Test
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
                {"demand":43800,"standardDeviationPerDay":100.6,"procurementLeadTime":9,"serviceLevelKey":2.06,"costOfIssuing":14,"price":73,"interestRate":0.12,"costOfStock":1}
            """
        private const val JSON_OUTCOME =
            "[{\"id\":\"0\",\"demand\":43800.0,\"standardDeviationPerDay\":100.6,\"procurementLeadTime\":9.0,\"serviceLevelKey\":2.06,\"costOfIssuing\":14.0,\"price\":73.0,\"interestRate\":0.12,\"costOfStock\":1.0,\"quantity\":338,\"ordersToProcess\":130,\"safetyStock\":622,\"reorderLevel\":1702}]"
    }
}
