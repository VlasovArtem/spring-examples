package org.avlasov.springexamples.repository.nosql.repository.custom.impl;

import org.avlasov.springexamples.repository.nosql.entity.NoSQLEntityBean;
import org.avlasov.springexamples.repository.nosql.repository.custom.NoSQLCustomRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * Created By artemvlasov on 22/08/2018
 **/
@Repository
public class NoSQLCustomRepositoryImpl implements NoSQLCustomRepository {

    private final MongoTemplate mongoTemplate;

    public NoSQLCustomRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public long countByName(String name) {
        return mongoTemplate.count(Query.query(Criteria.where("name").is(name)), NoSQLEntityBean.class);
    }

}
