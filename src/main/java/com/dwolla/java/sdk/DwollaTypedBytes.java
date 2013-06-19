package com.dwolla.java.sdk;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import com.google.gson.Gson;

import retrofit.mime.TypedOutput;

public class DwollaTypedBytes implements TypedOutput {

   public static final String UTF_8 = "UTF-8";
   static final String mimeType = "application/json";
   private final byte[] jsonBytes;

   public DwollaTypedBytes(Gson gson, Object object) {
      try {
         jsonBytes = gson.toJson(object).getBytes(UTF_8);
      } catch (UnsupportedEncodingException e) {
         throw new IllegalStateException(UTF_8 + " encoding does not exist.");
      }
   }

   @Override
   public String fileName() {
      return "DwollaTypedBytesFileName";
   }

   @Override
   public String mimeType() {
      return mimeType;
   }

   @Override
   public long length() {
      return jsonBytes.length;
   }

   @Override
   public void writeTo(OutputStream out) throws IOException {
      out.write(jsonBytes);
   }

}
