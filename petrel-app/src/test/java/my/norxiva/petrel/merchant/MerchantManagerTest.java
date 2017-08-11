package my.norxiva.petrel.merchant;

import lombok.extern.slf4j.Slf4j;
import my.norxiva.petrel.merchant.query.Merchant;
import my.norxiva.petrel.util.IdUtils;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class MerchantManagerTest {

    private MerchantManager merchantManager;

    public MerchantManagerTest(MerchantManager merchantManager){
        this.merchantManager = merchantManager;
    }

    public void testSave(){
        Merchant merchant = new Merchant();
        merchant.setNo(IdUtils.uuidWithNoDash());
    }
}
