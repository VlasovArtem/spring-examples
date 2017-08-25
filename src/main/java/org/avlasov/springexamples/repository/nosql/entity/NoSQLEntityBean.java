package org.avlasov.springexamples.repository.nosql.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created By artemvlasov on 11/08/2017
 **/
@Document
public class NoSQLEntityBean {

    @Id
    private long id;
    private String name;

    public NoSQLEntityBean(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
