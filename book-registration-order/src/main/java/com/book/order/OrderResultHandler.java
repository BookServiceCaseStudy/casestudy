package com.book.order;

import org.springframework.stereotype.Component;

import com.book.messageBroker.BookMessage;

@Component
public class OrderResultHandler
{

  public void handleMessage(BookMessage bookMesssage)
  {
    System.out.println("Message Recieved"); 
    System.out.println(bookMesssage.getMessage());
    System.out.println("Number of Books Required" + bookMesssage.getMessage());
    System.out.println("Number of Books Left" + bookMesssage.getNoOfBookLeft());
  }
}
