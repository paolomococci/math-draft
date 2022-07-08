package local.example.outcome;

import local.example.outcome.model.Eoq;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
}
