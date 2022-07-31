package local.example.outcome

import local.example.outcome.model.HarmonicMean
import java.util.*
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/outcome")
class OutcomeResource {

    private val harmonicMeans = Collections.newSetFromMap(
        Collections.synchronizedMap(
            LinkedHashMap<HarmonicMean, Boolean>()
        )
    )

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello() = "Hello from RESTEasy Reactive"
}