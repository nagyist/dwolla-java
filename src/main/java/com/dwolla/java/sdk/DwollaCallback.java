package com.dwolla.java.sdk;

import static com.dwolla.java.sdk.DwollaTypedBytes.UTF_8;

import java.io.UnsupportedEncodingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import retrofit.http.Callback;
import retrofit.http.Header;
import retrofit.http.RetrofitError;

public abstract class DwollaCallback<T> implements Callback<T> {
   private Log log = LogFactory.getLog(DwollaCallback.class);
   protected String mLastFailure = "";

   public void setLog(Log log) {
      if (log != null) {
         this.log = log;
      }
   }

   @Override
   public void success(T t) {
      if (t != null) {
         log.info(new StringBuilder("Retrofit success: ").append(t.getClass().getName()).toString());
      }
   }

   @Override
   public void failure(RetrofitError error) {
      StringBuilder sb = new StringBuilder("Retrofit failure:\nUrl: ").append(error.getUrl());

      if (error.getStatusCode() != 0) {
         sb.append("\nStatus code: ").append(error.getStatusCode());
      }

      if (error.getHeaders() != null) {
         sb.append("\nHeaders:");
         for (Header header : error.getHeaders()) {
            sb.append("\n").append(header.toString());
         }
      }

      if (error.getRawBody() != null) {
         sb.append("\nBody: ");
         try {
            sb.append(new String(error.getRawBody(), UTF_8));
         } catch (UnsupportedEncodingException e) {
            sb.append("Error parsing body");
         }
      }

      if (error.getException() != null) {
         sb.append("\nException: ");
         sb.append(error.getException().toString());
      }

      mLastFailure = sb.toString();
      // Don't log since it may contain sensitive user information
   }

   public void failure(String message) {
      log.error(new StringBuilder("Dwolla API Failure: ").append(message).toString());
   }

}
