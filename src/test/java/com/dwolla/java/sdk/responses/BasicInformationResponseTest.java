package com.dwolla.java.sdk.responses;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;

public class BasicInformationResponseTest {

   @Test
   public void testConversionToJson() {
      BasicInformationResponse response = createResponseObject();

      String actual = new Gson().toJson(response);

      Assert.assertEquals(getJsonString(response), actual);
   }

   @Test
   public void testConversionFromJson() {
      BasicInformationResponse expected = createResponseObject();

      BasicInformationResponse actual = new Gson().fromJson(getJsonString(expected), BasicInformationResponse.class);

      Assert.assertEquals(expected.Success, actual.Success);
      Assert.assertEquals(expected.Message, actual.Message);
      Assert.assertEquals(expected.Response.Id, actual.Response.Id);
      Assert.assertEquals(expected.Response.Name, actual.Response.Name);
      Assert.assertEquals(expected.Response.Latitude, actual.Response.Latitude, 0.01);
      Assert.assertEquals(expected.Response.Longitude, actual.Response.Longitude, 0.01);
   }

   private BasicInformationResponse createResponseObject() {
      BasicInformationResponse response = new BasicInformationResponse();
      response.Success = true;
      response.Message = "Success";
      response.Response = response.new BasicInformation("812-000-0000", "Ben Milne", 41.0, -91.0);
      return response;
   }

   private String getJsonString(BasicInformationResponse obj) {
      return String.format("{\"Success\":%s,\"Message\":\"%s\",\"Response\":{\"Id\":\"%s\",\"Name\":\"%s\",\"Latitude\":%.1f,\"Longitude\":%.1f}}",
            obj.Success, obj.Message, obj.Response.Id, obj.Response.Name, obj.Response.Latitude, obj.Response.Longitude);
   }

}
