package com.book.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.book.messageBroker.OrderMessage;

@Component
public class MessageProducer
{

  @Autowired
  private OrderProducerConifguration orderProducerConfiguration;

  public void notifyOrderCompleted(OrderMessage message)
  {
    orderProducerConfiguration.rabbitTemplate()
      .convertAndSend(orderProducerConfiguration.orderQueue, message);
  }
}
