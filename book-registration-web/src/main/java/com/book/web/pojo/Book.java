package com.book.web.pojo;

public class Book
{
  private long id;
  private String name;
  private String author;
  private int quantity;

  public Book()
  {
  }

  public Book(String bookName, String bookAuthor)
  {
    this.name = bookName;
    this.author = bookAuthor;
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
}
