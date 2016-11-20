package com.book.messageBroker.message;

public class OrderMessage
{
  private String bookXref;
  private String clientName;
  private String numbersOfBookAdded;

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

  public String getNumbersOfBookAdded()
  {
    return numbersOfBookAdded;
  }

  public void setNumbersOfBookAdded(String numbersOfBookAdded)
  {
    this.numbersOfBookAdded = numbersOfBookAdded;
  }
}
