package com.dwolla.java.sdk.models;

public class Fee {
   public String destinationId = null;
   public double amount = 0;

   public Fee(String destinationId, double amount) {
      this.destinationId = destinationId;
      this.amount = amount;
   }
}