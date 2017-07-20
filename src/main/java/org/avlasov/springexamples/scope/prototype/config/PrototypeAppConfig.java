package org.avlasov.springexamples.scope.prototype.config;

import org.avlasov.springexamples.scope.ScopeConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by artemvlasov on 20/07/2017.
 */
@Configuration
@ComponentScan({"org.avlasov.springexamples.scope.prototype"})
@Import(ScopeConfig.class)
public class PrototypeAppConfig {
}
