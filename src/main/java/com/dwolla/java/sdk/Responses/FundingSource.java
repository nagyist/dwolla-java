package com.dwolla.java.sdk.responses;

public class FundingSource {
   public String Id;
   public String Name;
   public String Type;
   public boolean Verified;
   public String ProcessingType;

   public FundingSource(String id, String name, String type, boolean verified, String processingType) {
      Id = id;
      Name = name;
      Type = type;
      Verified = verified;
      ProcessingType = processingType;
   }
}