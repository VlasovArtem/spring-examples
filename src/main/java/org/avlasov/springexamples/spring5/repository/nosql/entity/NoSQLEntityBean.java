package org.avlasov.springexamples.spring5.repository.nosql.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created By artemvlasov on 22/07/2018
 **/
@Document
public class NoSQLEntityBean {

    @Id
    private int id;
    private String name;

    public NoSQLEntityBean(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
