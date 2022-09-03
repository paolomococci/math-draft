package local.example.service

import io.smallrye.mutiny.Uni
import local.example.hello.grpc.Greeter
import local.example.hello.grpc.HelloReply
import local.example.hello.grpc.HelloRequest

class SampleService : Greeter {
    override fun sayHello(request: HelloRequest?): Uni<HelloReply> {
        TODO("Not yet implemented")
    }
}