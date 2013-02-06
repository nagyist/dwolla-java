package com.dwolla.java.sdk.models;

public class Transaction {
   public int Id;
   public double Amount;
   public String Date;
   public String Type;
   public String UserType;
   public String DestinationId;
   public String DestinationName;
   public String SourceId;
   public String SourceName;
   public String ClearingDate;
   public String Status;
   public String Notes;
   public Transaction[] Fees;
}