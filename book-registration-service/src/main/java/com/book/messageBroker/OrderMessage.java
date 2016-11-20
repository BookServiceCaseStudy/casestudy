package com.book.messageBroker;

public class OrderMessage
{
  private String bookXref;
  private String clientName;
  private int numbersOfBookAdded;

  public String getBookXref()
  {
    return bookXref;
  }

  public void setBookXref(String bookXref)
  {
    this.bookXref = bookXref;
  }

  public String getClientName()
  {
    return clientName;
  }

  public void setClientName(String clientName)
  {
    this.clientName = clientName;
  }

  public int getNumbersOfBookAdded()
  {
    return numbersOfBookAdded;
  }

  public void setNumbersOfBookAdded(int numbersOfBookAdded)
  {
    this.numbersOfBookAdded = numbersOfBookAdded;
  }

}
