package local.example.service

import io.smallrye.mutiny.Uni

import local.example.hello.grpc.Greeter
import local.example.hello.grpc.HelloReply
import local.example.hello.grpc.HelloRequest

class SampleService : Greeter {

    override fun sayHello(helloRequest: HelloRequest?): Uni<HelloReply> {
        return Uni.createFrom().item {
            HelloReply.newBuilder().setMessage(
                "Hello " + helloRequest!!.name
            ).build()
        }
    }
}
