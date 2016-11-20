package com.book.order.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.messageBroker.OrderMessage;
import com.book.order.MessageProducer;
import com.book.order.entities.Order;
import com.book.order.persistence.dao.OrderDao;

@RestController
public class OrderService
{
  @Autowired
  private OrderDao orderDao;

  @Autowired
  MessageProducer messageProducer;

  @GET
  @Produces("application/json")
  @RequestMapping("/order/pending")
  public ResponseEntity<List<Order>> findPendingOrders()
  {
    return new ResponseEntity(orderDao.getPendingOrders(), HttpStatus.OK);
  }

  @POST
  @Consumes("application/json")
  @Produces("application/json")
  @RequestMapping("/order/completed")
  public ResponseEntity<String> ordersCompleted(@RequestBody Order order)
  {
    order.setCompleted(true);
    orderDao.updateOrder(order);
    OrderMessage message = new OrderMessage(order.getExternaBookXref(), order.getClientId(),
      order.getNumberOfBooksRequired());
    messageProducer.notifyOrderCompleted(message);
    return new ResponseEntity("Book Registered", HttpStatus.OK);
  }

}
