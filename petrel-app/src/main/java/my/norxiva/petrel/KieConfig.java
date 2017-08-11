package my.norxiva.petrel;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KieConfig {

    @Bean
    @ConditionalOnMissingBean(KieServices.class)
    public KieServices kieServices() {
        return KieServices.Factory.get();
    }

    @Bean
    @ConditionalOnMissingBean(KieContainer.class)
    public KieContainer kieContainer(KieServices kieServices) {
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        // preload kieBase
        kieContainer.getKieBase("payment-base");
        return kieContainer;
    }

}
