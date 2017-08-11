package my.norxiva.petrel.endpoint;


import com.github.springtestdbunit.DbUnitTestExecutionListener;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import javax.annotation.Resource;
import java.util.Map;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class})
@AutoConfigureTestDatabase
public class PaymentEndpointTest {

    @Resource
    private TestRestTemplate restTemplate;

    @Test
    public void testOrder() {
        String merchantNo = "1";
        String message = "1";
        String signature = "1";
        ResponseEntity<Map> response = restTemplate.postForEntity("/petrel/api/payment/order" +
                        "?merchantNo={merchantNo}&message={message}&signature={signature}",
                null, Map.class, merchantNo, message, signature);
        log.info("response body: {}", response.getBody());
    }
}
