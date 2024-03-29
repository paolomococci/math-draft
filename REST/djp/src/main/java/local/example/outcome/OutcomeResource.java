package local.example.outcome;

import local.example.outcome.model.Graph;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

@Path("/outcome")
public class OutcomeResource {

    private final Set<Graph> graphs = Collections.newSetFromMap(
            Collections.synchronizedMap(
                    new LinkedHashMap<>()
            )
    );

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String feedback() {
        return "---> outcome feedback <---";
    }
}
