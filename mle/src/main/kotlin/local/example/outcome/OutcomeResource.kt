package local.example.outcome

import local.example.outcome.model.Outcome

import java.util.*

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/outcome")
class OutcomeResource {

    private val outcome = Collections.newSetFromMap(
        Collections.synchronizedMap(
            LinkedHashMap<Outcome, Boolean>()
        )
    )

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun feedback() = "reactive feedback"
}