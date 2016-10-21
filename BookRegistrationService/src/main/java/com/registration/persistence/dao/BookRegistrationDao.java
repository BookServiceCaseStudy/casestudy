package com.registration.persistence.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.registration.entities.Book;
import com.registration.persistence.repositories.BookRegistrationRepository;

@Component
public class BookRegistrationDao
{
   @Autowired
   private BookRegistrationRepository customerRepository;
   
   public void save (Book book)
   {
     customerRepository.save(book);  
   }
   
   public Iterable<Book> listAllBooks ()
   {
     return customerRepository.findAll();
   }
   
   public Book findBookByName (String name)
   {
     return customerRepository.findBookByName(name);
   }
   
   public Book findBookById (Long id)
   {
     return customerRepository.findOne(id);
   }
}
