package wood.mike;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/api")
public class MyController {

    private final SimpleServiceGrpc.SimpleServiceBlockingStub blockingStub;

    public MyController(SimpleServiceGrpc.SimpleServiceBlockingStub blockingStub) {
        this.blockingStub = blockingStub;
    }

    @Get("/sayHi/{name}")
    public String sayHi(String name) {
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        return blockingStub.sayHi(request).getMessage();
    }
}