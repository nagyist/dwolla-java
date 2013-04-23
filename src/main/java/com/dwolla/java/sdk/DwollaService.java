package com.dwolla.java.sdk;

import retrofit.http.Callback;
import retrofit.http.GET;
import retrofit.http.Name;
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
   void getBalance(@Name(Consts.Api.TOKEN) String oauthToken, Callback<BalanceResponse> callback);

   /** Contacts */
   @GET("/contacts/nearby")
   void getNearbySpots(@Name(Consts.Api.CLIENT_ID) String clientId, @Name(Consts.Api.CLIENT_SECRET) String clientSecret,
         @Name(Consts.Api.LATITUDE) double latitude, @Name(Consts.Api.LONGITUDE) double longitude, @Name(Consts.Api.RANGE) int range,
         @Name(Consts.Api.LIMIT) int limit, Callback<NearbySpotsResponse> callback);

   @GET("/contacts/")
   // For types, see Consts.UserContactType
   void getUserContacts(@Name(Consts.Api.TOKEN) String oauthToken, @Name(Consts.Api.SEARCH) String search, @Name(Consts.Api.TYPES) String types,
         @Name(Consts.Api.LIMIT) int limit, Callback<UserContactsResponse> callback);

   /** Funding Sources */
   @GET("/fundingsources/{funding_id}/")
   void getFundingSourcesById(@Name(Consts.Api.TOKEN) String oauthToken, @Name(Consts.Api.FUNDING_ID) String funding_id,
         Callback<FundingSourcesByIdResponse> callback);

   @GET("/fundingsources/")
   void getFundingSourcesListing(@Name(Consts.Api.TOKEN) String oauthToken, Callback<FundingSourcesListingResponse> callback);

   /** Requests */
   @POST("/requests/")
   void request(@SingleEntity DwollaTypedBytes request, Callback<RequestResponse> callback);

   /** Transactions */
   @GET("/transactions/")
// For types, see Consts.TransactionType
   void getTransactions(@Name(Consts.Api.TOKEN) String oauthToken, @Name(Consts.Api.CLIENT_ID) String clientId,
         @Name(Consts.Api.CLIENT_SECRET) String clientSecret, @Name(Consts.Api.SINCE_DATE) String sinceDate, @Name(Consts.Api.TYPES) String types,
         @Name(Consts.Api.LIMIT) int limit, @Name(Consts.Api.SKIP) int skip, @Name(Consts.Api.GROUP_ID) String groupId,
         Callback<TransactionsResponse> callback);

   @POST("/transactions/send")
   void send(@SingleEntity DwollaTypedBytes request, Callback<SendResponse> callback);

   /** Users */
   @GET("/users/")
   void getAccountInformation(@Name(Consts.Api.TOKEN) String oauthToken, Callback<AccountInformationResponse> callback);

   @GET("/users/{account_identifier}")
   void getBasicAccountInformation(@Name(Consts.Api.ACCOUNT_ID) String accountIdentifier, @Name(Consts.Api.CLIENT_ID) String clientId,
         @Name(Consts.Api.CLIENT_SECRET) String clientSecret, Callback<BasicAccountInformationResponse> callback);
}
