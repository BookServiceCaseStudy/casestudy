package com.book.messageBroker;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotifyProducerConifguration extends MessageBrokerConfiguration
{
  protected final String tasksQueue = "newOrder.queue";

  @Bean
  public RabbitTemplate rabbitTemplate()
  {
      RabbitTemplate template = new RabbitTemplate(connectionFactory());
      template.setRoutingKey(this.tasksQueue);
      template.setQueue(this.tasksQueue);
      template.setMessageConverter(jsonMessageConverter());
      return template;
  }

  @Bean
  public Queue tasksQueue()
  {
      return new Queue(this.tasksQueue);
  }
}
