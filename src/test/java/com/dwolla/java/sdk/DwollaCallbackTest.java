package com.dwolla.java.sdk;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import retrofit.http.ConversionException;
import retrofit.http.GsonConverter;
import retrofit.http.Header;
import retrofit.http.RetrofitError;
import retrofit.http.client.Response;
import retrofit.http.mime.TypedInput;

import com.dwolla.java.sdk.responses.BalanceResponse;
import com.google.gson.Gson;

public class DwollaCallbackTest {
   private DwollaCallback<BalanceResponse> callback;
   private Log log;

   @Before
   public void setUp() {
      callback = new TestCallback();
      log = mock(Log.class);
      callback.setLog(log);
   }

   @Test
   public void testSuccessWithNullDoesNotThrow() {
      try {
         callback.success(null, null);
      } catch (Exception e) {
         Assert.fail("Unexpected execption thrown");
      }
   }

   @Test
   public void testSuccessLogsSuccess() {
      BalanceResponse response = new BalanceResponse();

      callback.success(response, null);

      verify(log).info(String.format("Retrofit success: %s", response.getClass().getName()));
   }

   @Test
   public void testFailureWithNullDoesNotThrow() {
      RetrofitError error = RetrofitError.conversionError(null, null, null, null, null);

      try {
         callback.failure(error);
      } catch (Exception e) {
         Assert.fail("Unexpected execption thrown");
      }
   }

   @Test
   public void testFailureSetsLastError() {
      String reason = "reason";
      List<Header> headers = Arrays.asList(new Header("name1", "value1"), new Header("name2", "value2"));
      String body = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\"><html xmlns=\"http://www.w3.org/1999/xhtml\"><body></body></html>";
      Response response = new Response(200, reason, headers, new TypedInputStream("application/json", body.length(), new ByteArrayInputStream(
            body.getBytes())));
      RetrofitError error = RetrofitError.conversionError("https://www.dwolla.com", response, new GsonConverter(new Gson()), null,
            new ConversionException("message"));

      callback.failure(error);

      Assert.assertEquals(
            "Retrofit failure:\nUrl: https://www.dwolla.com\nisNetworkError: false\nMessage: retrofit.http.ConversionException: message\nCause: retrofit.http.ConversionException: message\nStatus code: 200\nReason: reason\nHeaders:\nname1: value1\nname2: value2\nBody: <!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\"><html xmlns=\"http://www.w3.org/1999/xhtml\"><body></body></html>",
            callback.mLastFailure);
   }

   @Test
   public void testFailureLogsMessage() {
      String message = "message";

      callback.failure(message, new TestCallback());

      verify(log).error(String.format("Dwolla API Failure - com.dwolla.java.sdk.DwollaCallbackTest$TestCallback: %s", message));
   }

   private static class TypedInputStream implements TypedInput {
      private final String mimeType;
      private final long length;
      private final InputStream stream;

      private TypedInputStream(String mimeType, long length, InputStream stream) {
         this.mimeType = mimeType;
         this.length = length;
         this.stream = stream;
      }

      @Override
      public String mimeType() {
         return mimeType;
      }

      @Override
      public long length() {
         return length;
      }

      @Override
      public InputStream in() throws IOException {
         return stream;
      }
   }

   private class TestCallback extends DwollaCallback<BalanceResponse> {
      @Override
      public void success(BalanceResponse br, Response r) {
         super.success(br, r);
      }

      @Override
      public void failure(RetrofitError error) {
         super.failure(error);
      }
   }
}
