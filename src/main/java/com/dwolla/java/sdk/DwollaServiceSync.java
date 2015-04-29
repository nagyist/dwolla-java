package com.dwolla.java.sdk;

import com.dwolla.java.sdk.responses.*;
import retrofit.http.*;

/**
 * Synchronous Dwolla API endpoints, see <a href="https://docs.dwolla.com/">docs.dwolla.com</a> for more information.
 */
@SuppressWarnings("UnusedDeclaration")
public interface DwollaServiceSync {

    /**
     * Balance
     */
    @GET("/balance/")
    BalanceResponse getBalance(
            @Header(Consts.Api.AUTHORIZATION) String oauthToken);

    /**
     * Contacts
     */
    @GET("/contacts/nearby")
    NearbySpotsResponse getNearbySpots(
            @Query(Consts.Api.CLIENT_ID) String clientId,
            @Query(Consts.Api.CLIENT_SECRET) String clientSecret,
            @Query(Consts.Api.LATITUDE) double latitude,
            @Query(Consts.Api.LONGITUDE) double longitude,
            @Query(Consts.Api.RANGE) int range,
            @Query(Consts.Api.LIMIT) int limit);

    @GET("/contacts/")
        // For types, see Consts.UserContactType
    UserContactsResponse getUserContacts(
            @Header(Consts.Api.AUTHORIZATION) String oauthToken,
            @Query(Consts.Api.SEARCH) String search,
            @Query(Consts.Api.TYPES) String types,
            @Query(Consts.Api.LIMIT) int limit);

    /**
     * Funding Sources
     */
    @GET("/fundingsources/{funding_id}")
    FundingSourcesByIdResponse getFundingSourcesById(
            @Header(Consts.Api.AUTHORIZATION) String oauthToken,
            @Path(Consts.Api.FUNDING_ID) String funding_id);

    @GET("/fundingsources/")
    FundingSourcesListingResponse getFundingSourcesListing(
            @Header(Consts.Api.AUTHORIZATION) String oauthToken,
            @Query(Consts.Api.DESTINATION_ID) String destinationId,
            @Query(Consts.Api.DESTINATION_TYPE) String destinationType);

    @POST("/fundingsources/{funding_id}/deposit")
    DepositWithdrawResponse deposit(
            @Header(Consts.Api.AUTHORIZATION) String oauthToken,
            @Body DwollaTypedBytes request,
            @Path(Consts.Api.FUNDING_ID) String funding_id);

    @POST("/fundingsources/{funding_id}/withdraw")
    DepositWithdrawResponse withdraw(
            @Header(Consts.Api.AUTHORIZATION) String oauthToken,
            @Body DwollaTypedBytes request,
            @Path(Consts.Api.FUNDING_ID) String funding_id);

    /**
     * Requests
     */
    @GET("/requests/")
    PendingRequestsResponse getRequests(
            @Header(Consts.Api.AUTHORIZATION) String oauthToken,
            @Query(Consts.Api.SKIP) int skip,
            @Query(Consts.Api.LIMIT) int limit);

    @GET("/requests/{request_id}")
    PendingRequestResponse getRequest(
            @Header(Consts.Api.AUTHORIZATION) String oauthToken,
            @Path(Consts.Api.REQUEST_ID) int id);

    @POST("/requests/")
    RequestResponse request(
            @Header(Consts.Api.AUTHORIZATION) String oauthToken,
            @Body DwollaTypedBytes request);

    @POST("/requests/{request_id}/fulfill")
    FulfillRequestResponse fulfillRequest(
            @Header(Consts.Api.AUTHORIZATION) String oauthToken,
            @Body DwollaTypedBytes request,
            @Path(Consts.Api.REQUEST_ID) String id);

    @POST("/requests/{request_id}/cancel")
    Response cancelRequest(
            @Header(Consts.Api.AUTHORIZATION) String oauthToken,
            @Path(Consts.Api.REQUEST_ID) int id);

    /**
     * Transactions
     */
    @GET("/transactions/")
    // For types, see Consts.TransactionType
    TransactionsResponse getTransactions(
            @Header(Consts.Api.AUTHORIZATION) String oauthToken,
            @Query(Consts.Api.CLIENT_ID) String clientId,
            @Query(Consts.Api.CLIENT_SECRET) String clientSecret,
            @Query(Consts.Api.SINCE_DATE) String sinceDate,
            @Query(Consts.Api.TYPES) String types,
            @Query(Consts.Api.LIMIT) int limit,
            @Query(Consts.Api.SKIP) int skip,
            @Query(Consts.Api.GROUP_ID) String groupId);

    @GET("/transactions/{transaction_id}")
    TransactionResponse getTransaction(
            @Header(Consts.Api.AUTHORIZATION) String oauthToken,
            @Path(Consts.Api.TRANSACTION_ID) String transaction_id);

    @GET("/transactions/{account_identifier}")
    TransactionResponse getTransaction(
            @Header(Consts.Api.AUTHORIZATION) String oauthToken,
            @Path(Consts.Api.ACCOUNT_ID) int id);

    @GET("/transactions/search")
    TransactionSearchResponse searchTransactions(
            @Header(Consts.Api.AUTHORIZATION) String oauthToken,
            @Query(Consts.Api.SEARCH_TERM) String searchTerm,
            @Query(Consts.Api.LIMIT) int limit);

    @POST("/transactions/send")
    SendResponse send(
            @Header(Consts.Api.AUTHORIZATION) String oauthToken,
            @Body DwollaTypedBytes request);

    /**
     * Users
     */
    @GET("/users/")
    AccountInformationResponse getAccountInformation(
            @Header(Consts.Api.AUTHORIZATION) String oauthToken);

    @GET("/users/{account_identifier}")
    BasicAccountInformationResponse getBasicAccountInformation(
            @Path(Consts.Api.ACCOUNT_ID) String accountId,
            @Query(Consts.Api.CLIENT_ID) String clientId,
            @Query(Consts.Api.CLIENT_SECRET) String clientSecret);

    @GET("/users/nearby")
    NearbyUsersResponse getNearbyUsers(
            @Query(Consts.Api.CLIENT_ID) String clientId,
            @Query(Consts.Api.CLIENT_SECRET) String clientSecret,
            @Query(Consts.Api.LATITUDE) double latitude,
            @Query(Consts.Api.LONGITUDE) double longitude);

    /**
     * MassPay
     */
    @POST("/masspay/")
    CreateJobResponse createJob(
            @Header(Consts.Api.AUTHORIZATION) String oauthToken,
            @Body DwollaTypedBytes request);

}
