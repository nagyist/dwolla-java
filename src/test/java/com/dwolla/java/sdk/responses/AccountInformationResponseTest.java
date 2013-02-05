package com.dwolla.java.sdk.responses;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;

public class AccountInformationResponseTest {

   @Test
   public void testConversionToJson() {
      AccountInformationResponse response = createResponseObject();
      String expected = getJsonString(response);

      String actual = new Gson().toJson(response);

      Assert.assertEquals(expected, actual);
   }

   @Test
   public void testConversionFromJson() {
      AccountInformationResponse expected = createResponseObject();
      String response = getJsonString(expected);

      AccountInformationResponse actual = new Gson().fromJson(response, AccountInformationResponse.class);

      Assert.assertEquals(expected.Success, actual.Success);
      Assert.assertEquals(expected.Message, actual.Message);
      Assert.assertEquals(expected.Response.City, actual.Response.City);
      Assert.assertEquals(expected.Response.State, actual.Response.State);
      Assert.assertEquals(expected.Response.Type, actual.Response.Type);
      Assert.assertEquals(expected.Response.Id, actual.Response.Id);
      Assert.assertEquals(expected.Response.Name, actual.Response.Name);
      Assert.assertEquals(expected.Response.Latitude, actual.Response.Latitude, 0.01);
      Assert.assertEquals(expected.Response.Longitude, actual.Response.Longitude, 0.01);
   }

   private AccountInformationResponse createResponseObject() {
      AccountInformationResponse expected = new AccountInformationResponse();
      expected.Success = true;
      expected.Message = "Success";
      expected.Response = expected.new AccountInformation("Des Moines", "IA", "Dwolla", "812-000-0000", "Ben Milne", 41.0, -91.0);
      return expected;
   }

   private String getJsonString(AccountInformationResponse obj) {
      return String
            .format(
                  "{\"Success\":%s,\"Message\":\"%s\",\"Response\":{\"City\":\"%s\",\"State\":\"%s\",\"Type\":\"%s\",\"Id\":\"%s\",\"Name\":\"%s\",\"Latitude\":%.1f,\"Longitude\":%.1f}}",
                  obj.Success, obj.Message, obj.Response.City, obj.Response.State, obj.Response.Type, obj.Response.Id, obj.Response.Name,
                  obj.Response.Latitude, obj.Response.Longitude);
   }

}
