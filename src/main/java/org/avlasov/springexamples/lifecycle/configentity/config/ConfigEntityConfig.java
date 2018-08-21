package org.avlasov.springexamples.lifecycle.configentity.config;

import org.avlasov.springexamples.lifecycle.configentity.entity.ConfigEntityBeanFullLifeCycle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created By artemvlasov on 20/08/2018
 **/
@Configuration
@ComponentScan(basePackages = "org.avlasov.springexamples.lifecycle.postprocessor")
public class ConfigEntityConfig {

    @Bean(initMethod = "appConfigInitMethod", destroyMethod = "appConfigDestroyMethod")
    public ConfigEntityBeanFullLifeCycle configEntityBeanFullLifeCycle() {
        return new ConfigEntityBeanFullLifeCycle();
    }

}
