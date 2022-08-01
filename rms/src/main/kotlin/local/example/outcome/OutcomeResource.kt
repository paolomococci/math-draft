package local.example.outcome

import local.example.outcome.model.RootMeanSquare
import java.util.*
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/outcome")
class OutcomeResource {

    private val rootMeanSquares = Collections.newSetFromMap(
        Collections.synchronizedMap(
            LinkedHashMap<RootMeanSquare, Boolean>()
        )
    )

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun read(): Response? {
        return if (
            rootMeanSquares.isEmpty()
        ) Response.ok().build() else Response.ok(rootMeanSquares).build()
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun compute(rms: RootMeanSquare): Set<RootMeanSquare?>? {
        rms.setRmsMu()
        rootMeanSquares.add(rms)
        return rootMeanSquares
    }
}
