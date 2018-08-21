package org.avlasov.springexamples.lifecycle.withrecursiveentity.postconstruct.entity;

import org.avlasov.springexamples.lifecycle.entity.AbstractLifecycleEntity;
import org.avlasov.springexamples.lifecycle.utils.MessageUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created By artemvlasov on 20/08/2018
 **/
@Component
public class PostConstructFirstEntity extends AbstractLifecycleEntity {

    private final WithPostConstructAutowiredEntity withPostConstructAutowiredEntity;

    public PostConstructFirstEntity(WithPostConstructAutowiredEntity withPostConstructAutowiredEntity) {
        this.withPostConstructAutowiredEntity = withPostConstructAutowiredEntity;
        printMessage(MessageUtils::withEntityConstructorMessage);
    }

    @PostConstruct
    public void annotationPostConstructMethod() {
        this.withPostConstructAutowiredEntity.setWithSetterAutowiredEntity(this);
        System.out.println("Set this entity (" + this.getClass().getSimpleName() + ") into the entity withPostConstructAutowiredEntity (" + WithPostConstructAutowiredEntity.class.getSimpleName() + ")");
        printMessage(MessageUtils::annotationPostConstructMethodMessage);
    }

}
