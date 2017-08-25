package org.avlasov.springexamples.repository.nosql.repository;

import org.avlasov.springexamples.repository.nosql.entity.NoSQLEntityBean;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created By artemvlasov on 11/08/2017
 **/
public interface NoSQLRepository extends MongoRepository<NoSQLEntityBean, Long> {

    NoSQLEntityBean findByName(String name);
    NoSQLEntityBean getByName(String name);
    NoSQLEntityBean readByName(String name);
    NoSQLEntityBean queryByName(String name);
    NoSQLEntityBean findSomethingUnusualByName(String name);
    List<NoSQLEntityBean> findByNameIsLike(String name);
    List<NoSQLEntityBean> findByIdBetween(long min, long max);

}
