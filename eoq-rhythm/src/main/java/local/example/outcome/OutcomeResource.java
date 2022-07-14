package local.example.outcome;

import local.example.outcome.model.Eoq;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

@Path("/outcome")
public class OutcomeResource {

    private final Set<Eoq> eoqs = Collections.newSetFromMap(
            Collections.synchronizedMap(new LinkedHashMap<>())
    );

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response read() {
        if (this.eoqs.isEmpty())
            return Response.ok().build();
        return Response.ok(this.eoqs).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Set<Eoq> compute(Eoq eoq) {
        eoq.setEoq();
        this.eoqs.add(eoq);
        return this.eoqs;
    }
}
