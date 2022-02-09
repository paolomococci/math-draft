package local.example.outcome;

import io.netty.handler.codec.http.HttpResponseStatus;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/outcome")
public class OutcomeResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String feedback() {
        return "-- outcome feedback --";
    }

    @GET
    @Path("/sorted")
    @Produces(MediaType.APPLICATION_JSON)
    public Response read() {
        return Response.ok().build();
    }

    @POST
    @Path("/sorted")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response compute() {
        return Response.ok().status(HttpResponseStatus.NOT_IMPLEMENTED.code()).build();
    }
}
