package com.book.messageBroker;

public class BookMessage
{
  int noOfBookLeft;
  String message;
  String bookName;
  int noOfBookNeeded;
  boolean newOrder;

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

  public String getMessage()
  {
    return message;
  }

  public void setMessage(String message)
  {
    this.message = message;
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
   
}
