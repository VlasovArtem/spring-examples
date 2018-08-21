package org.avlasov.springexamples.controller.config;

import org.avlasov.springexamples.controller.handler.ControllerExceptionHandlerResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;

/**
 * Created By artemvlasov on 22/07/2018
 **/
@Configuration
@ComponentScan("org.avlasov.springexamples.controller")
public class ControllerConfig {

    @Bean
    public HandlerExceptionResolver customHandlerExceptionResolver() {
        return new ControllerExceptionHandlerResolver();
    }

}
