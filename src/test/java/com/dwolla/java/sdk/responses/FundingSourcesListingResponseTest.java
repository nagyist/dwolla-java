package com.dwolla.java.sdk.responses;

import org.junit.Assert;
import org.junit.Test;

import com.dwolla.java.sdk.models.BasicFundingSource;
import com.google.gson.Gson;

public class FundingSourcesListingResponseTest {

   @Test
   public void testConversionToJson() {
      FundingSourcesListingResponse response = createResponseObject();

      String actual = new Gson().toJson(response);

      Assert.assertEquals(getJsonString(response), actual);
   }

   @Test
   public void testConversionFromJson() {
      FundingSourcesListingResponse expected = createResponseObject();

      FundingSourcesListingResponse actual = new Gson().fromJson(getJsonString(expected), FundingSourcesListingResponse.class);

      Assert.assertEquals(expected.Response[0].Id, actual.Response[0].Id);
      Assert.assertEquals(expected.Response[0].Name, actual.Response[0].Name);
      Assert.assertEquals(expected.Response[0].Type, actual.Response[0].Type);
      Assert.assertEquals(expected.Response[0].Verified, actual.Response[0].Verified);
      Assert.assertEquals(expected.Response[0].ProcessingType, actual.Response[0].ProcessingType);
      Assert.assertEquals(expected.Response[1].Id, actual.Response[1].Id);
      Assert.assertEquals(expected.Response[1].Name, actual.Response[1].Name);
   }

   private FundingSourcesListingResponse createResponseObject() {
      FundingSourcesListingResponse response = new FundingSourcesListingResponse();
      BasicFundingSource[] sources = { new BasicFundingSource(), new BasicFundingSource() };
      response.Response = sources;
      response.Response[0].Id = "123abc";
      response.Response[0].Name = "Bank of Ben";
      response.Response[0].Type = "Checking";
      response.Response[0].Verified = true;
      response.Response[0].ProcessingType = "FiSync";
      response.Response[1].Id = "456def";
      response.Response[1].Name = "Bank of Milne";
      return response;
   }

   private String getJsonString(FundingSourcesListingResponse obj) {
      return String
            .format(
                  "{\"Response\":[{\"Id\":\"%s\",\"Name\":\"%s\",\"Type\":\"%s\",\"Verified\":%b,\"ProcessingType\":\"%s\"},{\"Id\":\"%s\",\"Name\":\"%s\",\"Verified\":%b}],\"Success\":false}",
                  obj.Response[0].Id, obj.Response[0].Name, obj.Response[0].Type, obj.Response[0].Verified, obj.Response[0].ProcessingType,
                  obj.Response[1].Id, obj.Response[1].Name, obj.Response[1].Verified);
   }

}
