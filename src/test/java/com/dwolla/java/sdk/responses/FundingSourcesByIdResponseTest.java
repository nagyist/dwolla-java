package com.dwolla.java.sdk.responses;

import org.junit.Assert;
import org.junit.Test;

import com.dwolla.java.sdk.models.FundingSource;
import com.google.gson.Gson;

public class FundingSourcesByIdResponseTest {

   @Test
   public void testConversionToJson() {
      FundingSourcesByIdResponse response = createResponseObject();

      String actual = new Gson().toJson(response);

      Assert.assertEquals(getJsonString(response), actual);
   }

   @Test
   public void testConversionFromJson() {
      FundingSourcesByIdResponse expected = createResponseObject();

      FundingSourcesByIdResponse actual = new Gson().fromJson(getJsonString(expected), FundingSourcesByIdResponse.class);

      Assert.assertEquals(expected.Response.Id, actual.Response.Id);
      Assert.assertEquals(expected.Response.Name, actual.Response.Name);
      Assert.assertEquals(expected.Response.Type, actual.Response.Type);
      Assert.assertEquals(expected.Response.Verified, actual.Response.Verified);
      Assert.assertEquals(expected.Response.ProcessingType, actual.Response.ProcessingType);
      Assert.assertEquals(expected.Response.Balance, actual.Response.Balance, 0.001);
   }

   private FundingSourcesByIdResponse createResponseObject() {
      FundingSourcesByIdResponse response = new FundingSourcesByIdResponse();
      response.Response = new FundingSource();
      response.Response.Id = "123abc";
      response.Response.Name = "Bank of Ben";
      response.Response.Type = "Checking";
      response.Response.Verified = true;
      response.Response.ProcessingType = "FiSync";
      response.Response.Balance = 1234.56;
      return response;
   }

   private String getJsonString(FundingSourcesByIdResponse obj) {
      return String
            .format(
                  "{\"Response\":{\"Balance\":%.2f,\"Id\":\"%s\",\"Name\":\"%s\",\"Type\":\"%s\",\"Verified\":%b,\"ProcessingType\":\"%s\"},\"Success\":false}",
                  obj.Response.Balance, obj.Response.Id, obj.Response.Name, obj.Response.Type, obj.Response.Verified, obj.Response.ProcessingType);
   }

}
