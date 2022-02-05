package local.example.outcome;

import local.example.outcome.model.Sieve;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

@Path("/outcome")
public class OutcomeResource {

    private final Set<Sieve> sieves = Collections.newSetFromMap(
            Collections.synchronizedMap(
                    new LinkedHashMap<>()
            )
    );

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response read() {
        if (sieves.isEmpty()) {
            return Response.ok().build();
        }
        return Response.ok(sieves).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Set<Sieve> compute(Sieve sieve) {
        sieve.setPrimes();
        sieves.add(sieve);
        return sieves;
    }
}
