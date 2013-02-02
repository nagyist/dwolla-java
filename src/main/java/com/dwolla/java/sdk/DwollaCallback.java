package com.dwolla.java.sdk;

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
         StringBuilder strBuilder = new StringBuilder("Retrofit success: ");
         strBuilder.append(t.getClass().getName());
         log.info(strBuilder.toString());
      }
   }

   @Override
   public void failure(RetrofitError error) {
      StringBuilder strBuilder = new StringBuilder("Retrofit failure:\nUrl: ");
      strBuilder.append(error.getUrl());
      strBuilder.append("\nStatus code: ");
      strBuilder.append(error.getStatusCode());
      strBuilder.append("\nHeaders: ");
      strBuilder.append(error.getHeaders());
      strBuilder.append("\nBody: ");

      String body;
      try {
         body = new String(Base64.encodeBase64(error.getRawBody()), "US-ASCII");
         strBuilder.append(body);
      } catch (UnsupportedEncodingException e) {
         strBuilder.append("\nError encoding body");
      }

      log.error(strBuilder.toString());
   }

   public void failure(String message) {
      StringBuilder strBuilder = new StringBuilder("Dwolla API Failure:\n");
      strBuilder.append(message);
      log.error(strBuilder.toString());
   }

}
