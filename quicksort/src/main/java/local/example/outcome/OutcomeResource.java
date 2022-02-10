package local.example.outcome;

import local.example.outcome.algorithm.Quicksort;
import local.example.outcome.model.Item;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("/outcome")
public class OutcomeResource {

    private final Set<List<Item>> itemsSet = Collections.newSetFromMap(
            Collections.synchronizedMap(
                    new LinkedHashMap<>()
            )
    );

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String feedback() {
        return "-- outcome feedback --";
    }

    @GET
    @Path("/items")
    @Produces(MediaType.APPLICATION_JSON)
    public Response read() {
        if (itemsSet.isEmpty()) {
            return Response.ok().build();
        }
        return Response.ok(itemsSet).build();
    }

    @POST
    @Path("/sorting")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Set<List<Item>> sorting(List<Item> items) {
        Quicksort.quickSort(items);
        itemsSet.add(items);
        return itemsSet;
    }
}
