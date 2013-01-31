package com.dwolla.java.sdk;

public class AccountInformationResponse {
   public boolean Success;
   public String Message;
   public AccountInformation Response;

   public class AccountInformation {
      public String City;
      public String State;
      public String Type;
      public String Id;
      public String Name;
      public double Latitude;
      public double Longitude;

      public AccountInformation(String city, String state, String type, String id, String name, double latitude, double longitude) {
         City = city;
         State = state;
         Type = type;
         Id = id;
         Name = name;
         Latitude = latitude;
         Longitude = longitude;
      }
   }
}
