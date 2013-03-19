package com.dwolla.java.sdk.requests;

public class RequestRequest {

   /** Required */
   public String oauth_token;
   public String sourceId;
   public double amount;

   /** Optional */
   public String sourceType = null; // See Constants.UserType
   public String facilitatorAmount = null;
   public String notes = null;

   public RequestRequest(String oauth_token, String sourceId, double amount) {
      super();
      this.oauth_token = oauth_token;
      this.sourceId = sourceId;
      this.amount = amount;
   }

   public RequestRequest(String oauth_token, String sourceId, double amount, String sourceType, String facilitatorAmount, String notes) {
      super();
      this.oauth_token = oauth_token;
      this.sourceId = sourceId;
      this.amount = amount;
      this.sourceType = sourceType;
      this.facilitatorAmount = facilitatorAmount;
      this.notes = notes;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      long temp;
      temp = Double.doubleToLongBits(amount);
      result = prime * result + (int) (temp ^ (temp >>> 32));
      result = prime * result + ((facilitatorAmount == null) ? 0 : facilitatorAmount.hashCode());
      result = prime * result + ((notes == null) ? 0 : notes.hashCode());
      result = prime * result + ((oauth_token == null) ? 0 : oauth_token.hashCode());
      result = prime * result + ((sourceId == null) ? 0 : sourceId.hashCode());
      result = prime * result + ((sourceType == null) ? 0 : sourceType.hashCode());
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
      RequestRequest other = (RequestRequest) obj;
      if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
         return false;
      if (facilitatorAmount == null) {
         if (other.facilitatorAmount != null)
            return false;
      } else if (!facilitatorAmount.equals(other.facilitatorAmount))
         return false;
      if (notes == null) {
         if (other.notes != null)
            return false;
      } else if (!notes.equals(other.notes))
         return false;
      if (oauth_token == null) {
         if (other.oauth_token != null)
            return false;
      } else if (!oauth_token.equals(other.oauth_token))
         return false;
      if (sourceId == null) {
         if (other.sourceId != null)
            return false;
      } else if (!sourceId.equals(other.sourceId))
         return false;
      if (sourceType == null) {
         if (other.sourceType != null)
            return false;
      } else if (!sourceType.equals(other.sourceType))
         return false;
      return true;
   }

}
