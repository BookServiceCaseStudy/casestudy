package com.registration.message.broker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.util.json.Jackson;
import com.book.messageBroker.OrderMessage;
import com.registration.entities.Book;
import com.registration.persistence.dao.BookRegistrationDao;

@Component
public class OrderResultHandler
{
  @Autowired
  BookRegistrationDao bookRegDao;

  public void handleMessage(Object queueMessage)
  {
    String message = Jackson.toJsonString(queueMessage);
    OrderMessage orderMessage = Jackson.fromJsonString(message, OrderMessage.class);
    if (orderMessage.getBookXref() != null)
    {
      Book book = bookRegDao.findBookById(Long.valueOf(orderMessage.getBookXref()));
      book.setQuantity(orderMessage.getNumbersOfBookAdded());
      bookRegDao.update(book);
    }
    System.out.println("New Order Created");
  }

}
