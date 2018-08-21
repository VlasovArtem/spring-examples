package org.avlasov.springexamples.lifecycle.withrecursiveentity.lazy.entity;

import org.avlasov.springexamples.lifecycle.entity.AbstractLifecycleEntity;
import org.avlasov.springexamples.lifecycle.utils.MessageUtils;
import org.springframework.stereotype.Component;

/**
 * Created By artemvlasov on 20/08/2018
 **/
@Component
public class LazyFirstEntity extends AbstractLifecycleEntity {

    private final WithLazyAutowiredEntity withLazyAutowiredEntity;

    public LazyFirstEntity(WithLazyAutowiredEntity withLazyAutowiredEntity) {
        this.withLazyAutowiredEntity = withLazyAutowiredEntity;
        printMessage(MessageUtils::withEntityConstructorMessage);
    }

}
