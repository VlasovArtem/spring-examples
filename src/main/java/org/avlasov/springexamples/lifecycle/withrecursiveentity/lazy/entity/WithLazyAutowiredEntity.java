package org.avlasov.springexamples.lifecycle.withrecursiveentity.lazy.entity;

import org.avlasov.springexamples.lifecycle.entity.AbstractLifecycleEntity;
import org.avlasov.springexamples.lifecycle.utils.MessageUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * Created By artemvlasov on 20/08/2018
 **/
@Component
public class WithLazyAutowiredEntity extends AbstractLifecycleEntity {

    private final LazyFirstEntity lazyFirstEntity;

    public WithLazyAutowiredEntity(@Lazy LazyFirstEntity lazyFirstEntity) {
        this.lazyFirstEntity = lazyFirstEntity;
        System.out.println("You cannot use @Lazy entity in the constructor. Spring creates proxy of a lazy class and then will allow to use it, when it will successfully initialized.");
        printMessage(MessageUtils::withEntityConstructorMessage);
    }

    public LazyFirstEntity getLazyFirstEntity() {
        return lazyFirstEntity;
    }
}
