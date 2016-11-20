package com.order.web.controller;

import java.awt.print.Book;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.order.web.pojo.Order;

@RestController
public class OrderController
{
  @Autowired
  RestTemplate restTemplate;

  @RequestMapping("/completed")
  @POST
  @Consumes("appliation/json")
  @Produces("appliation/json")
  public List<Order> orderCompleted(@RequestBody Order order)
  {
    restTemplate
      .postForObject("http://book-order/order/completed", order, String.class)
      .toString();
    return restTemplate
      .getForObject("http://book-order/order/pending/", List.class);
  }

  @GET
  @RequestMapping("/pending")
  @Produces("appliation/json")
  public List<Order> find()
  {
   return restTemplate
      .getForObject("http://book-order/order/pending/", List.class);
  }


}
