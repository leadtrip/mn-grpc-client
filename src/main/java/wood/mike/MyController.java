package wood.mike;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.UUID;

@Controller("/api")
public class MyController {

    private final SimpleServiceGrpc.SimpleServiceBlockingStub blockingStub;

    public MyController(SimpleServiceGrpc.SimpleServiceBlockingStub blockingStub) {
        this.blockingStub = blockingStub;
    }

    @Get("/call")
    public String callGrpcService() {
        SimpleRequest request = SimpleRequest.newBuilder().setName(UUID.randomUUID().toString()).build();
        SimpleReply response = blockingStub.send(request);
        return response.getMessage();
    }
}