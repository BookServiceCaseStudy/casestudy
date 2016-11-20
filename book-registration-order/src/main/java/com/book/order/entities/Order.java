package com.book.order.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="BookOrder")
public class Order
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private String bookName;
  private String externaBookXref;
  private String clientId;
  private String author;
  private int numberOfBooksRequired;
  private boolean completed;

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public String getBookName()
  {
    return bookName;
  }

  public void setBookName(String bookName)
  {
    this.bookName = bookName;
  }

  public String getExternaBookXref()
  {
    return externaBookXref;
  }

  public void setExternaBookXref(String externaBookXref)
  {
    this.externaBookXref = externaBookXref;
  }

  public String getClientId()
  {
    return clientId;
  }

  public void setClientId(String clientId)
  {
    this.clientId = clientId;
  }

  public String getAuthor()
  {
    return author;
  }

  public void setAuthor(String author)
  {
    this.author = author;
  }

  public int getNumberOfBooksRequired()
  {
    return numberOfBooksRequired;
  }

  public void setNumberOfBooksRequired(int numberOfBooksRequired)
  {
    this.numberOfBooksRequired = numberOfBooksRequired;
  }

  public boolean isCompleted()
  {
    return completed;
  }

  public void setCompleted(boolean completed)
  {
    this.completed = completed;
  }

}
