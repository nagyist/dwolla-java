package com.dwolla.java.sdk;

import javax.inject.Named;

import retrofit.http.Callback;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.SingleEntity;

/**
 * Dwolla API endpoints, see <a href="https://developers.dwolla.com/dev/docs/">developers.dwolla.com/dev/docs</a> for more information.
 * */
public interface DwollaService {
   /** Balance */
   @GET("balance/")
   void getBalance(@Named("oauth_token") String oauthToken, Callback<BalanceResponse> callback);

   /** Funding Sources */
   // Coming soon

   /** Requests */
   // Coming soon

   /** Transactions */
   @GET("transactions/")
   void getTransactions(@Named("oauth_token") String oauthToken, @Named("client_id") String clientId, @Named("client_secret") String clientSecret,
         @Named("sinceDate") String sinceDate, @Named("types") String types, @Named("limit") int limit, @Named("skip") int skip,
         @Named("groupId") String groupId, Callback<TransactionsResponse> callback);

   @POST("transactions/send")
   void send(@SingleEntity DwollaTypedBytes send, Callback<SendResponse> callback);

   /** Users */
   @GET("users/")
   void getAccountInformation(@Named("oauth_token") String oauthToken, Callback<AccountInformationResponse> callback);

   @GET("users/{account_identifier}")
   void getBasicInformation(@Named("account_identifier") String accountIdentifier, @Named("client_id") String clientId,
         @Named("client_secret") String clientSecret, Callback<BasicInformationResponse> callback);
}
