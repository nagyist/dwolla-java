package com.dwolla.java.sdk;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

import retrofit.http.Callback;
import retrofit.http.RetrofitError;
import android.util.Log;

public abstract class DwollaCallback<T> implements Callback<T> {

   @Override
   public void success(T t) {
      if (t != null) {
         String name = t.getClass().getName();
         Log.i("DwollaCallback", name != "" ? name : "Success");
      }
   }

   @Override
   public void failure(RetrofitError error) {
      StringBuilder strBuilder = new StringBuilder("RetrofitError:\nUrl: ");
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

      Log.e("DwollaCallback", strBuilder.toString());
   }

   public void failure(String message) {
      StringBuilder strBuilder = new StringBuilder("Dwolla API Failure:\n");
      strBuilder.append(message);
      Log.e("DwollaCallback", strBuilder.toString());
   }

}
