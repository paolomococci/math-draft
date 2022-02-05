package local.example.outcome;

import local.example.outcome.model.Lcm;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

@Path("/outcome")
public class OutcomeResource {

    private final Set<Lcm> lcms = Collections.newSetFromMap(
            Collections.synchronizedMap(
                    new LinkedHashMap<>()
            )
    );

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response read() {
        return Response.ok(this.lcms).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Set<Lcm> compute(Lcm lcm) {
        lcm.setLcm();
        lcms.add(lcm);
        return lcms;
    }
}
