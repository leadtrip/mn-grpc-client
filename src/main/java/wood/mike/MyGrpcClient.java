package wood.mike;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.micronaut.context.annotation.Factory;
import io.micronaut.grpc.annotation.GrpcChannel;
import jakarta.inject.Singleton;
import wood.mike.SimpleServiceGrpc;

@Factory
public class MyGrpcClient {

    static final String NODE_SERVICE = "nodeservice";

    @Singleton
    SimpleServiceGrpc.SimpleServiceBlockingStub blockingStub(@GrpcChannel(NODE_SERVICE) ManagedChannel channel) {
        return SimpleServiceGrpc.newBlockingStub(channel);
    }

    @Singleton
    ManagedChannel managedChannel() {
        return ManagedChannelBuilder.forAddress(NODE_SERVICE, 50051).usePlaintext().build();
    }
}
