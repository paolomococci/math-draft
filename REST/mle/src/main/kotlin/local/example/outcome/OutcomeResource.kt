package local.example.outcome

import local.example.outcome.model.Outcome

import java.util.*
import javax.ws.rs.*

import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/outcome")
class OutcomeResource {

    private val outcomes = Collections.newSetFromMap(
        Collections.synchronizedMap(
            LinkedHashMap<Outcome, Boolean>()
        )
    )

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun read(): Response? {
        return if (outcomes.isEmpty()) Response.ok().build() else Response.ok(outcomes).build()
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun compute(outcome: Outcome): Set<Outcome?>? {
        outcome.setOutcome()
        outcomes.add(outcome)
        return outcomes
    }
}