package com.dwolla.java.sdk.models;

public class FundingSource extends BasicFundingSource {

   public double Balance;

   public FundingSource(String id, String name, String type, boolean verified, String processingType, double balance) {
      super(id, name, type, verified, processingType);
      Balance = balance;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = super.hashCode();
      long temp;
      temp = Double.doubleToLongBits(Balance);
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
      FundingSource other = (FundingSource) obj;
      if (Double.doubleToLongBits(Balance) != Double.doubleToLongBits(other.Balance))
         return false;
      return true;
   }

}