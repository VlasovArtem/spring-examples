package org.avlasov.springexamples.conditionbean.conditional;

import org.avlasov.springexamples.conditionbean.annotation.TestConditionalAnnotation;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * Created By artemvlasov on 22/07/2017
 **/
public class MetaDataConditionalExample implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> testConditionalAnnotation = metadata.getAnnotationAttributes(TestConditionalAnnotation.class.getName());
        return Boolean.valueOf(testConditionalAnnotation.get("show").toString());
    }

}
