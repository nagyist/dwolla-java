package com.dwolla.java.sdk;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.apache.commons.logging.Log;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import retrofit.http.ConversionException;
import retrofit.http.GsonConverter;
import retrofit.http.Header;
import retrofit.http.RetrofitError;

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
         callback.success(null);
      } catch (Exception e) {
         Assert.fail("Unexpected execption thrown");
      }
   }

   @Test
   public void testSuccessLogsSuccess() {
      BalanceResponse response = new BalanceResponse();

      callback.success(response);

      verify(log).info(String.format("Retrofit success: %s", response.getClass().getName()));
   }

   @Test
   public void testFailureWithNullDoesNotThrow() {
      RetrofitError error = RetrofitError.conversionError(null, null, -1, null, null, null, null);

      try {
         callback.failure(error);
      } catch (Exception e) {
         Assert.fail("Unexpected execption thrown");
      }
   }

   @Test
   public void testFailureLogsRetrofitError() {
      Header[] headers = { new Header("name1", "value1"), new Header("name2", "value2") };
      String body = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\n<body>\n</body>\n</html>";
      RetrofitError error = RetrofitError.conversionError("https://www.dwolla.com", new GsonConverter(new Gson()), 500, headers, body.getBytes(),
            BalanceResponse.class, new ConversionException("message"));

      callback.failure(error);

      verify(log).error(
            String.format("Retrofit failure:\nUrl: %s\nStatus code: %d\nHeaders:\n%s: %s\n%s: %s\nBody: %s\nException: %s", error.getUrl(), error
                  .getStatusCode(), headers[0].getName(), headers[0].getValue(), headers[1].getName(), headers[1].getValue(), body, error
                  .getException().toString()));
   }

   @Test
   public void testFailureLogsMessage() {
      String message = "message";

      callback.failure(message);

      verify(log).error(String.format("Dwolla API Failure:\n%s", message));
   }

   private class TestCallback extends DwollaCallback<BalanceResponse> {
      @Override
      public void success(BalanceResponse response) {
         super.success(response);
      }

      @Override
      public void failure(RetrofitError error) {
         super.failure(error);
      }
   }
}
