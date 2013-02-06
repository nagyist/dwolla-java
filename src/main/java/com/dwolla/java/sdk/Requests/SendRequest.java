package com.dwolla.java.sdk.requests;

public class SendRequest {

   // Required
   public String oauth_token;
   public String pin;
   public String destinationId;
   public double amount;

   // Optional
   public boolean assumeCosts = false;
   public String destinationType = null;
   public String facilitatorAmount = null;
   public String notes = null;
   public String fundsSource = null;
   public AdditionalFee[] additionalFees = null;

   public class AdditionalFee {

      public String destinationId = null;
      public double amount = 0;

      public AdditionalFee(String destinationId, double amount) {
         this.destinationId = destinationId;
         this.amount = amount;
      }

   }

}
