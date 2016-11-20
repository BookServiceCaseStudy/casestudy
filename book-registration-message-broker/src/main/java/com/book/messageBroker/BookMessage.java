package com.book.messageBroker;

import java.io.Serializable;

public class BookMessage implements Serializable
{
  private static final long serialVersionUID = 6806683314223167095L;
  int noOfBookLeft;
  String bookName;
  int noOfBookNeeded;
  boolean newOrder;
  String author;
  String clientId;
  String externalBookRefId;

  /**
   * @return the noOfBookLeft
   */
  public int getNoOfBookLeft()
  {
    return noOfBookLeft;
  }

  /**
   * @param noOfBookLeft the noOfBookLeft to set
   */
  public void setNoOfBookLeft(int noOfBookLeft)
  {
    this.noOfBookLeft = noOfBookLeft;
  }

  public String getBookName()
  {
    return bookName;
  }

  public void setBookName(String bookName)
  {
    this.bookName = bookName;
  }

  public boolean isNewOrder()
  {
    return newOrder;
  }

  public void setNewOrder(boolean newOrder)
  {
    this.newOrder = newOrder;
  }

  public int getNoOfBookNeeded()
  {
    return noOfBookNeeded;
  }

  public void setNoOfBookNeeded(int noOfBookNeeded)
  {
    this.noOfBookNeeded = noOfBookNeeded;
  }

  public String getAuthor()
  {
    return author;
  }

  public void setAuthor(String author)
  {
    this.author = author;
  }

  public String getClientId()
  {
    return clientId;
  }

  public void setClientId(String clientId)
  {
    this.clientId = clientId;
  }

  public String getExternalBookRefId()
  {
    return externalBookRefId;
  }

  public void setExternalBookRefId(String externalBookRefId)
  {
    this.externalBookRefId = externalBookRefId;
  }
   
}
