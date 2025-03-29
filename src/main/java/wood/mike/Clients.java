package wood.mike;

import io.grpc.ManagedChannel;
import io.micronaut.context.annotation.Factory;
import io.micronaut.grpc.annotation.GrpcChannel;
import jakarta.inject.Singleton;

@Factory
public class Clients {
    @Singleton
    SimpleServiceGrpc.SimpleServiceBlockingStub sayHiStub(
            @GrpcChannel("sayHi") ManagedChannel channel
    ){
        return SimpleServiceGrpc.newBlockingStub(channel);
    }
}
