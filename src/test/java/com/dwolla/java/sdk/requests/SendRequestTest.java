package com.dwolla.java.sdk.requests;

import org.junit.Assert;
import org.junit.Test;

import com.dwolla.java.sdk.models.Fee;
import com.google.gson.Gson;

public class SendRequestTest {

   @Test
   public void testConversionToJson() {
      SendRequest response = createRequestObject();

      String actual = new Gson().toJson(response);

      Assert.assertEquals(getJsonString(response), actual);
   }

   @Test
   public void testConversionFromJson() {
      SendRequest expected = createRequestObject();

      SendRequest actual = new Gson().fromJson(getJsonString(expected), SendRequest.class);

      Assert.assertEquals(expected.oauth_token, actual.oauth_token);
      Assert.assertEquals(expected.pin, actual.pin);
      Assert.assertEquals(expected.destinationId, actual.destinationId);
      Assert.assertEquals(expected.amount, actual.amount, 0.001);
      Assert.assertEquals(expected.assumeCosts, actual.assumeCosts);
      Assert.assertEquals(expected.destinationType, actual.destinationType);
      Assert.assertEquals(expected.facilitatorAmount, actual.facilitatorAmount);
      Assert.assertEquals(expected.notes, actual.notes);
      Assert.assertEquals(expected.fundsSource, actual.fundsSource);
      Assert.assertEquals(expected.additionalFees[0].destinationId, actual.additionalFees[0].destinationId);
      Assert.assertEquals(expected.additionalFees[0].amount, actual.additionalFees[0].amount, 0.001);
      Assert.assertEquals(expected.additionalFees[1].destinationId, actual.additionalFees[1].destinationId);
      Assert.assertEquals(expected.additionalFees[1].amount, actual.additionalFees[1].amount, 0.001);
   }

   private SendRequest createRequestObject() {
      SendRequest request = new SendRequest();
      request.oauth_token = "123abc";
      request.pin = "123";
      request.destinationId = "812-000-0000";
      request.amount = 1.11;
      request.assumeCosts = true;
      request.destinationType = "Dwolla";
      request.facilitatorAmount = "0.05";
      request.notes = "Notes";
      request.fundsSource = "Balance";

      Fee[] fees = { new Fee("812-000-0001", 0.01), new Fee("812-000-0002", 0.02) };
      request.additionalFees = fees;

      return request;
   }

   private String getJsonString(SendRequest obj) {
      return String
            .format(
                  "{\"oauth_token\":\"%s\",\"pin\":\"%s\",\"destinationId\":\"%s\",\"amount\":%.2f,\"assumeCosts\":%b,\"destinationType\":\"%s\",\"facilitatorAmount\":\"%s\",\"notes\":\"%s\",\"fundsSource\":\"%s\",\"additionalFees\":[{\"destinationId\":\"%s\",\"amount\":%.2f},{\"destinationId\":\"%s\",\"amount\":%.2f}]}",
                  obj.oauth_token, obj.pin, obj.destinationId, obj.amount, obj.assumeCosts, obj.destinationType, obj.facilitatorAmount, obj.notes,
                  obj.fundsSource, obj.additionalFees[0].destinationId, obj.additionalFees[0].amount, obj.additionalFees[1].destinationId,
                  obj.additionalFees[1].amount);
   }

}
