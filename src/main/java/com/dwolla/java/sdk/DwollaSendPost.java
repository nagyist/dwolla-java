package com.dwolla.java.sdk;

import java.util.ArrayList;

public class DwollaSendPost {

   // Required
   public String oauth_token;
   public String pin;
   public String destinationId;
   public double amount;

   // Optional
   public String destinationType = null;
   public String facilitatorAmount = null;
   public boolean assumeCosts = false;
   public String notes = null;
   public String fundsSource = null;
   public ArrayList<AdditionalFees> additionalFees = null;

   public class AdditionalFees {

      public String destinationId = null;
      public double amount = 0;

      public AdditionalFees(String destinationId, double amount) {
         this.destinationId = destinationId;
         this.amount = amount;
      }

   }

}
