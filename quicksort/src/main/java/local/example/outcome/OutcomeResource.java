package local.example.outcome;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/outcome")
public class OutcomeResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String feedback() {
        return "-- outcome feedback --";
    }

    @GET
    @Path("/sorted")
    @Produces(MediaType.APPLICATION_JSON)
    public Response read() {
        return Response.ok().build();
    }
}
