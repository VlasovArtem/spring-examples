package org.avlasov.springexamples.beanqualifying.primary.entity;

import org.avlasov.springexamples.beanqualifying.entity.QualifiedEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Created by artemvlasov on 22/07/2017.
 */
@Primary
@Component
public class PrimaryBean extends QualifiedEntity {
}
