package com.book.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.util.json.Jackson;
import com.book.messageBroker.BookMessage;
import com.book.order.common.SequenceGenerator;
import com.book.order.entities.Order;
import com.book.order.persistence.dao.OrderDao;

@Component
public class OrderResultHandler
{
  @Autowired
  OrderDao orderDao;
  @Autowired
  SequenceGenerator sequenceGenerator;

  public void handleMessage(Object bookMesssage)
  {
    String message = Jackson.toJsonString(bookMesssage);
    orderDao.saveOrder(createNewOrder(Jackson.fromJsonString(message,BookMessage.class)));
    System.out.println("New Order Created");
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
