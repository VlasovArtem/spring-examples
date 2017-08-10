package org.avlasov.springexamples.scope.prototype.entity;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created By artemvlasov on 04/08/2017
 **/
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SimpleBeanPrototypeEntity {

    private int initValue;

    public SimpleBeanPrototypeEntity() {
        this.initValue = 5;
    }

    public int getInitValue() {
        return initValue;
    }

    public void setInitValue(int initValue) {
        this.initValue = initValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleBeanPrototypeEntity)) return false;

        SimpleBeanPrototypeEntity that = (SimpleBeanPrototypeEntity) o;

        return initValue == that.initValue;
    }

    @Override
    public int hashCode() {
        return initValue;
    }
}
