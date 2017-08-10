package my.norxiva.petrel.endpoint;

import org.springframework.stereotype.Component;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Component
@Path("payment")
public class PaymentEndpoint {

    @POST
    public Response order(){
        return Response.ok().entity("3").build();
    }
}
