package org.avlasov.springexamples.conditionbean.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created By artemvlasov on 22/07/2017
 **/
public class EnvironmentConditionalExample implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return Boolean.valueOf(context.getEnvironment().getProperty("show.environment.bean", "true"));
    }
}
