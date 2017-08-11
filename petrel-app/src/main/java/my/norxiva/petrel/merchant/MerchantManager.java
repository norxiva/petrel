package my.norxiva.petrel.merchant;

import my.norxiva.petrel.exception.ApiException;
import my.norxiva.petrel.merchant.query.Merchant;
import my.norxiva.petrel.merchant.query.MerchantRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class MerchantManager {

    private MerchantRepository merchantRepository;

    public MerchantManager(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }

    public Merchant getIfExist(String no) {
        Merchant merchant = new Merchant();
        merchant.setNo(no);
        Example<Merchant> example = Example.of(merchant);
        return Optional.ofNullable(merchantRepository.findOne(example))
                .orElseThrow(() -> new ApiException(String.format("merchant[%s] not found", no)));
    }

    @Transactional
    public Merchant save(Merchant merchant) {
        return merchantRepository.save(merchant);
    }
}
