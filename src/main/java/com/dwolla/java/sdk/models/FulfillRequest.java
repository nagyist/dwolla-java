package com.dwolla.java.sdk.models;

public class FulfillRequest extends Request {

   public int RequestId;
   public String SentDate;
   public String ClearingDate;

   public FulfillRequest(int id, int requestId, double amount, String sentDate, String clearingDate, String status, UserContact source,
         UserContact destination) {
      super(id, amount, status, source, destination);
      RequestId = requestId;
      SentDate = sentDate;
      ClearingDate = clearingDate;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = super.hashCode();
      result = prime * result + ((ClearingDate == null) ? 0 : ClearingDate.hashCode());
      result = prime * result + RequestId;
      result = prime * result + ((SentDate == null) ? 0 : SentDate.hashCode());
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
      FulfillRequest other = (FulfillRequest) obj;
      if (ClearingDate == null) {
         if (other.ClearingDate != null)
            return false;
      } else if (!ClearingDate.equals(other.ClearingDate))
         return false;
      if (RequestId != other.RequestId)
         return false;
      if (SentDate == null) {
         if (other.SentDate != null)
            return false;
      } else if (!SentDate.equals(other.SentDate))
         return false;
      return true;
   }

}
