package org.avlasov.springexamples.aop;

import org.avlasov.springexamples.MainSpringLoggerTestCase;
import org.avlasov.springexamples.aop.component.ExampleAspect;
import org.avlasov.springexamples.aop.config.AOPConfig;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created By artemvlasov on 23/08/2018
 **/
@ContextConfiguration(classes = AOPConfig.class)
public abstract class AOPTestCase extends MainSpringLoggerTestCase {

    @Override
    protected Class getLoggerClass() {
        return ExampleAspect.class;
    }

}
