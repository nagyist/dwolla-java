package com.dwolla.java.sdk.Responses;

import java.util.ArrayList;

public class NearbySpotsResponse {
   public boolean Success;
   public String Message;
   public ArrayList<NearbySpot> Response;

   public class NearbySpot {
      public String Address;
      public String City;
      public String State;
      public String Group;
      public String Id;
      public String Image;
      public double Latitude;
      public double Longitude;
      public String Name;
      public String PostalCode;

      public NearbySpot(String address, String city, String state, String group, String id, String image, double latitude, double longitude,
            String name, String postalCode) {
         Address = address;
         City = city;
         State = state;
         Group = group;
         Id = id;
         Image = image;
         Latitude = latitude;
         Longitude = longitude;
         Name = name;
         PostalCode = postalCode;
      }
   }
}
