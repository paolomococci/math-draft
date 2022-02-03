package local.example.template;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/template")
public class TemplateResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String feedback() {
        return "-- template feedback --";
    }
}
