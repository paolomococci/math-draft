package local.example.outcome

import local.example.outcome.model.HarmonicMean
import java.util.*
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/outcome")
class OutcomeResource {

    private val harmonicMeans = Collections.newSetFromMap(
        Collections.synchronizedMap(
            LinkedHashMap<HarmonicMean, Boolean>()
        )
    )

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun read(): Response? {
        return if (
            harmonicMeans.isEmpty()
        ) Response.ok().build() else Response.ok(harmonicMeans).build()
    }
}
