package com.registration.entities;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Book")
public class Book implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String name;
  private String author;
  private int quantity;
  private String description;
  private transient String searchString;
  private String publishYear;

  public Book()
  {
  }

  public Book(String bookName, String bookAuthor, int quantity)
  {
    this.name = bookName;
    this.author = bookAuthor;
    this.quantity = quantity;
  }

  public long getId()
  {
    return id;
  }

  public void setId(long id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getAuthor()
  {
    return author;
  }

  public void setAuthor(String author)
  {
    this.author = author;
  }

  public int getQuantity()
  {
    return quantity;
  }

  public void setQuantity(int quantity)
  {
    this.quantity = quantity;
  }

  public String getSearchString()
  {
    return searchString;
  }

  public void setSearchString(String searchString)
  {
    this.searchString = searchString;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public String getPublishYear()
  {
    return publishYear;
  }

  public void setPublishYear(String publishYear)
  {
    this.publishYear = publishYear;
  }

}
