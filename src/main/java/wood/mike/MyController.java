package wood.mike;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/api")
public class MyController {

    private final SimpleServiceGrpc.SimpleServiceBlockingStub asyncStub;

    public MyController(SimpleServiceGrpc.SimpleServiceBlockingStub asyncStub) {
        this.asyncStub = asyncStub;
    }

    @Get("/sayHi/{name}")
    public String sayHi(String name) {
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        System.out.println(asyncStub.sayHi(request));
        return "Async gRPC call initiated.";
    }
}