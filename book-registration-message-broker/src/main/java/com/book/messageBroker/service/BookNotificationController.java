package com.book.messageBroker.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.messageBroker.BookMessage;
import com.book.messageBroker.MessageProducer;

@RestController
public class BookNotificationController
{
  @Autowired
  MessageProducer messageProducer;

  @RequestMapping("/books/notify")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  @POST
  public ResponseEntity<String> notify(@RequestBody BookMessage bookMessage)
  {
    messageProducer.notifyBookAboutToEnd(bookMessage);
    return new ResponseEntity<>("Message Sent", HttpStatus.OK);
  }
}
