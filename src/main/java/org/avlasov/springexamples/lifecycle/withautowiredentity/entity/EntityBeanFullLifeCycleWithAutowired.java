package org.avlasov.springexamples.lifecycle.withautowiredentity.entity;

import org.avlasov.springexamples.lifecycle.entity.AbstractLifecycleEntity;
import org.avlasov.springexamples.lifecycle.utils.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created By artemvlasov on 17/08/2018
 **/
@Component
public class EntityBeanFullLifeCycleWithAutowired extends AbstractLifecycleEntity {

    private AutowiredCandidateEntity autowiredCandidateEntity;

    public EntityBeanFullLifeCycleWithAutowired() {
        super();
    }

    @Autowired
    public EntityBeanFullLifeCycleWithAutowired(AutowiredCandidateEntity autowiredCandidateEntity) {
        this.autowiredCandidateEntity = autowiredCandidateEntity;
        printMessage(MessageUtils::withEntityConstructorMessage);
    }

}
