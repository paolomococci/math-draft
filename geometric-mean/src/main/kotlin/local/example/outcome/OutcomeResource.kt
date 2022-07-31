package local.example.outcome

import local.example.outcome.model.GeometricMean
import java.util.*
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/outcome")
class OutcomeResource {

    private val geometricMeans = Collections.newSetFromMap(
        Collections.synchronizedMap(
            LinkedHashMap<GeometricMean, Boolean>()
        )
    )

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun read(): Response? {
        return if (
            geometricMeans.isEmpty()
        ) Response.ok().build() else Response.ok(geometricMeans).build()
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun compute(geometricMean: GeometricMean): Set<GeometricMean?>? {
        geometricMean.setGeoMu()
        geometricMeans.add(geometricMean)
        return geometricMeans
    }
}
