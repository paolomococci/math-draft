package local.example.outcome

import local.example.outcome.model.Eoq
import java.util.*
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/outcome")
class OutcomeResource {

    private val eoqs = Collections.newSetFromMap(
        Collections.synchronizedMap(
            LinkedHashMap<Eoq, Boolean>()
        )
    )

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun read(): Response? {
        return if (eoqs.isEmpty()) Response.ok().build() else Response.ok(eoqs).build()
    }
}
