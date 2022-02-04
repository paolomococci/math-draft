package local.example.outcome;

import io.quarkus.vertx.web.Route;

import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path(value = "/outcome")
public class OutcomeResource {

    @Route(
            methods = Route.HttpMethod.GET,
            produces = MediaType.TEXT_PLAIN
    )
    public String outcome() {
        return "-- outcome feedback --";
    }

    @Route(
            path = "/gcd",
            methods = Route.HttpMethod.POST
    )
    public Gcd gcd() {
        return new Gcd();
    }
}
