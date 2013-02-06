package com.dwolla.java.sdk.responses;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;

public class ResponseTest {

   @Test
   public void testConversionToJson() {
      Response response = createResponseObject();

      String actual = new Gson().toJson(response);

      Assert.assertEquals(getJsonString(response), actual);
   }

   @Test
   public void testConversionFromJson() {
      Response expected = createResponseObject();

      Response actual = new Gson().fromJson(getJsonString(expected), Response.class);

      Assert.assertEquals(expected.Success, actual.Success);
      Assert.assertEquals(expected.Message, actual.Message);
   }

   private Response createResponseObject() {
      Response response = new Response();
      response.Success = true;
      response.Message = "Success";
      return response;
   }

   private String getJsonString(Response obj) {
      return String.format("{\"Success\":%s,\"Message\":\"%s\"}", obj.Success, obj.Message);
   }

}
