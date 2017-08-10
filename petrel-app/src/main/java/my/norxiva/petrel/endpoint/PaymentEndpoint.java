package my.norxiva.petrel.endpoint;

import lombok.extern.slf4j.Slf4j;
import my.norxiva.petrel.endpoint.bean.CreateOrderRequest;
import my.norxiva.petrel.order.query.PaymentOrder;
import my.norxiva.petrel.order.query.PaymentOrderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;

@Slf4j
@Component
@Path("payment")
public class PaymentEndpoint {

    private PaymentOrderRepository paymentOrderRepository;

    public PaymentEndpoint(PaymentOrderRepository paymentOrderRepository) {
        this.paymentOrderRepository = paymentOrderRepository;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void order(@NotNull CreateOrderRequest createOrderRequest,
                      @Suspended final AsyncResponse asyncResponse) {

        log.info("create order: {}", createOrderRequest);

        PaymentOrder paymentOrder = new PaymentOrder();
        BeanUtils.copyProperties(createOrderRequest, paymentOrder);
        paymentOrder.setCreateTime(LocalDateTime.now());
        paymentOrder.setUpdateTime(LocalDateTime.now());
        paymentOrder.setStatus("CREATED");
        paymentOrder = paymentOrderRepository.save(paymentOrder);

        log.info("create payment order id[{}]", paymentOrder.getId());
        asyncResponse.resume(Response.ok(paymentOrder).build());
    }
}
