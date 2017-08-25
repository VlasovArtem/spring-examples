package org.avlasov.springexamples.repository.sql.repository.custom;

import org.avlasov.springexamples.repository.sql.entity.SQLEntityBean;

/**
 * Created By artemvlasov on 10/08/2017
 **/
public interface SQLCustomRepository {

    SQLEntityBean customFindByName(String name);

}
