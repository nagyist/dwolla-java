package com.dwolla.java.sdk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import retrofit.http.Callback;
import retrofit.http.Header;
import retrofit.http.RetrofitError;
import retrofit.http.client.Response;

public abstract class DwollaCallback<T> implements Callback<T> {
   private Log log = LogFactory.getLog(DwollaCallback.class);
   protected String mLastFailure = "";

   public void setLog(Log log) {
      if (log != null) {
         this.log = log;
      }
   }

   @Override
   public void success(T t, Response response) {
      if (t != null) {
         log.info(new StringBuilder("Retrofit success: ").append(t.getClass().getName()).toString());
      }
   }

   @Override
   public void failure(RetrofitError error) {
      Response response = error.getResponse();
      StringBuilder sb = new StringBuilder("Retrofit failure:\nUrl: ").append(error.getUrl());

      sb.append("\nisNetworkError: ").append(error.isNetworkError());
      sb.append("\nMessage: ").append(error.getMessage());
      sb.append("\nCause: ").append(error.getCause());

      if (response != null) {
         if (response.getStatus() != 0) {
            sb.append("\nStatus code: ").append(response.getStatus());
         }

         sb.append("\nReason: ").append(response.getReason());

         if (response.getHeaders() != null) {
            sb.append("\nHeaders:");
            for (Header header : response.getHeaders()) {
               sb.append("\n").append(header.toString());
            }
         }

         if (response.getBody() != null) {
            sb.append("\nBody: ");
            try {
               BufferedReader br = new BufferedReader(new InputStreamReader(response.getBody().in()));
               String line;
               while ((line = br.readLine()) != null) {
                  sb.append(line);
               }
               br.close();
            } catch (IOException e) {
               sb.append("Error parsing body");
            }
         }
      }

      mLastFailure = sb.toString();
      // Don't log since it may contain sensitive user information
   }

   public void failure(String message) {
      log.error(new StringBuilder("Dwolla API Failure: ").append(message).toString());
   }

}
