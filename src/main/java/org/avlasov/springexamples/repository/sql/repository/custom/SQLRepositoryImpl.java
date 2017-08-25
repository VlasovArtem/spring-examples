package org.avlasov.springexamples.repository.sql.repository.custom;

import org.avlasov.springexamples.repository.sql.entity.SQLEntityBean;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 * Created By artemvlasov on 10/08/2017
 **/
public class SQLRepositoryImpl implements SQLCustomRepository {

    private final EntityManager entityManager;

    public SQLRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public SQLEntityBean customFindByName(String name) {
        TypedQuery<SQLEntityBean> query = entityManager.createQuery("SELECT seb FROM SQLEntityBean seb where name = ?1", SQLEntityBean.class);
        if (name.contains("HELLO")) {
            query.setParameter(1, "TEST");
        } else {
            query.setParameter(1, name);
        }
        return query.getResultList().stream().findFirst().orElse(null);
    }
}
