package my.norxiva.petrel.merchant;

import my.norxiva.petrel.exception.ApiException;
import my.norxiva.petrel.merchant.query.MerchantSecret;
import my.norxiva.petrel.merchant.query.MerchantSecretRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MerchantSecretManager {

    private MerchantSecretRepository merchantSecretRepository;

    public MerchantSecretManager(MerchantSecretRepository merchantSecretRepository) {
        this.merchantSecretRepository = merchantSecretRepository;
    }

    public MerchantSecret getIfExist(String no) {
        return Optional.ofNullable(merchantSecretRepository.findOne(no))
                .orElseThrow(() -> new ApiException(String.format("merchant[%s] secret not found", no)));
    }


}
