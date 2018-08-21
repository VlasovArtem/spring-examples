package org.avlasov.springexamples.lifecycle.withrecursiveentity.postconstruct.entity;

import org.avlasov.springexamples.lifecycle.entity.AbstractLifecycleEntity;
import org.springframework.stereotype.Component;

/**
 * Created By artemvlasov on 20/08/2018
 **/
@Component
public class WithPostConstructAutowiredEntity extends AbstractLifecycleEntity {

    private PostConstructFirstEntity postConstructFirstEntity;

    public void setWithSetterAutowiredEntity(PostConstructFirstEntity setterAutowiredEntity) {
        this.postConstructFirstEntity = setterAutowiredEntity;
        System.out.println(this.getClass().getSimpleName() + " Bean setter");
        System.out.println("With PostConstructFirstEntity " + setterAutowiredEntity);
        System.out.println("===========================");
    }

    public PostConstructFirstEntity getPostConstructFirstEntity() {
        return postConstructFirstEntity;
    }
}
