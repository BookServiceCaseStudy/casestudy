package com.order.web.pojo;

public class Order
{
  private int id;
  private String bookName;
  private String externaBookXref;
  private String clientId;
  private String author;
  private int numberOfBooksRequired;
  private boolean orderCompleted;

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

  public boolean isOrderCompleted()
  {
    return orderCompleted;
  }

  public void setOrderCompleted(boolean orderCompleted)
  {
    this.orderCompleted = orderCompleted;
  }

  public int getNumberOfBooksRequired()
  {
    return numberOfBooksRequired;
  }

  public void setNumberOfBooksRequired(int numberOfBooksRequired)
  {
    this.numberOfBooksRequired = numberOfBooksRequired;
  }

}
