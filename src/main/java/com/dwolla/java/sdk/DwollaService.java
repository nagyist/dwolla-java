package com.dwolla.java.sdk;

import javax.inject.Named;

import retrofit.http.Callback;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.SingleEntity;

import com.dwolla.java.sdk.responses.AccountInformationResponse;
import com.dwolla.java.sdk.responses.BalanceResponse;
import com.dwolla.java.sdk.responses.BasicAccountInformationResponse;
import com.dwolla.java.sdk.responses.FundingSourcesByIdResponse;
import com.dwolla.java.sdk.responses.FundingSourcesListingResponse;
import com.dwolla.java.sdk.responses.NearbySpotsResponse;
import com.dwolla.java.sdk.responses.RequestResponse;
import com.dwolla.java.sdk.responses.SendResponse;
import com.dwolla.java.sdk.responses.TransactionsResponse;
import com.dwolla.java.sdk.responses.UserContactsResponse;

/**
 * Dwolla API endpoints, see <a href="https://developers.dwolla.com/dev/docs/">developers.dwolla.com/dev/docs</a> for more information.
 * */
public interface DwollaService {
   /** Balance */
   @GET("/balance/")
   void getBalance(@Named(Consts.Api.TOKEN) String oauthToken, Callback<BalanceResponse> callback);

   /** Contacts */
   @GET("/contacts/nearby")
   void getNearbySpots(@Named(Consts.Api.CLIENT_ID) String clientId, @Named(Consts.Api.CLIENT_SECRET) String clientSecret,
         @Named(Consts.Api.LATITUDE) double latitude, @Named(Consts.Api.LONGITUDE) double longitude, @Named(Consts.Api.RANGE) int range,
         @Named(Consts.Api.LIMIT) int limit, Callback<NearbySpotsResponse> callback);

   @GET("/contacts/")
   void getUserContacts(@Named(Consts.Api.TOKEN) String oauthToken, @Named(Consts.Api.SEARCH) String search, @Named(Consts.Api.TYPES) String types,
         @Named(Consts.Api.LIMIT) int limit, Callback<UserContactsResponse> callback);

   /** Funding Sources */
   @GET("/fundingsources/{funding_id}/")
   void getFundingSourcesById(@Named(Consts.Api.TOKEN) String oauthToken, @Named(Consts.Api.FUNDING_ID) String funding_id,
         Callback<FundingSourcesByIdResponse> callback);

   @GET("/fundingsources/")
   void getFundingSourcesListing(@Named(Consts.Api.TOKEN) String oauthToken, Callback<FundingSourcesListingResponse> callback);

   /** Requests */
   @POST("/requests/")
   void request(@SingleEntity DwollaTypedBytes request, Callback<RequestResponse> callback);

   /** Transactions */
   @GET("/transactions/")
   void getTransactions(@Named(Consts.Api.TOKEN) String oauthToken, @Named(Consts.Api.CLIENT_ID) String clientId,
         @Named(Consts.Api.CLIENT_SECRET) String clientSecret, @Named(Consts.Api.SINCE_DATE) String sinceDate, @Named(Consts.Api.TYPES) String types,
         @Named(Consts.Api.LIMIT) int limit, @Named(Consts.Api.SKIP) int skip, @Named(Consts.Api.GROUP_ID) String groupId,
         Callback<TransactionsResponse> callback);

   @POST("/transactions/send")
   void send(@SingleEntity DwollaTypedBytes request, Callback<SendResponse> callback);

   /** Users */
   @GET("/users/")
   void getAccountInformation(@Named(Consts.Api.TOKEN) String oauthToken, Callback<AccountInformationResponse> callback);

   @GET("/users/{account_identifier}")
   void getBasicAccountInformation(@Named(Consts.Api.ACCOUNT_ID) String accountIdentifier, @Named(Consts.Api.CLIENT_ID) String clientId,
         @Named(Consts.Api.CLIENT_SECRET) String clientSecret, Callback<BasicAccountInformationResponse> callback);
}
