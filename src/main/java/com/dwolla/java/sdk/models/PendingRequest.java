package com.dwolla.java.sdk.models;

public class PendingRequest extends Request {

   public String DateRequested;

   public PendingRequest(int id, double amount, String dateRequested, String status, UserContact source, UserContact destination) {
      super(id, amount, status, source, destination);
      DateRequested = dateRequested;
   }

   public PendingRequest() {
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = super.hashCode();
      result = prime * result + ((DateRequested == null) ? 0 : DateRequested.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (!super.equals(obj))
         return false;
      if (getClass() != obj.getClass())
         return false;
      PendingRequest other = (PendingRequest) obj;
      if (DateRequested == null) {
         if (other.DateRequested != null)
            return false;
      } else if (!DateRequested.equals(other.DateRequested))
         return false;
      return true;
   }

}
