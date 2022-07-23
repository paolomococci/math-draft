package local.example.outcome

import local.example.outcome.model.Outcome

import java.util.*
import javax.ws.rs.*

import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/outcome")
class OutcomeResource {

    private val outcome = Collections.newSetFromMap(
        Collections.synchronizedMap(
            LinkedHashMap<Outcome, Boolean>()
        )
    )

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun read(): Response? {
        return if (outcome.isEmpty()) Response.ok().build() else Response.ok(outcome).build()
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun compute(eoq: Outcome): Set<Outcome?>? {
        eoq.setOutcome()
        outcome.add(eoq)
        return outcome
    }
}