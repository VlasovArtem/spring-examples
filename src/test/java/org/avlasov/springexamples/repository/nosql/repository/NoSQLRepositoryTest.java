package org.avlasov.springexamples.repository.nosql.repository;

import org.avlasov.springexamples.repository.nosql.config.NoSQLRepositoryConfig;
import org.avlasov.springexamples.repository.nosql.entity.NoSQLEntityBean;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Created By artemvlasov on 11/08/2017
 **/
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = NoSQLRepositoryConfig.class)
@DataMongoTest
public class NoSQLRepositoryTest {

    @Autowired
    private NoSQLRepository noSQLRepository;

    @Before
    public void setUp() throws Exception {
        noSQLRepository.save(new NoSQLEntityBean(1, "Test"));
    }

    @After
    public void tearDown() throws Exception {
        noSQLRepository.deleteAll();
    }

    @Test
    public void findByName() throws Exception {
        NoSQLEntityBean test = noSQLRepository.findByName("Test");
        assertNotNull(test);
    }

    @Test
    public void getByName() throws Exception {
    }

    @Test
    public void readByName() throws Exception {
    }

    @Test
    public void queryByName() throws Exception {
    }

    @Test
    public void findSomethingUnusualByName() throws Exception {
    }

    @Test
    public void findByNameIsLike() throws Exception {
    }

    @Test
    public void findByIdBetween() throws Exception {
    }

}