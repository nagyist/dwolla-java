package com.dwolla.java.sdk;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import retrofit.io.MimeType;

import com.dwolla.java.sdk.requests.SendRequest;
import com.dwolla.java.sdk.responses.BalanceResponse;
import com.google.gson.Gson;

public class DwollaTypedBytesTest {

   @Test
   public void testUtf8StaticVariable() {
      Assert.assertEquals("UTF-8", DwollaTypedBytes.UTF_8);
   }

   @Test
   public void testMimeTypeReturnsJson() {
      MimeType expected = new MimeType("application/json", "json");

      MimeType actual = new DwollaTypedBytes(new Gson(), new BalanceResponse()).mimeType();

      Assert.assertEquals(expected.mimeName(), actual.mimeName());
      Assert.assertEquals(expected.extension(), actual.extension());
   }

   @Test
   public void testLengthReturnsExpectedLength() {
      Assert.assertEquals(102, new DwollaTypedBytes(new Gson(), createRequest()).length());
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

      Assert.assertEquals("{\"oauth_token\":\"123abc\",\"pin\":\"1234\",\"destinationId\":\"812-000-0000\",\"amount\":0.01,\"assumeCosts\":false}", out.toString());
   }

   private SendRequest createRequest() {
      return new SendRequest("123abc", "1234", "812-000-0000", 0.01);
   }
}