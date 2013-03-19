package com.dwolla.java.sdk.responses;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;

public class RequestResponseTest {

   @Test
   public void testConversionToJson() {
      RequestResponse response = createResponseObject();

      String actual = new Gson().toJson(response);

      Assert.assertEquals(getJsonString(response), actual);
   }

   @Test
   public void testConversionFromJson() {
      RequestResponse expected = createResponseObject();

      RequestResponse actual = new Gson().fromJson(getJsonString(expected), RequestResponse.class);

      Assert.assertEquals(expected.Response, actual.Response);
   }

   private RequestResponse createResponseObject() {
      RequestResponse response = new RequestResponse();
      response.Response = 123;
      return response;
   }

   private String getJsonString(RequestResponse obj) {
      return String.format("{\"Response\":%d,\"Success\":false}", obj.Response);
   }

}
