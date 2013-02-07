package com.dwolla.java.sdk.models;

public class Fee {

   public String destinationId = null;
   public double amount = 0;

   public Fee(String destinationId, double amount) {
      super();
      this.destinationId = destinationId;
      this.amount = amount;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      long temp;
      temp = Double.doubleToLongBits(amount);
      result = prime * result + (int) (temp ^ (temp >>> 32));
      result = prime * result + ((destinationId == null) ? 0 : destinationId.hashCode());
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
      Fee other = (Fee) obj;
      if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
         return false;
      if (destinationId == null) {
         if (other.destinationId != null)
            return false;
      } else if (!destinationId.equals(other.destinationId))
         return false;
      return true;
   }

}