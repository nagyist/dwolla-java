package com.dwolla.java.sdk.requests;

public class DepositWithdrawRequest {

   /** Required */
   public String oauth_token;
   public String funding_id;
   public String pin;
   public double amount;

   public DepositWithdrawRequest(String oauth_token, String funding_id, String pin, double amount) {
      super();
      this.oauth_token = oauth_token;
      this.funding_id = funding_id;
      this.pin = pin;
      this.amount = amount;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      long temp;
      temp = Double.doubleToLongBits(amount);
      result = prime * result + (int) (temp ^ (temp >>> 32));
      result = prime * result + ((funding_id == null) ? 0 : funding_id.hashCode());
      result = prime * result + ((oauth_token == null) ? 0 : oauth_token.hashCode());
      result = prime * result + ((pin == null) ? 0 : pin.hashCode());
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
      DepositWithdrawRequest other = (DepositWithdrawRequest) obj;
      if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
         return false;
      if (funding_id == null) {
         if (other.funding_id != null)
            return false;
      } else if (!funding_id.equals(other.funding_id))
         return false;
      if (oauth_token == null) {
         if (other.oauth_token != null)
            return false;
      } else if (!oauth_token.equals(other.oauth_token))
         return false;
      if (pin == null) {
         if (other.pin != null)
            return false;
      } else if (!pin.equals(other.pin))
         return false;
      return true;
   }

}
