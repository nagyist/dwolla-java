package com.dwolla.java.sdk;

import java.util.ArrayList;

public class TransactionsResponse {
   public boolean Success;
   public String Message;
   public ArrayList<Transaction> Response;

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
      public ArrayList<Transaction> Fees;

      public Transaction(int id, double amount, String date, String type, String userType, String destinationId, String destinationName,
            String sourceId, String sourceName, String clearingDate, String status, String notes, ArrayList<Transaction> fees) {
         Id = id;
         Amount = amount;
         Date = date;
         Type = type;
         UserType = userType;
         DestinationId = destinationId;
         DestinationName = destinationName;
         SourceId = sourceId;
         SourceName = sourceName;
         ClearingDate = clearingDate;
         Status = status;
         Notes = notes;
         Fees = fees;
      }
   }
}
