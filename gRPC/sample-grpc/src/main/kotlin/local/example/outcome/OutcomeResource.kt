package local.example.outcome

import io.quarkus.grpc.GrpcClient
import io.smallrye.mutiny.Uni

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

import local.example.hello.grpc.Greeter
import local.example.hello.grpc.HelloReply
import local.example.hello.grpc.HelloRequest

@Path("/outcome")
class OutcomeResource {

    @GrpcClient
    lateinit var greeter: Greeter

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello() = "Hello"

    @GET
    @Path("/{name}")
    fun hello(name: String): Uni<String> {
        return this.greeter.sayHello(
            HelloRequest.newBuilder().setName(name).build()
        ).onItem().transform {
                helloReply: HelloReply -> helloReply.message
        }
    }
}
