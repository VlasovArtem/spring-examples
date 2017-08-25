package org.avlasov.springexamples.repository.sql.repository;

import org.avlasov.springexamples.repository.sql.config.SQLRepositoryConfig;
import org.avlasov.springexamples.repository.sql.entity.SQLEntityBean;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.avlasov.springexamples.repository.sql.repository.SQLRepositoryTest.SQLEntityBeanMatcher.newMatcher;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.*;

/**
 * Created By artemvlasov on 10/08/2017
 **/
@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = SQLRepositoryConfig.class)
@SqlGroup(value = {
        @Sql("/org/avlasov/springexamples/repository/sql/drop-data.sql"),
        @Sql("/org/avlasov/springexamples/repository/sql/data.sql")
})
@AutoConfigureTestDatabase
public class SQLRepositoryTest {

    @Autowired
    private SQLRepository sqlRepository;

    @Test
    public void findByName() throws Exception {
        validateEntity(sqlRepository.findByName("I am third"), 3);
    }

    @Test
    public void getByName() throws Exception {
        validateEntity(sqlRepository.getByName("Hello"), 1);
    }

    @Test
    public void readByName() throws Exception {
        validateEntity(sqlRepository.readByName("do i know you?"), 4);
    }

    @Test
    public void queryByName() throws Exception {
        validateEntity(sqlRepository.queryByName("Bello"), 5);
    }

    @Test
    public void findSomethingUnusualByName() throws Exception {
        validateEntity(sqlRepository.findSomethingUnusualByName("TEST"), 2);
    }

    @Test
    public void findByNameIsLike() throws Exception {
        List<SQLEntityBean> sqlEntityBeans = sqlRepository.findByNameIsLike("%ello");
        assertThat(sqlEntityBeans, hasSize(2));
        assertThat(sqlEntityBeans, hasItem(newMatcher(1, "Hello")));
    }

    @Test
    public void findByIdBetween() throws Exception {
        List<SQLEntityBean> sqlEntityBeans = sqlRepository.findByIdBetween(1, 4);
        assertThat(sqlEntityBeans, hasSize(4));
        assertThat(sqlEntityBeans, hasItem(newMatcher(3, "I am third")));
    }

    @Test
    public void customFindByName() throws Exception {
        SQLEntityBean sqlEntityBean = sqlRepository.customFindByName("HELLO");
        validateEntity(sqlEntityBean, 2);
        assertEquals(sqlEntityBean.getName(), "TEST");
    }

    private void validateEntity(SQLEntityBean sqlEntityBean, int id) {
        assertNotNull(sqlEntityBean);
        assertEquals(sqlEntityBean.getId(), id);
    }

    public static class SQLEntityBeanMatcher extends BaseMatcher<SQLEntityBean> {

        private int id;
        private String name;

        public static SQLEntityBeanMatcher newMatcher(int id, String name) {
            return new SQLEntityBeanMatcher(id, name);
        }

        private SQLEntityBeanMatcher(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean matches(Object item) {
            SQLEntityBean bean = (SQLEntityBean) item;
            return bean.getName().equals(name) && bean.getId() == id;
        }

        @Override
        public void describeTo(Description description) {}
    }

}