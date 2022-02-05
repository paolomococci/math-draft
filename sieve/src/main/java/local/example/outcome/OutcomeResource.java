package local.example.outcome;

import io.smallrye.mutiny.Uni;
import local.example.outcome.model.Sieve;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/outcome")
public class OutcomeResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Sieve> read() {
        return null;
    }
}
