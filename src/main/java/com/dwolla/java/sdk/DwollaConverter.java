package com.dwolla.java.sdk;

import static com.dwolla.java.sdk.DwollaTypedBytes.UTF_8;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

import retrofit.http.ConversionException;
import retrofit.http.Converter;
import retrofit.io.TypedBytes;

import com.dwolla.java.sdk.DwollaAccountInformation.AccountInformation;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

public class DwollaConverter implements Converter {

   private final Gson gson;

   public DwollaConverter(Gson gson) {
      this.gson = gson;
   }

   @Override
   public Object to(byte[] body, Type type) throws ConversionException {
      try {
         InputStreamReader isr = new InputStreamReader(new ByteArrayInputStream(body), UTF_8);

         JsonParser parser = new JsonParser();
         JsonArray array = parser.parse(isr).getAsJsonArray();

         DwollaAccountInformation ai = (DwollaAccountInformation) type;

         ai.Success = gson.fromJson(array.get(0), boolean.class);
         ai.Response = gson.fromJson(array.get(1), AccountInformation.class);
         ai.Message = gson.fromJson(array.get(2), String.class);

         return ai;
      } catch (IOException e) {
         throw new ConversionException(e);
      } catch (JsonParseException e) {
         throw new ConversionException(e);
      }
   }

   @Override
   public TypedBytes from(Object object) {
      return new DwollaTypedBytes(gson, object);
   }
}
