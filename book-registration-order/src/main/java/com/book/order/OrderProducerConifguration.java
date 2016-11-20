package com.book.order;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderProducerConifguration extends RabbitMqConfiguration
{
  protected final String orderQueue = "orderCompletion.queue";

  @Bean
  public RabbitTemplate rabbitTemplate()
  {
      RabbitTemplate template = new RabbitTemplate(connectionFactory());
      template.setRoutingKey(this.orderQueue);
      template.setQueue(this.orderQueue);
      template.setMessageConverter(jsonMessageConverter());
      return template;
  }

  @Bean
  public Queue tasksQueue()
  {
      return new Queue(this.orderQueue);
  }
}
