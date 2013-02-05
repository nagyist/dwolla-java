package com.dwolla.java.sdk.responses;

public class BasicInformationResponse {
   public boolean Success;
   public String Message;
   public BasicInformation Response;

   public class BasicInformation {
      public String Id;
      public String Name;
      public double Latitude;
      public double Longitude;

      public BasicInformation(String id, String name, double latitude, double longitude) {
         Id = id;
         Name = name;
         Latitude = latitude;
         Longitude = longitude;
      }
   }
}
