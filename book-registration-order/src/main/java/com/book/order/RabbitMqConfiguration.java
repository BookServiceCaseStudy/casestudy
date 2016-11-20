package com.book.order;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.book.messageBroker.BookMessage;

@Configuration
public class RabbitMqConfiguration
{
  @Value("${spring.rabbitmq.host}")
  private String rabbitMqHost;
  
  @Bean
  public ConnectionFactory connectionFactory()
  {
      CachingConnectionFactory connectionFactory = new CachingConnectionFactory(rabbitMqHost);
      connectionFactory.setUsername("guest");
      connectionFactory.setPassword("guest");
      return connectionFactory;
  }

  @Bean
  public AmqpAdmin amqpAdmin()
  {
      return new RabbitAdmin(connectionFactory());
  }


  @Bean
  public MessageConverter jsonMessageConverter()
  {
      final Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();
      converter.setClassMapper(classMapper());
      return converter;
  }

  @Bean
  public DefaultClassMapper classMapper()
  {
      DefaultClassMapper typeMapper = new DefaultClassMapper();
      typeMapper.setDefaultType(BookMessage.class);
//      Map<String, Class<?>> idClassMapping = new HashMap<String, Class<?>>();
//      idClassMapping.put("scrapingResult", UnitAmqpMessage.class);
//      typeMapper.setIdClassMapping(idClassMapping);
      return typeMapper;
  }
}
