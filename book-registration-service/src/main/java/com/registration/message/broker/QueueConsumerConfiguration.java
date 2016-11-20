package com.registration.message.broker;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.core.Queue;

@Configuration
public class QueueConsumerConfiguration extends RabbitMqConfiguration
{
  protected static final String orderQueue = "orderCompletion.queue";

  @Autowired
  private OrderResultHandler orderResultHandler;

@Bean
public RabbitTemplate rabbitTemplate() {
  RabbitTemplate template = new RabbitTemplate(connectionFactory());
  template.setRoutingKey(QueueConsumerConfiguration.orderQueue);
  template.setQueue(QueueConsumerConfiguration.orderQueue);
      template.setMessageConverter(jsonMessageConverter());
  return template;
}

@Bean
public Queue orderQueue() {
  return new Queue(QueueConsumerConfiguration.orderQueue);
}

@Bean
public SimpleMessageListenerContainer listenerContainer() {
  SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
  container.setConnectionFactory(connectionFactory());
  container.setQueueNames(QueueConsumerConfiguration.orderQueue);
  container.setMessageListener(messageListenerAdapter());

  return container;
}

  @Bean
  public MessageListenerAdapter messageListenerAdapter() {
      return new MessageListenerAdapter(orderResultHandler, jsonMessageConverter());
  }
}
