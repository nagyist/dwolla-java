package com.dwolla.java.sdk.requests;

import com.dwolla.java.sdk.models.Fee;

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
   public Fee[] additionalFees = null;
}
