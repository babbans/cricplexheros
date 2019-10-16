package com.aannya.cricplexheros.scorecard.config;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "scorecardEntityManagerFactory",
        transactionManagerRef = "scorecardTransactionManager",
        basePackages = {"com.aannya.cricplexheros.scorecard.repository"}
)
public class ScorecardConfig {
	//@Primary
    @Bean(name = "scorecardDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource scorecardDataSource() {
        return DataSourceBuilder.create().build();
    }

    //@Primary
    @Bean(name = "scorecardEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("scorecardDataSource") DataSource dataSource
    ) {
    	HashMap<String, Object> properties = new HashMap<>();
    	properties.put("hibernate.hbm2ddl.auto","update");
        properties.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
        properties.put("hibernate.connection.CharSet", "utf8");
        properties.put("hibernate.connection.characterEncoding", "utf8");
        properties.put("hibernate.connection.useUnicode", true);
      
        return builder
                .dataSource(dataSource)
                .packages("com.aannya.cricplexheros.scorecard.model")
                .persistenceUnit("cricplex_cricscore")
                .properties(properties)
                .build();
    }

    //@Primary
    @Bean(name = "scorecardTransactionManager")
    public PlatformTransactionManager scorecardTransactionManager(
            @Qualifier("scorecardEntityManagerFactory") EntityManagerFactory
            scorecardEntityManagerFactory
    ) {
        return new JpaTransactionManager(scorecardEntityManagerFactory);
    }

}
