package com.aannya.cricplexheros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.aannya.cricplexheros.dto.FileStorageProperties;

@SpringBootApplication
//@EnableJpaRepositories
//@EnableTransactionManagement
@EnableConfigurationProperties({
    FileStorageProperties.class
})
//@EnableJpaAuditing
public class CricplexherosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CricplexherosApplication.class, args);
	}

}
