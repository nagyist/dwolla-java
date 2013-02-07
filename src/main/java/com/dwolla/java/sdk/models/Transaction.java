package com.dwolla.java.sdk.models;

import java.util.Arrays;

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

   public Transaction(int id, double amount, String date, String type, String userType, String destinationId, String destinationName,
         String sourceId, String sourceName, String clearingDate, String status, String notes, Transaction[] fees) {
      super();
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

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      long temp;
      temp = Double.doubleToLongBits(Amount);
      result = prime * result + (int) (temp ^ (temp >>> 32));
      result = prime * result + ((ClearingDate == null) ? 0 : ClearingDate.hashCode());
      result = prime * result + ((Date == null) ? 0 : Date.hashCode());
      result = prime * result + ((DestinationId == null) ? 0 : DestinationId.hashCode());
      result = prime * result + ((DestinationName == null) ? 0 : DestinationName.hashCode());
      result = prime * result + Arrays.hashCode(Fees);
      result = prime * result + Id;
      result = prime * result + ((Notes == null) ? 0 : Notes.hashCode());
      result = prime * result + ((SourceId == null) ? 0 : SourceId.hashCode());
      result = prime * result + ((SourceName == null) ? 0 : SourceName.hashCode());
      result = prime * result + ((Status == null) ? 0 : Status.hashCode());
      result = prime * result + ((Type == null) ? 0 : Type.hashCode());
      result = prime * result + ((UserType == null) ? 0 : UserType.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Transaction other = (Transaction) obj;
      if (Double.doubleToLongBits(Amount) != Double.doubleToLongBits(other.Amount))
         return false;
      if (ClearingDate == null) {
         if (other.ClearingDate != null)
            return false;
      } else if (!ClearingDate.equals(other.ClearingDate))
         return false;
      if (Date == null) {
         if (other.Date != null)
            return false;
      } else if (!Date.equals(other.Date))
         return false;
      if (DestinationId == null) {
         if (other.DestinationId != null)
            return false;
      } else if (!DestinationId.equals(other.DestinationId))
         return false;
      if (DestinationName == null) {
         if (other.DestinationName != null)
            return false;
      } else if (!DestinationName.equals(other.DestinationName))
         return false;
      if (!Arrays.equals(Fees, other.Fees))
         return false;
      if (Id != other.Id)
         return false;
      if (Notes == null) {
         if (other.Notes != null)
            return false;
      } else if (!Notes.equals(other.Notes))
         return false;
      if (SourceId == null) {
         if (other.SourceId != null)
            return false;
      } else if (!SourceId.equals(other.SourceId))
         return false;
      if (SourceName == null) {
         if (other.SourceName != null)
            return false;
      } else if (!SourceName.equals(other.SourceName))
         return false;
      if (Status == null) {
         if (other.Status != null)
            return false;
      } else if (!Status.equals(other.Status))
         return false;
      if (Type == null) {
         if (other.Type != null)
            return false;
      } else if (!Type.equals(other.Type))
         return false;
      if (UserType == null) {
         if (other.UserType != null)
            return false;
      } else if (!UserType.equals(other.UserType))
         return false;
      return true;
   }

}