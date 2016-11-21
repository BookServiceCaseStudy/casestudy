package com.book.order;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.book.messageBroker.BookMessage;
import com.book.order.common.SequenceGenerator;
import com.book.order.entities.Order;
import com.book.order.persistence.dao.OrderDao;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class OrderResultHandler
{
  @Autowired
  OrderDao orderDao;
  @Autowired
  SequenceGenerator sequenceGenerator;

  public void handleMessage(Object bookMesssage) 
  {
    try 
    {
    ObjectMapper mapper = new ObjectMapper();
    String message = mapper.writeValueAsString(bookMesssage);
    orderDao.saveOrder(createNewOrder(mapper.readValue(message, BookMessage.class)));
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }

  private Order createNewOrder(BookMessage bookMessage)
  {
    Order order = new Order();
    order.setId(sequenceGenerator.getNextSequence("BookOrder"));
    order.setAuthor(bookMessage.getAuthor());
    order.setBookName(bookMessage.getBookName());
    order.setClientId(bookMessage.getAuthor());
    order.setAuthor(bookMessage.getAuthor());
    order.setExternaBookXref(bookMessage.getExternalBookRefId());
    order.setNumberOfBooksRequired(bookMessage.getNoOfBookNeeded());
    order.setCompleted(false);
    return order;
  }
}
