package com.dwolla.java.sdk;

public class DwollaUtil {
   public String BASE_URL = "https://www.dwolla.com/oauth/rest";

   private String mToken;

   public String getAccessToken() {
      return mToken;
   }

   public void setAccessToken(String token) {
      mToken = token;
   }
}