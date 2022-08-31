package local.example.outcome

import local.example.outcome.model.Eoq
import java.util.*
import javax.ws.rs.*
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
        return if (
            eoqs.isEmpty()
        ) Response.ok().build() else Response.ok(eoqs).build()
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun compute(eoq: Eoq): Set<Eoq?>? {
        eoq.setEoq()
        eoqs.add(eoq)
        return eoqs
    }
}
