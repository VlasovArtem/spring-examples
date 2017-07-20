package org.avlasov.springexamples.scope;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by artemvlasov on 20/07/2017.
 */
@Configuration
@ComponentScan({"org.avlasov.springexamples.scope.entity", "org.avlasov.springexamples.utils"})
public class ScopeConfig {
}
