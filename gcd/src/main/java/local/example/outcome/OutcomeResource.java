package local.example.outcome;

import local.example.outcome.model.Gcd;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

@Path(value = "/outcome")
public class OutcomeResource {

    private final Set<Gcd> gcds = Collections.newSetFromMap(
            Collections.synchronizedMap(
                    new LinkedHashMap<>()
            )
    );

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response read() {
        return Response.ok(gcds).build();
    }

    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Set<Gcd> compute(Gcd gcd) {
        gcd.setGcd();
        gcds.add(gcd);
        return gcds;
    }
}
