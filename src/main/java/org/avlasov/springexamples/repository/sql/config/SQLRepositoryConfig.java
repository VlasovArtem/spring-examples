package org.avlasov.springexamples.repository.sql.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * Created By artemvlasov on 10/08/2017
 **/
@Configuration
@ComponentScan(basePackages = "org.avlasov.springexamples.repository.sql")
@EnableJpaRepositories(basePackages = "org.avlasov.springexamples.repository.sql.repository")
public class SQLRepositoryConfig {

    @Bean(destroyMethod = "shutdown")
    public EmbeddedDatabase dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .build();
    }

//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
//        factoryBean.setDataSource(dataSource());
//        factoryBean.setPackagesToScan("org.avlasov.springexamples.repository.sql.entity");
//        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//        return factoryBean;
//    }

}
