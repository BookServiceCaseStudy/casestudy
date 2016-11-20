package com.book.order.persistence.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.book.order.entities.Order;
import com.book.order.persistence.repositories.OrderRepositories;

@Component
public class OrderDao
{
  @Autowired
  OrderRepositories orderRepositories;

  public void saveOrder(Order order)
  {
    orderRepositories.save(order);
  }

  public List<Order> getPendingOrders()
  {
    return orderRepositories.findByCompleted(false);
  }
  
  public void  updateOrder (Order order)
  {
    orderRepositories.update(order);
  }
  
}
