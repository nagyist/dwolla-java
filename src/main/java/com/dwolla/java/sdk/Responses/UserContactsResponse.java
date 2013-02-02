package com.dwolla.java.sdk.Responses;

import java.util.ArrayList;

public class UserContactsResponse {
   public boolean Success;
   public String Message;
   public ArrayList<UserContact> Response;

   public class UserContact {
      public String Name;
      public String Id;
      public String Type;
      public String Image;

      public UserContact(String name, String id, String type, String image) {
         Name = name;
         Id = id;
         Type = type;
         Image = image;
      }
   }
}
