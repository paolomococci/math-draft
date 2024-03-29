package local.example.outcome;

import local.example.outcome.algorithm.Radixsort;
import local.example.outcome.model.Assortment;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

@Path("/outcome")
public class OutcomeResource {

    private final Set<Assortment> assortments = Collections.newSetFromMap(
            Collections.synchronizedMap(
                    new LinkedHashMap<>()
            )
    );

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String feedback() {
        return "--- sample feedback ---";
    }

    @GET
    @Path("/items")
    @Produces(MediaType.APPLICATION_JSON)
    public Response read() {
        if (assortments.isEmpty()) {
            return Response.ok().build();
        }
        return Response.ok(assortments).build();
    }

    @POST
    @Path("/sorting")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Set<Assortment> sorting(Assortment assortment) {
        assortment.fromArray(Radixsort.radixSort(assortment.toArray()));
        assortments.add(assortment);
        return assortments;
    }
}
