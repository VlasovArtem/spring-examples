package org.avlasov.springexamples.conditionbean.entity;

import org.avlasov.springexamples.conditionbean.annotation.TestConditionalAnnotation;
import org.avlasov.springexamples.conditionbean.conditional.MetaDataConditionalExample;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

/**
 * Created By artemvlasov on 22/07/2017
 **/
@Conditional(MetaDataConditionalExample.class)
@TestConditionalAnnotation
@Component
public class ComponentConditionalEntity {
}

