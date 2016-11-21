package com.registration.message.broker;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.book.messageBroker.OrderMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.registration.entities.Book;
import com.registration.persistence.dao.BookRegistrationDao;

@Component
public class OrderResultHandler
{
  @Autowired
  BookRegistrationDao bookRegDao;

  public void handleMessage(Object queueMessage)
  {
    try
    {
      ObjectMapper mapper = new ObjectMapper();
      String message = mapper.writeValueAsString(queueMessage);
      OrderMessage orderMessage = mapper.readValue(message, OrderMessage.class);
      if (orderMessage.getBookXref() != null)
      {
        Book book = bookRegDao.findBookById(Long.valueOf(orderMessage.getBookXref()));
        book.setQuantity(orderMessage.getNumbersOfBookAdded());
        bookRegDao.update(book);
      }
    }
    catch (IOException e)
    {
      throw new RuntimeException();
    }
  }

}
