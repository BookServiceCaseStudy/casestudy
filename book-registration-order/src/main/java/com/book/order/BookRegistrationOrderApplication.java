package com.book.order;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;

@SpringBootApplication
@EnableDiscoveryClient
@EnableMongoRepositories("com.book.order.persistence.repositories")
public class BookRegistrationOrderApplication
{

  @Value("${spring.data.mongodb.host}")
  private String host;
  @Value("${spring.data.mongodb.port}")
  private int port;
  @Value("${spring.data.mongodb.database}")
  private String database;

  public static void main(String[] args)
  {
    SpringApplication.run(BookRegistrationOrderApplication.class, args);
  }

  @Bean
  public MongoDbFactory mongoDbFactory()
  {
    MongoClient mongo = new MongoClient(host, port);
    SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongo, database);
    return simpleMongoDbFactory;
  }

  @Bean
  public MongoTemplate mongoTemplate()
  {
    MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
    mongoTemplate.setWriteConcern(WriteConcern.SAFE);
    return mongoTemplate;
  }
}
