package org.avlasov.springexamples.controller.config;

import org.avlasov.springexamples.controller.handler.ControllerExceptionHandlerResolver;
import org.avlasov.springexamples.controller.handler.ControllerHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created By artemvlasov on 22/07/2018
 **/
@Configuration
@ComponentScan("org.avlasov.springexamples.controller")
public class ControllerConfig implements WebMvcConfigurer {

    @Bean
    public HandlerExceptionResolver customHandlerExceptionResolver() {
        return new ControllerExceptionHandlerResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ControllerHandlerInterceptor());
    }
}
