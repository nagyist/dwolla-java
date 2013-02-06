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
      StringBuilder strBuilder = new StringBuilder("Retrofit failure:\nUrl: ").append(error.getUrl()).append("\nStatus code: ")
            .append(error.getStatusCode());

      if (error.getHeaders() != null) {
         strBuilder.append("\nHeaders:");
         for (Header header : error.getHeaders()) {
            strBuilder.append("\n").append(header.toString());
         }
      }

      if (error.getRawBody() != null) {
         strBuilder.append("\nBody: ");
         try {
            strBuilder.append(new String(error.getRawBody(), UTF_8));
         } catch (UnsupportedEncodingException e) {
            strBuilder.append("Error encoding body");
         }
      }

      if (error.getException() != null) {
         strBuilder.append("\nException: ");
         strBuilder.append(error.getException().toString());
      }

      log.error(strBuilder.toString());
   }

   public void failure(String message) {
      log.error(new StringBuilder("Dwolla API Failure:\n").append(message).toString());
   }

}
