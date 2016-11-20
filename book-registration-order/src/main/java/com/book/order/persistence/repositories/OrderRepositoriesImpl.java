package com.book.order.persistence.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.book.order.entities.Order;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public class OrderRepositoriesImpl implements OrderRepositoriesCustom
{
  @Autowired
  private MongoTemplate mongoTemplate;

  @Override
  public void update(Order order)
  {
    DBCollection coll = mongoTemplate.getCollection("BookOrder");
    DBObject query = new BasicDBObject("_id", order.getId());
    DBObject update = new BasicDBObject();
    update.put("$set", new BasicDBObject("completed", true));
    DBObject wr = coll.findAndModify(query, update);
  }
}
