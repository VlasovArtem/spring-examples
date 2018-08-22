package org.avlasov.springexamples.repository.nosql.config;

import com.mongodb.MongoClient;
import de.flapdoodle.embed.mongo.Command;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.config.RuntimeConfigBuilder;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.config.IRuntimeConfig;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.IOException;

/**
 * Created By artemvlasov on 25/12/2017
 **/
@TestConfiguration
public class EmbeddedMongoDatabaseConfig {

    private final String LOCALHOST = "127.0.0.1";
    private final String DB_NAME = "itest";
    private final int MONGO_TEST_PORT = 27028;

    @Bean(destroyMethod = "stop")
    public MongodProcess mongodProcess() throws IOException {
        RuntimeConfigBuilder runtimeConfigBuilder = new RuntimeConfigBuilder();
        IRuntimeConfig build = runtimeConfigBuilder.defaults(Command.MongoD).build();
        MongodStarter starter = MongodStarter.getInstance(build);
        IMongodConfig mongodConfig = new MongodConfigBuilder()
                .version(Version.V3_5_1)
                .net(new Net(LOCALHOST, MONGO_TEST_PORT, false))
                .build();
        MongodExecutable mongodExecutable = starter.prepare(mongodConfig);
        return mongodExecutable.start();
    }

    @Bean(destroyMethod = "close")
    public MongoClient mongoClient() {
        MongoClient mongoClient = new MongoClient(LOCALHOST, MONGO_TEST_PORT);
        mongoClient.getDatabase(DB_NAME);
        return mongoClient;
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoClient mongoClient) {
        return new MongoTemplate(mongoClient, DB_NAME);
    }


}
