package com.dwolla.java.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DwollaUtil {
   public String BASE_URL = "https://www.dwolla.com/oauth/rest";
   private Log log = LogFactory.getLog(DwollaUtil.class);

   private String mToken;

   public String getAccessToken() {
      return mToken;
   }

   public void setAccessToken(String token) {
      mToken = token;
      log.info("Access token set");
      log.error("Access token set as an error");
   }
}