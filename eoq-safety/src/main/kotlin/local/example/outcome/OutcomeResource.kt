package local.example.outcome

import local.example.outcome.model.Eoq
import java.util.*
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/outcome")
class OutcomeResource {

    private val eoqs = Collections.newSetFromMap(
        Collections.synchronizedMap(
            LinkedHashMap<Eoq, Boolean>()
        )
    )

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun feedback() = "get feedback string"
}
