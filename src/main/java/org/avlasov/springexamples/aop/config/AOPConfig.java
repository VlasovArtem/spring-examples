package org.avlasov.springexamples.aop.config;

import org.avlasov.springexamples.aop.example.generic.Sample;
import org.avlasov.springexamples.aop.example.generic.impl.SampleImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created By artemvlasov on 23/08/2018
 **/
@Configuration
@ComponentScan("org.avlasov.springexamples.aop")
@EnableAspectJAutoProxy
public class AOPConfig {

    @Bean
    public Sample<Double> doubleSample() {
        return new SampleImpl<>();
    }

    @Bean
    public Sample<String> stringSample() {
        return new SampleImpl<>();
    }

}
