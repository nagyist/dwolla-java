package com.dwolla.java.sdk.responses;

import org.junit.Assert;
import org.junit.Test;

import com.dwolla.java.sdk.models.AccountInformation;
import com.google.gson.Gson;

public class AccountInformationResponseTest {

   @Test
   public void testConversionToJson() {
      AccountInformationResponse response = createResponseObject();

      String actual = new Gson().toJson(response);

      Assert.assertEquals(getJsonString(response), actual);
   }

   @Test
   public void testConversionFromJson() {
      AccountInformationResponse expected = createResponseObject();

      AccountInformationResponse actual = new Gson().fromJson(getJsonString(expected), AccountInformationResponse.class);

      Assert.assertEquals(expected.Response.City, actual.Response.City);
      Assert.assertEquals(expected.Response.State, actual.Response.State);
      Assert.assertEquals(expected.Response.Type, actual.Response.Type);
      Assert.assertEquals(expected.Response.Id, actual.Response.Id);
      Assert.assertEquals(expected.Response.Name, actual.Response.Name);
      Assert.assertEquals(expected.Response.Latitude, actual.Response.Latitude, 0.01);
      Assert.assertEquals(expected.Response.Longitude, actual.Response.Longitude, 0.01);
   }

   private AccountInformationResponse createResponseObject() {
      AccountInformationResponse response = new AccountInformationResponse();
      response.Response = new AccountInformation();
      response.Response.City = "Des Moines";
      response.Response.State = "IA";
      response.Response.Type = "Dwolla";
      response.Response.Id = "812-000-0000";
      response.Response.Name = "Ben Milne";
      response.Response.Latitude = 41.0;
      response.Response.Longitude = -91.0;
      return response;
   }

   private String getJsonString(AccountInformationResponse obj) {
      return String
            .format(
                  "{\"Response\":{\"City\":\"%s\",\"State\":\"%s\",\"Type\":\"%s\",\"Id\":\"%s\",\"Name\":\"%s\",\"Latitude\":%.1f,\"Longitude\":%.1f},\"Success\":false}",
                  obj.Response.City, obj.Response.State, obj.Response.Type, obj.Response.Id, obj.Response.Name, obj.Response.Latitude,
                  obj.Response.Longitude);
   }

}
