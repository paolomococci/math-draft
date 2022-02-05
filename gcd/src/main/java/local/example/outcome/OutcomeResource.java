package local.example.outcome;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

@Path(value = "/outcome")
public class OutcomeResource {

    private final Set<Gcd> gcdSet = Collections.newSetFromMap(
            Collections.synchronizedMap(
                    new LinkedHashMap<>()
            )
    );

    @GET
    public String outcome() {
        return "-- outcome feedback --";
    }

    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Set<Gcd> compute(Gcd gcd) {
        gcd.setGcd();
        gcdSet.add(gcd);
        return gcdSet;
    }
}
