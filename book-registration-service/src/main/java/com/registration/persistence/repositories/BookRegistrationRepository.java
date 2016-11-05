package com.registration.persistence.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.registration.entities.Book;

@Repository
public interface BookRegistrationRepository extends CrudRepository<Book, Long>
{
      Book findBookByName(String name);
}
