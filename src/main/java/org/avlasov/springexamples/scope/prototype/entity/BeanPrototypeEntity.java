package org.avlasov.springexamples.scope.prototype.entity;

import org.avlasov.springexamples.scope.entity.ComponentEntityBean;
import org.avlasov.springexamples.scope.entity.MainEntityBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by artemvlasov on 28/06/2017.
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BeanPrototypeEntity extends MainEntityBean {

    private final ComponentEntityBean componentEntityBean;

    @Autowired
    public BeanPrototypeEntity(ComponentEntityBean componentEntityBean) {
        this.componentEntityBean = componentEntityBean;
    }

    @PostConstruct
    public void init() {
        System.out.println("EntityBeanPrototypeFullCycle init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("EntityBeanPrototypeFullCycle destroy");
    }

}
