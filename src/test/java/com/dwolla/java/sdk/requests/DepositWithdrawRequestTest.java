package com.dwolla.java.sdk.requests;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;

public class DepositWithdrawRequestTest {

   @Test
   public void testConversionToJson() {
      DepositWithdrawRequest response = createRequestObject();

      String actual = new Gson().toJson(response);

      Assert.assertEquals(getJsonString(response), actual);
   }

   @Test
   public void testConversionFromJson() {
      DepositWithdrawRequest expected = createRequestObject();

      DepositWithdrawRequest actual = new Gson().fromJson(getJsonString(expected), DepositWithdrawRequest.class);

      Assert.assertEquals(expected, actual);
   }

   private DepositWithdrawRequest createRequestObject() {
      return new DepositWithdrawRequest("123abc", "1234", 1.11);
   }

   private String getJsonString(DepositWithdrawRequest obj) {
      return "{\"oauth_token\":\"123abc\",\"pin\":\"1234\",\"amount\":1.11}";
   }

}
