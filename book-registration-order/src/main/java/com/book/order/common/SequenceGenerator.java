package com.book.order.common;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.book.order.entities.Counters;

@Service
public class SequenceGenerator
{
    @Autowired 
    private MongoOperations mongo;

    public int getNextSequence(String collectionName) {
      Counters counter = mongo.findAndModify(
        query(where("_id").is(collectionName)), 
        new Update().inc("seq", 1),
        options().returnNew(true),
        Counters.class);

      return counter.getSeq();
    }
}
