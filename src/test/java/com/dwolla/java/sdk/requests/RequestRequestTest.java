package com.dwolla.java.sdk.requests;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;

public class RequestRequestTest {

   @Test
   public void testConversionToJson() {
      RequestRequest response = createRequestObject();

      String actual = new Gson().toJson(response);

      Assert.assertEquals(getJsonString(response), actual);
   }

   @Test
   public void testConversionFromJson() {
      RequestRequest expected = createRequestObject();

      RequestRequest actual = new Gson().fromJson(getJsonString(expected), RequestRequest.class);

      Assert.assertEquals(expected, actual);
   }

   private RequestRequest createRequestObject() {
      return new RequestRequest("123abc", "812-000-0000", 1.11, "Dwolla", "0.05", "Notes");
   }

   private String getJsonString(RequestRequest obj) {
      return "{\"oauth_token\":\"123abc\",\"sourceId\":\"812-000-0000\",\"amount\":1.11,\"sourceType\":\"Dwolla\",\"facilitatorAmount\":\"0.05\",\"notes\":\"Notes\"}";
   }

}
