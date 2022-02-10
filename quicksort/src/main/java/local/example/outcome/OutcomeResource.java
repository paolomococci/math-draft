package local.example.outcome;

import io.netty.handler.codec.http.HttpResponseStatus;
import local.example.outcome.model.Item;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

@Path("/outcome")
public class OutcomeResource {

    private final Set<Item> items = Collections.newSetFromMap(
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
        if (items.isEmpty()) {
            return Response.ok().build();
        }
        return Response.ok(items).build();
    }

    @POST
    @Path("/sorting")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Set<Item> compute() {
        return null;
    }
}
