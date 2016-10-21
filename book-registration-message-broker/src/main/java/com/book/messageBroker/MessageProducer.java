package com.book.messageBroker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer
{
  
  @Autowired
  private NotifyProducerConifguration notifyProducerConifguration;
  
  public void notifyBookAboutToEnd(BookMessage taskMessage)
  {
    notifyProducerConifguration.rabbitTemplate().convertAndSend(notifyProducerConifguration.tasksQueue, taskMessage);
  }
  
}
