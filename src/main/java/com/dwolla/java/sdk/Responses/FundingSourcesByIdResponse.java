package com.dwolla.java.sdk.Responses;

public class FundingSourcesByIdResponse {
   public boolean Success;
   public String Message;
   public FundingSourceById Response;

   public class FundingSourceById extends FundingSource {
      public double Balance;

      public FundingSourceById(String id, String name, String type, boolean verified, String processingType, double balance) {
         super(id, name, type, verified, processingType);
         Balance = balance;
      }
   }
}
