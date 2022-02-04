package local.example.outcome;

import io.quarkus.vertx.web.Route;

import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path(value = "/outcome")
public class OutcomeResource {

    @Inject
    Gcd gcd;

    @Route(
            methods = Route.HttpMethod.GET,
            produces = MediaType.TEXT_PLAIN
    )
    public String outcome() {
        return "-- outcome feedback --";
    }

    @Route(
            path = "/gcd",
            methods = Route.HttpMethod.POST,
            consumes = MediaType.APPLICATION_JSON,
            produces = MediaType.APPLICATION_JSON
    )
    public Gcd gcd() {
        return new Gcd();
    }
}
