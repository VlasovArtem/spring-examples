package org.avlasov.springexamples.repository.nosql.repository;

import org.avlasov.springexamples.repository.nosql.config.EmbeddedMongoDatabaseConfig;
import org.avlasov.springexamples.repository.nosql.config.NoSQLRepositoryConfig;
import org.avlasov.springexamples.repository.nosql.entity.NoSQLEntityBean;
import org.hamcrest.collection.IsCollectionWithSize;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created By artemvlasov on 11/08/2017
 **/
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {NoSQLRepositoryConfig.class, EmbeddedMongoDatabaseConfig.class})
@DataMongoTest
public class NoSQLRepositoryTest {

    @Autowired
    private NoSQLRepository noSQLRepository;

    @Before
    public void setUp() throws Exception {
        noSQLRepository.save(new NoSQLEntityBean(1, "test"));
    }

    @After
    public void tearDown() throws Exception {
        noSQLRepository.deleteAll();
    }

    @Test
    public void findByName() {
        NoSQLEntityBean test = noSQLRepository.findByName("test");
        assertEquals(test.getId(), 1);
    }

    @Test
    public void getByName() {
        NoSQLEntityBean test = noSQLRepository.getByName("test");
        assertEquals(test.getId(), 1);
    }

    @Test
    public void readByName() {
        NoSQLEntityBean test = noSQLRepository.readByName("test");
        assertEquals(test.getId(), 1);
    }

    @Test
    public void queryByName() {
        NoSQLEntityBean test = noSQLRepository.queryByName("test");
        assertEquals(test.getId(), 1);
    }

    @Test
    public void findSomethingUnusualByName() {
        NoSQLEntityBean test = noSQLRepository.findSomethingUnusualByName("test");
        assertEquals(test.getId(), 1);
    }

    @Test
    public void findByNameIsLike() {
        List<NoSQLEntityBean> byNameIsLike = noSQLRepository.findByNameIsLike("%sst");
        assertThat(byNameIsLike, IsEmptyCollection.empty());
    }

    @Test
    public void findByIdBetween() {
        noSQLRepository.save(new NoSQLEntityBean(2, "hello"));
        noSQLRepository.save(new NoSQLEntityBean(3, "bye"));
        List<NoSQLEntityBean> byIdBetween = noSQLRepository.findByIdBetween(1, 3);
        assertThat(byIdBetween, IsCollectionWithSize.hasSize(1));
        assertEquals(byIdBetween.get(0).getName(), "hello");
    }

    @Test
    public void countByName() {
        noSQLRepository.save(new NoSQLEntityBean(2, "hello"));
        noSQLRepository.save(new NoSQLEntityBean(3, "bye"));
        noSQLRepository.save(new NoSQLEntityBean(4, "test"));
        assertEquals(2, noSQLRepository.countByName("test"));
        assertEquals(1, noSQLRepository.countByName("hello"));
    }
}