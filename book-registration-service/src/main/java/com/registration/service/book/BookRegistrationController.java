package com.registration.service.book;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.registration.entities.Book;
import com.registration.persistence.dao.BookRegistrationDao;

@RestController
public class BookRegistrationController
{
  @Autowired
  BookRegistrationDao bookRegistrationDao;

  private static final Logger LOG = Logger.getLogger(BookRegistrationController.class);

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  @RequestMapping("/books/register")
  public ResponseEntity<String> create(Book book)
  {
    try
    {
      bookRegistrationDao.save(book);
      return new ResponseEntity("Book Registered", HttpStatus.OK);
    }
    catch (Exception e)
    {
      LOG.debug("Error while regestring n Customer");
      return new ResponseEntity(
        "Error while creating Customer!!, Pease contact your administrator!!",
        HttpStatus.NOT_FOUND);
    }
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  @RequestMapping("/books/purchase")
  public ResponseEntity<List<Book>> purchase(@RequestBody Book book)
  {
    try
    {
      bookRegistrationDao.save(book);
      return new ResponseEntity(bookRegistrationDao.listAllBooks(), HttpStatus.OK);
    }
    catch (Exception e)
    {
      LOG.debug("Error while regestring n Customer");
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @RequestMapping("/books/register/{name}")
  public List<Book> get(@PathVariable("name") String name)
  {
    return Lists.newArrayList(bookRegistrationDao.listAllBooks());
  }

}
