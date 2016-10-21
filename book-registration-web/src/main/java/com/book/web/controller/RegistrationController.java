package com.book.web.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.book.web.pojo.Book;
import com.book.web.pojo.BookMessage;

@RestController
public class RegistrationController
{
  @Autowired
  RestTemplate restTemplate;

  @RequestMapping("/register")
  @POST
  @Consumes("appliation/json")
  @Produces("appliation/json")
  public String register(Book book)
  {
    return restTemplate
      .getForObject("http://BOOK-REGISTRATION-SERVICE/books/register/Alchemist", Book.class)
      .toString();
  }

  @RequestMapping("/find/{name}")
  @Produces("appliation/json")
  public List<Book> find(@PathVariable("name") String name)
  {
   return restTemplate
      .getForObject("http://BOOK-REGISTRATION-SERVICE/books/register/Alchemist", List.class);
  }

  @RequestMapping("/purchase")
  @Produces("appliation/json")
  @Consumes("application/json")
  @POST
  public List<Book> purchase(@RequestBody Book book)
  {
    List<Book> books = restTemplate.postForObject("http://BOOK-REGISTRATION-SERVICE/books/purchase",
      book, List.class);
    if (book.getQuantity() < 1)
    {
      BookMessage message = new BookMessage();
      message.setMessage("Order for more books");
      message.setNewOrder(true);
      message.setNoOfBookLeft(book.getQuantity());
      message.setBookName(book.getName());
      message.setNoOfBookNeeded(10);
      String response = restTemplate.postForObject(
        "http://Book-Registration-Message-Broker/books/notify", message, String.class);
    }
    return books;
  }

}
