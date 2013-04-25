package com.dwolla.java.sdk.responses;

import org.junit.Assert;
import org.junit.Test;

import com.dwolla.java.sdk.models.Transaction;
import com.google.gson.Gson;

public class DepositWithdrawResponseTest {

   @Test
   public void testConversionToJson() {
      DepositWithdrawResponse response = createResponseObject();

      String actual = new Gson().toJson(response);

      Assert.assertEquals(getJsonString(response), actual);
   }

   @Test
   public void testConversionFromJson() {
      DepositWithdrawResponse expected = createResponseObject();

      DepositWithdrawResponse actual = new Gson().fromJson(getJsonString(expected), DepositWithdrawResponse.class);

      Assert.assertEquals(expected.Response, actual.Response);
   }

   private DepositWithdrawResponse createResponseObject() {
      DepositWithdrawResponse response = new DepositWithdrawResponse();
      response.Response = new Transaction(123, 1.11, "1-1-11", "money_sent", "Dwolla", "812-000-0000", "812-000-0001", "Ben Milne", "1", "1-2-11",
            "processed", "Hey");
      return response;
   }

   private String getJsonString(DepositWithdrawResponse obj) {
      return "{\"Response\":{\"Id\":123,\"Amount\":1.11,\"Date\":\"1-1-11\",\"Type\":\"money_sent\",\"UserType\":\"Dwolla\",\"DestinationId\":\"812-000-0000\",\"DestinationName\":\"812-000-0001\",\"SourceId\":\"Ben Milne\",\"SourceName\":\"1\",\"ClearingDate\":\"1-2-11\",\"Status\":\"processed\",\"Notes\":\"Hey\"},\"Success\":false}";
   }

}
