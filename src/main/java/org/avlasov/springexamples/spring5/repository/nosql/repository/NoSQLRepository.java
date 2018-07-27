package org.avlasov.springexamples.spring5.repository.nosql.repository;

import org.avlasov.springexamples.spring5.repository.nosql.entity.NoSQLEntityBean;
import org.springframework.data.mongodb.repository.MongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created By artemvlasov on 22/07/2018
 **/
public interface NoSQLRepository extends MongoRepository<NoSQLEntityBean, Long> {

    Mono<NoSQLEntityBean> getNoSQLEntityBean(int id);
    Flux<NoSQLEntityBean> allNoSQLEntityBeans();
    Mono<Void> saveNoSQLEntityBean(Mono<NoSQLEntityBean> entityBeanMono);

}
