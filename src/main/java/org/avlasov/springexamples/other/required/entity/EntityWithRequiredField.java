package org.avlasov.springexamples.other.required.entity;

import org.springframework.beans.factory.annotation.Required;

/**
 * Created By artemvlasov on 22/08/2018
 **/
public class EntityWithRequiredField {

    private String name;

    @Required
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
