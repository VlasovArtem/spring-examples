package org.avlasov.springexamples.repository.sql.repository;

import org.avlasov.springexamples.repository.sql.entity.SQLEntityBean;
import org.avlasov.springexamples.repository.sql.repository.custom.SQLCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created By artemvlasov on 10/08/2017
 **/
public interface SQLRepository extends JpaRepository<SQLEntityBean, Long>, SQLCustomRepository {

    SQLEntityBean findByName(String name);
    SQLEntityBean getByName(String name);
    SQLEntityBean readByName(String name);
    SQLEntityBean queryByName(String name);
    SQLEntityBean findSomethingUnusualByName(String name);
    List<SQLEntityBean> findByNameIsLike(String name);
    List<SQLEntityBean> findByIdBetween(long min, long max);

}
