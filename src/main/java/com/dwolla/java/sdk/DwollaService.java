package com.dwolla.java.sdk;

import javax.inject.Named;

import retrofit.http.Callback;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.SingleEntity;

public interface DwollaService {
   @GET("balance/")
   void balance(@Named("oauth_token") String oauthToken, Callback<DwollaBalance> callback);

   @GET("users/")
   void accountInformation(@Named("oauth_token") String oauthToken, Callback<DwollaAccountInformation> callback);

   @POST("transactions/send")
   void send(@SingleEntity DwollaTypeBytes send, Callback<DwollaBalance> callback);
}
