package com.dwolla.java.sdk;

import static com.dwolla.java.sdk.DwollaTypedBytes.UTF_8;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import retrofit.http.Callback;
import retrofit.http.RetrofitError;

public abstract class DwollaCallback<T> implements Callback<T> {
   private Log log = LogFactory.getLog(DwollaCallback.class);

   @Override
   public void success(T t) {
      if (t != null) {
         log.info(new StringBuilder("Retrofit success: ").append(t.getClass().getName()).toString());
      }
   }

   @Override
   public void failure(RetrofitError error) {
      StringBuilder strBuilder = new StringBuilder("Retrofit failure:\nUrl: ").append(error.getUrl()).append("\nStatus code: ")
            .append(error.getStatusCode()).append("\nHeaders: ").append(error.getHeaders()).append("\nBody: ");

      try {
         strBuilder.append(new String(Base64.encodeBase64(error.getRawBody()), UTF_8));
      } catch (UnsupportedEncodingException e) {
         strBuilder.append("\nError encoding body");
      }

      log.error(strBuilder.toString());
   }

   public void failure(String message) {
      log.error(new StringBuilder("Dwolla API Failure:\n").append(message).toString());
   }

}
