package org.avlasov.springexamples.lifecycle.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by artemvlasov on 16/07/2017.
 */
@ComponentScan("org.avlasov.springexamples.lifecycle")
@Configuration
@PropertySource("classpath:org.avlasov.springexamples.lifecycle")
public class LifecycleAppConfig {

}
