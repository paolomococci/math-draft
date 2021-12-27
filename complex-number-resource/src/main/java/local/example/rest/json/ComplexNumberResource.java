package local.example.rest.json;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/complex")
public class ComplexNumberResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String response() {
        return "response from complex number resource";
    }
}
