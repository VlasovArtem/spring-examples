package org.avlasov.springexamples.repository.sql.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created By artemvlasov on 10/08/2017
 **/
@Entity
@Table(name = "sql_entity_bean")
public class SQLEntityBean {

    @Id
    private long id;
    @Column(nullable = false)
    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
