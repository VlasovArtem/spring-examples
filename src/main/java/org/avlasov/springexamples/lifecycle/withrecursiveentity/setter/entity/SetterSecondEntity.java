package org.avlasov.springexamples.lifecycle.withrecursiveentity.setter.entity;

import org.avlasov.springexamples.lifecycle.entity.AbstractLifecycleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created By artemvlasov on 20/08/2018
 **/
@Component
public class SetterSecondEntity extends AbstractLifecycleEntity {

    private SetterFirstEntity setterFirstEntity;

    @Autowired
    public void setWithSetterAutowiredEntity(SetterFirstEntity setterAutowiredEntity) {
        this.setterFirstEntity = setterAutowiredEntity;
        System.out.println(this.getClass().getSimpleName() + " Bean setter");
        System.out.println("With SetterFirstEntity " + setterAutowiredEntity);
        System.out.println("===========================");
    }

    public SetterFirstEntity getSetterFirstEntity() {
        return setterFirstEntity;
    }
}
