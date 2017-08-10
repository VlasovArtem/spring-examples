package org.avlasov.springexamples.value.properties.entity;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created By artemvlasov on 27/07/2017
 **/
public class ValuePropertyEntity {

    @Value("${field}")
    private String fieldProperty;
    @Value("${unknown:default_value}")
    private String defaultProperty;
    private String configProperty;

    public ValuePropertyEntity(String configProperty) {
        this.configProperty = configProperty;
    }

    public String getFieldProperty() {
        return fieldProperty;
    }

    public String getDefaultProperty() {
        return defaultProperty;
    }

    public String getConfigProperty() {
        return configProperty;
    }
}
