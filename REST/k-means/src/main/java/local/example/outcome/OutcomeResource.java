package local.example.outcome;

import local.example.outcome.model.ClusterView;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

@Path("/outcome")
public class OutcomeResource {

    private final Set<ClusterView> clusterViews = Collections.newSetFromMap(
        Collections.synchronizedMap(
                new LinkedHashMap<>()
        )
    );

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response read() {
        if (clusterViews.isEmpty()) {
            return Response.ok().build();
        }
        return Response.ok(clusterViews).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Set<ClusterView> compute(ClusterView clusterView) {
        clusterView.setView();
        clusterViews.add(clusterView);
        return clusterViews;
    }
}
