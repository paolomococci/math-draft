package local.example.outcome;

import local.example.outcome.model.Backpack;
import local.example.outcome.model.Rack;

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

    private final Set<Rack> racks = Collections.newSetFromMap(
            Collections.synchronizedMap(
                    new LinkedHashMap<>()
            )
    );

    private final Set<Backpack> backpacks = Collections.newSetFromMap(
            Collections.synchronizedMap(
                    new LinkedHashMap<>()
            )
    );

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String feedback() {
        return "--- feedback ---";
    }

    @GET
    @Path("/schema/item")
    @Produces(MediaType.TEXT_PLAIN)
    public String itemSchema() {
        return """
                item {
                    string: name,
                    double: weight,
                    double: value,
                    integer: availability
                }
                """;
    }

    @GET
    @Path("/schema/rack")
    @Produces(MediaType.TEXT_PLAIN)
    public String rackSchema() {
        return """
                rack {
                    string: name,
                    items:[
                        item {
                            string: name,
                            double: weight,
                            double: value,
                            integer: availability
                        },
                        item {
                            string: name,
                            double: weight,
                            double: value,
                            integer: availability
                        },
                        item {
                            string: name,
                            double: weight,
                            double: value,
                            integer: availability
                        },
                        ...
                    ]
                }
                """;
    }

    @GET
    @Path("/schema/backpack")
    @Produces(MediaType.TEXT_PLAIN)
    public String backpackSchema() {
        return """
                backpack {
                    string: name,
                    rack {
                        string: name,
                        items:[
                            item {
                                string: name,
                                double: weight,
                                double: value,
                                integer: availability
                            },
                            item {
                                string: name,
                                double: weight,
                                double: value,
                                integer: availability
                            },
                            item {
                                string: name,
                                double: weight,
                                double: value,
                                integer: availability
                            },
                            ...
                        ]
                    }
                }
                """;
    }

    @GET
    @Path("/racks")
    @Produces(MediaType.APPLICATION_JSON)
    public Response racks() {
        if (racks.isEmpty()) {
            return Response.ok().build();
        }
        return Response.ok(racks).build();
    }

    @GET
    @Path("/knapsacks")
    @Produces(MediaType.APPLICATION_JSON)
    public Response knapsacks() {
        if (backpacks.isEmpty()) {
            return Response.ok().build();
        }
        return Response.ok(backpacks).build();
    }
}
