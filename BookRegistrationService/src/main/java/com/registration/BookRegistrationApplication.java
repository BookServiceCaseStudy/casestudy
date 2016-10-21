package com.registration;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan("com.registration.service, com.registration.persistence, com.registration.entities")
@EnableJpaRepositories("com.registration.persistence.repositories")
@PropertySource("classpath:db-config.properties")
public class BookRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookRegistrationApplication.class, args);
	}
	
	@Bean
  public DataSource dataSource() {
    return (new EmbeddedDatabaseBuilder())
      .addScript("classpath:db/schema.sql")
      .addScript("classpath:db/data.sql").build();
	}
}
