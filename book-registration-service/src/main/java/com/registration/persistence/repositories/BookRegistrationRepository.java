package com.registration.persistence.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.registration.entities.Book;

@Repository
public interface BookRegistrationRepository
  extends MongoRepository<Book, Long>, BookRegistrationRepositoryCustom
{
  List<Book> findBookByNameIgnoreCaseContaining(String name);
}
