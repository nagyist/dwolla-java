package com.dwolla.java.sdk;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import retrofit.io.MimeType;

import com.dwolla.java.sdk.requests.SendRequest;
import com.google.gson.Gson;

public class DwollaTypedBytesTest {

   @Test
   public void testUtf8StaticVariable() {
      Assert.assertEquals("UTF-8", DwollaTypedBytes.UTF_8);
   }

   @Test
   public void testMimeTypeReturnsJson() {
      MimeType expected = new MimeType("application/json", "json");

      MimeType actual = new DwollaTypedBytes(new Gson(), new SendRequest()).mimeType();

      Assert.assertEquals(expected.mimeName(), actual.mimeName());
      Assert.assertEquals(expected.extension(), actual.extension());
   }

   @Test
   public void testLengthReturnsExpectedLength() {
      Assert.assertEquals(70, new DwollaTypedBytes(new Gson(), createRequest()).length());
   }

   @Test
   public void testWriteToReturnsExpectedStream() {
      SendRequest expected = createRequest();
      ByteArrayOutputStream out = new ByteArrayOutputStream();

      try {
         new DwollaTypedBytes(new Gson(), expected).writeTo(out);
      } catch (IOException e) {
         Assert.fail("Unexpected execption thrown");
      }

      Assert.assertEquals(String.format("{\"oauth_token\":\"%s\",\"pin\":\"%s\",\"amount\":%s,\"assumeCosts\":%b}", expected.oauth_token,
            expected.pin, expected.amount, expected.assumeCosts), out.toString());
   }

   private SendRequest createRequest() {
      SendRequest request = new SendRequest();
      request.oauth_token = "123abc";
      request.pin = "1234";
      return request;
   }
}