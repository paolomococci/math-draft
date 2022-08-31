package local.example.outcome

import local.example.outcome.model.Sigma

import java.util.*
import javax.ws.rs.*

import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/outcome")
class OutcomeResource {

    private val standardDeviations = Collections.newSetFromMap(
        Collections.synchronizedMap(
            LinkedHashMap<Sigma, Boolean>()
        )
    )

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun read(): Response? {
        return if (
            standardDeviations.isEmpty()
        ) Response.ok().build() else Response.ok(standardDeviations).build()
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun compute(standardDeviation: Sigma): Set<Sigma?>? {
        standardDeviation.setStandardDeviation()
        standardDeviations.add(standardDeviation)
        return standardDeviations
    }
}
