package my.norxiva.petrel.endpoint;

import lombok.extern.slf4j.Slf4j;
import my.norxiva.petrel.merchant.MerchantManager;
import my.norxiva.petrel.merchant.MerchantSecretManager;
import my.norxiva.petrel.merchant.query.Merchant;
import my.norxiva.petrel.merchant.query.MerchantSecret;
import my.norxiva.petrel.order.query.PaymentOrderRepository;
import org.hibernate.validator.constraints.NotEmpty;
import org.kie.api.runtime.KieContainer;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Slf4j
@Component
@Path("payment")
public class PaymentEndpoint {

    private PaymentOrderRepository paymentOrderRepository;

    private KieContainer kieContainer;

    private MerchantManager merchantManager;

    private MerchantSecretManager merchantSecretManager;

    public PaymentEndpoint(PaymentOrderRepository paymentOrderRepository,
                           KieContainer kieContainer,
                           MerchantManager merchantManager,
                           MerchantSecretManager merchantSecretManager) {
        this.paymentOrderRepository = paymentOrderRepository;
        this.kieContainer = kieContainer;
        this.merchantManager = merchantManager;
        this.merchantSecretManager = merchantSecretManager;
    }

    @POST
    @Path("{operation}")
    @Produces(MediaType.APPLICATION_JSON)
    public void operate(@PathParam("operation") @NotNull String operation,
                        @QueryParam("merchantNo") @NotEmpty String merchantNo,
                        @QueryParam("message") @NotEmpty String message,
                        @QueryParam("signature") @NotEmpty String signature,
                        @Suspended final AsyncResponse asyncResponse) {

        log.info("starting payment/{}, merchantNo: [{}], message: [{}], signature: [{}]", operation, merchantNo, message, signature);

        // check merchant no
//        Merchant merchant = merchantManager.getIfExist(merchantNo);

//        MerchantSecret secret = merchantSecretManager.getIfExist(merchantNo);


//        PaymentOrder paymentOrder = new PaymentOrder();
//        BeanUtils.copyProperties(createOrderRequest, paymentOrder);
//        paymentOrder.setCreateTime(LocalDateTime.now());
//        paymentOrder.setUpdateTime(LocalDateTime.now());
//        paymentOrder.setStatus("CREATED");
//
//        KieSession kieSession = kieContainer.newKieSession("payment-session");
//
//        FactHandle factHandle = kieSession.insert(createOrderRequest);
//        kieSession.fireAllRules();
//        kieSession.delete(factHandle); // release fact
//        kieSession.dispose(); // release kieSession
//
//        log.info(createOrderRequest.getChannelType());
//
//        paymentOrder.setChannelType(createOrderRequest.getChannelType());
//
//        paymentOrder = paymentOrderRepository.save(paymentOrder);

//        log.info("create payment order id[{}]", paymentOrder.getId());
        asyncResponse.resume(Response.ok("{\"code\": \"123\"}").build());
    }
}
