package com.dwolla.java.sdk;

import com.dwolla.java.sdk.responses.*;
import retrofit.Callback;
import retrofit.http.*;

/**
 * Asynchronous Dwolla API endpoints, see <a href="https://docs.dwolla.com/">docs.dwolla.com</a> for more information.
 */
@SuppressWarnings("UnusedDeclaration")
public interface DwollaServiceAsync {

    /**
     * Balance
     */
    @GET("/balance/")
    void getBalance(
            @Header(Consts.Api.AUTHORIZATION) String oauthToken,
            Callback<BalanceResponse> callback);

    /**
     * Contacts
     */
    @GET("/contacts/nearby")
    void getNearbySpots(
            @Query(Consts.Api.CLIENT_ID) String clientId,
            @Query(Consts.Api.CLIENT_SECRET) String clientSecret,
            @Query(Consts.Api.LATITUDE) double latitude,
            @Query(Consts.Api.LONGITUDE) double longitude,
            @Query(Consts.Api.RANGE) int range,
            @Query(Consts.Api.LIMIT) int limit,
            Callback<NearbySpotsResponse> callback);

    @GET("/contacts/")
        // For types, see Consts.UserContactType
    void getUserContacts(
            @Header(Consts.Api.AUTHORIZATION) String oauthToken,
            @Query(Consts.Api.SEARCH) String search,
            @Query(Consts.Api.TYPES) String types,
            @Query(Consts.Api.LIMIT) int limit,
            Callback<UserContactsResponse> callback);

    /**
     * Funding Sources
     */
    @GET("/fundingsources/{funding_id}")
    void getFundingSourcesById(
            @Header(Consts.Api.AUTHORIZATION) String oauthToken,
            @Path(Consts.Api.FUNDING_ID) String funding_id,
            Callback<FundingSourcesByIdResponse> callback);

    @GET("/fundingsources/")
    void getFundingSourcesListing(
            @Header(Consts.Api.AUTHORIZATION) String oauthToken,
            @Query(Consts.Api.DESTINATION_ID) String destinationId,
            @Query(Consts.Api.DESTINATION_TYPE) String destinationType,
            Callback<FundingSourcesListingResponse> callback);

    @POST("/fundingsources/{funding_id}/deposit")
    void deposit(
            @Header(Consts.Api.AUTHORIZATION) String oauthToken,
			@Body DwollaTypedBytes request,
            @Path(Consts.Api.FUNDING_ID) String funding_id,
            Callback<DepositWithdrawResponse> callback);

    @POST("/fundingsources/{funding_id}/withdraw")
    void withdraw(
            @Header(Consts.Api.AUTHORIZATION) String oauthToken,
            @Body DwollaTypedBytes request,
            @Path(Consts.Api.FUNDING_ID) String funding_id,
            Callback<DepositWithdrawResponse> callback);

    /**
     * Requests
     */
    @GET("/requests/")
    void getRequests(
            @Header(Consts.Api.AUTHORIZATION) String oauthToken,
            @Query(Consts.Api.SKIP) int skip,
            @Query(Consts.Api.LIMIT) int limit,
            Callback<PendingRequestsResponse> callback);

    @GET("/requests/{request_id}")
    void getRequest(
            @Header(Consts.Api.AUTHORIZATION) String oauthToken,
            @Path(Consts.Api.REQUEST_ID) int id,
            Callback<RequestResponse> callback);

    @POST("/requests/")
    void request(
            @Header(Consts.Api.AUTHORIZATION) String oauthToken,
            @Body DwollaTypedBytes request,
            Callback<RequestResponse> callback);

    @POST("/requests/{request_id}/fulfill")
    void fulfillRequest(
            @Header(Consts.Api.AUTHORIZATION) String oauthToken,
            @Body DwollaTypedBytes request,
            @Path(Consts.Api.REQUEST_ID) String id,
            Callback<FulfillRequestResponse> callback);

    @POST("/requests/{request_id}/cancel")
    void cancelRequest(
            @Header(Consts.Api.AUTHORIZATION) String oauthToken,
            @Path(Consts.Api.REQUEST_ID) int id,
            Callback<Response> callback);

    /**
     * Transactions
     */
    @GET("/transactions/")
    // For types, see Consts.TransactionType
    void getTransactions(
            @Header(Consts.Api.AUTHORIZATION) String oauthToken,
            @Query(Consts.Api.CLIENT_ID) String clientId,
            @Query(Consts.Api.CLIENT_SECRET) String clientSecret,
            @Query(Consts.Api.SINCE_DATE) String sinceDate,
            @Query(Consts.Api.TYPES) String types,
            @Query(Consts.Api.LIMIT) int limit,
            @Query(Consts.Api.SKIP) int skip,
            @Query(Consts.Api.GROUP_ID) String groupId,
            Callback<TransactionsResponse> callback);

    @GET("/transactions/{transaction_id}")
    void getTransaction(
            @Header(Consts.Api.AUTHORIZATION) String oauthToken,
            @Path(Consts.Api.TRANSACTION_ID) String transaction_id,
            Callback<TransactionResponse> callback);

    @GET("/transactions/{account_identifier}")
    void getTransaction(
            @Header(Consts.Api.AUTHORIZATION) String oauthToken,
            @Path(Consts.Api.ACCOUNT_ID) int id,
            Callback<TransactionResponse> callback);

    @GET("/transactions/search")
    void searchTransactions(
            @Query(Consts.Api.TOKEN) String oauthToken,
            @Query(Consts.Api.SEARCH_TERM) String searchTerm,
            @Query(Consts.Api.LIMIT) int limit,
            Callback<TransactionSearchResponse> callback);

    @POST("/transactions/send")
    void send(
            @Header(Consts.Api.AUTHORIZATION) String oauthToken,
            @Body DwollaTypedBytes request,
            Callback<SendResponse> callback);

    /**
     * Users
     */
    @GET("/users/")
    void getAccountInformation(
            @Header(Consts.Api.AUTHORIZATION) String oauthToken,
            Callback<AccountInformationResponse> callback);

    @GET("/users/{account_identifier}")
    void getBasicAccountInformation(
            @Path(Consts.Api.ACCOUNT_ID) String accountIdentifier,
            @Query(Consts.Api.CLIENT_ID) String clientId,
            @Query(Consts.Api.CLIENT_SECRET) String clientSecret,
            Callback<BasicAccountInformationResponse> callback);

    @GET("/users/nearby")
    void getNearbyUsers(
            @Query(Consts.Api.CLIENT_ID) String clientId,
            @Query(Consts.Api.CLIENT_SECRET) String clientSecret,
            @Query(Consts.Api.LATITUDE) double latitude,
            @Query(Consts.Api.LONGITUDE) double longitude,
            Callback<NearbyUsersResponse> callback);

    /**
     * MassPay
     */
    @POST("/masspay/")
    void createJob(
            @Header(Consts.Api.AUTHORIZATION) String oauthToken,
            @Body DwollaTypedBytes request,
			Callback<CreateJobResponse> callback);

}
