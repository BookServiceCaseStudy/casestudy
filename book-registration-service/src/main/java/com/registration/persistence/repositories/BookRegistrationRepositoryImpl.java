package com.registration.persistence.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.registration.entities.Book;

public class BookRegistrationRepositoryImpl implements BookRegistrationRepositoryCustom
{
  @Autowired
  private MongoTemplate mongoTemplate;

  @Override
  public void updateBook(Book book)
  {
    DBCollection coll = mongoTemplate.getCollection("Book");
    DBObject query = new BasicDBObject("_id", book.getId());
    DBObject update = new BasicDBObject();
    update.put("$set", new BasicDBObject("quantity", book.getQuantity()));
    DBObject wr = coll.findAndModify(query, update);
    System.out.print(wr);
  }

}
