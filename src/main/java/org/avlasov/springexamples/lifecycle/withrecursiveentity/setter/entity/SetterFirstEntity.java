package org.avlasov.springexamples.lifecycle.withrecursiveentity.setter.entity;

import org.avlasov.springexamples.lifecycle.entity.AbstractLifecycleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created By artemvlasov on 20/08/2018
 **/
@Component
public class SetterFirstEntity extends AbstractLifecycleEntity {

    private SetterSecondEntity setterSecondEntity;

    @Autowired
    public void setSetterSecondEntity(SetterSecondEntity setterSecondEntity) {
        this.setterSecondEntity = setterSecondEntity;
        System.out.println(this.getClass().getSimpleName() + " Bean setter");
        System.out.println("With SetterSecondEntity " + setterSecondEntity);
        System.out.println("===========================");
    }

    public SetterSecondEntity getSetterSecondEntity() {
        return setterSecondEntity;
    }
}
