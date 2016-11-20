package com.book.order.persistence.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.book.order.entities.Order;

@Repository
public interface OrderRepositories extends MongoRepository<Order, Long>, OrderRepositoriesCustom
{
  public List<Order> findByCompleted(boolean value);

  public List<Order> findByCompletedAndClientId(boolean value, String clientId);
}
