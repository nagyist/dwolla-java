package com.dwolla.java.sdk.responses;

import org.junit.Assert;
import org.junit.Test;

import com.dwolla.java.sdk.models.BasicAccountInformation;
import com.google.gson.Gson;

public class BasicAccountInformationResponseTest {

   @Test
   public void testConversionToJson() {
      BasicAccountInformationResponse response = createResponseObject();

      String actual = new Gson().toJson(response);

      Assert.assertEquals(getJsonString(response), actual);
   }

   @Test
   public void testConversionFromJson() {
      BasicAccountInformationResponse expected = createResponseObject();

      BasicAccountInformationResponse actual = new Gson().fromJson(getJsonString(expected), BasicAccountInformationResponse.class);

      Assert.assertEquals(expected.Response.Id, actual.Response.Id);
      Assert.assertEquals(expected.Response.Name, actual.Response.Name);
      Assert.assertEquals(expected.Response.Latitude, actual.Response.Latitude, 0.01);
      Assert.assertEquals(expected.Response.Longitude, actual.Response.Longitude, 0.01);
   }

   private BasicAccountInformationResponse createResponseObject() {
      BasicAccountInformationResponse response = new BasicAccountInformationResponse();
      response.Response = new BasicAccountInformation();
      response.Response.Id = "812-000-0000";
      response.Response.Name = "Ben Milne";
      response.Response.Latitude = 41.0;
      response.Response.Longitude = -91.0;
      return response;
   }

   private String getJsonString(BasicAccountInformationResponse obj) {
      return String.format("{\"Response\":{\"Id\":\"%s\",\"Name\":\"%s\",\"Latitude\":%.1f,\"Longitude\":%.1f},\"Success\":false}", obj.Response.Id,
            obj.Response.Name, obj.Response.Latitude, obj.Response.Longitude);
   }

}
