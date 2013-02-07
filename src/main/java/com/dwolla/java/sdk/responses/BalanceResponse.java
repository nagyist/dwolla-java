package com.dwolla.java.sdk.responses;

public class BalanceResponse extends Response {

   public double Response;

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = super.hashCode();
      long temp;
      temp = Double.doubleToLongBits(Response);
      result = prime * result + (int) (temp ^ (temp >>> 32));
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
      BalanceResponse other = (BalanceResponse) obj;
      if (Double.doubleToLongBits(Response) != Double.doubleToLongBits(other.Response))
         return false;
      return true;
   }

}
