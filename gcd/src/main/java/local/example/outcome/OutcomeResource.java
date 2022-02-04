package local.example.outcome;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/outcome")
public class OutcomeResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String outcome() {
        return "-- outcome feedback --";
    }
}
