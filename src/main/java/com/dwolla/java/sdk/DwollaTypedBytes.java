package com.dwolla.java.sdk;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import retrofit.io.MimeType;
import retrofit.io.TypedBytes;

import com.google.gson.Gson;

public class DwollaTypedBytes implements TypedBytes {
   static final String UTF_8 = "UTF-8";
   static final MimeType JSON = new MimeType("application/json", "json");
   private final byte[] jsonBytes;

   public DwollaTypedBytes(Gson gson, Object object) {
      try {
         jsonBytes = gson.toJson(object).getBytes(UTF_8);
      } catch (UnsupportedEncodingException e) {
         throw new IllegalStateException(UTF_8 + " encoding does not exist.");
      }
   }

   @Override
   public MimeType mimeType() {
      return JSON;
   }

   @Override
   public int length() {
      return jsonBytes.length;
   }

   @Override
   public void writeTo(OutputStream out) throws IOException {
      out.write(jsonBytes);
   }
}
