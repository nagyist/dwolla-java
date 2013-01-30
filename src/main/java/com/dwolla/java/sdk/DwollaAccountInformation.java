package com.dwolla.java.sdk;

import java.util.ArrayList;

public class DwollaAccountInformation {
   public boolean Success;
   public String Message;
   public ArrayList<AccountInformation> Response;

   public class AccountInformation {
      public String city;
      public String id;
      public double latitude;
      public double longitude;
      public String name;
      public String state;
      public String type;
      
      public AccountInformation() {
      }
   }
}
