package com.dwolla.java.sdk;

import com.dwolla.java.sdk.responses.*;
import retrofit.http.*;

/**
 * Synchronous Dwolla API endpoints, see <a href="https://developers.dwolla.com/dev/docs/">developers.dwolla.com/dev/docs</a> for more information.
 */
@SuppressWarnings("UnusedDeclaration")
public interface DwollaServiceSync {

    /**
     * Balance
     */
    @GET("/balance/")
    BalanceResponse getBalance(@Query(Consts.Api.TOKEN) String oauthToken);

    /**
     * Contacts
     */
    @GET("/contacts/nearby")
    NearbySpotsResponse getNearbySpots(@Query(Consts.Api.CLIENT_ID) String clientId,
                                       @Query(Consts.Api.CLIENT_SECRET) String clientSecret, @Query(Consts.Api.LATITUDE) double latitude,
                                       @Query(Consts.Api.LONGITUDE) double longitude, @Query(Consts.Api.RANGE) int range,
                                       @Query(Consts.Api.LIMIT) int limit);

    @GET("/contacts/")
        // For types, see Consts.UserContactType
    UserContactsResponse getUserContacts(@Query(Consts.Api.TOKEN) String oauthToken,
                                         @Query(Consts.Api.SEARCH) String search, @Query(Consts.Api.TYPES) String types,
                                         @Query(Consts.Api.LIMIT) int limit);

    /**
     * Funding Sources
     */
    @GET("/fundingsources/{funding_id}")
    FundingSourcesByIdResponse getFundingSourcesById(@Query(Consts.Api.TOKEN) String oauthToken,
                                                     @Path(Consts.Api.FUNDING_ID) String funding_id);

    @GET("/fundingsources/")
    FundingSourcesListingResponse getFundingSourcesListing(@Query(Consts.Api.TOKEN) String oauthToken);

    @POST("/fundingsources/{funding_id}/deposit")
    DepositWithdrawResponse deposit(@Body DwollaTypedBytes request, @Path(Consts.Api.FUNDING_ID) String funding_id);

    @POST("/fundingsources/{funding_id}/withdraw")
    DepositWithdrawResponse withdraw(@Body DwollaTypedBytes request, @Path(Consts.Api.FUNDING_ID) String funding_id);

    /**
     * Requests
     */
    @GET("/requests/")
    PendingRequestsResponse getPendingRequests(@Query(Consts.Api.TOKEN) String oauthToken);

    @POST("/requests/{request_id}/fulfill")
    FulfillRequestResponse fulfillRequest(@Body DwollaTypedBytes request,
                                          @Path(Consts.Api.REQUEST_ID) String request_id);

    @POST("/requests/")
    RequestResponse request(@Body DwollaTypedBytes request);

    /**
     * Transactions
     */
    @GET("/transactions/")
    // For types, see Consts.TransactionType
    TransactionsResponse getTransactions(@Query(Consts.Api.TOKEN) String oauthToken,
                                         @Query(Consts.Api.CLIENT_ID) String clientId, @Query(Consts.Api.CLIENT_SECRET) String clientSecret,
                                         @Query(Consts.Api.SINCE_DATE) String sinceDate, @Query(Consts.Api.TYPES) String types,
                                         @Query(Consts.Api.LIMIT) int limit, @Query(Consts.Api.SKIP) int skip,
                                         @Query(Consts.Api.GROUP_ID) String groupId);

    @GET("/transactions/{transaction_id}")
    TransactionResponse getTransaction(@Query(Consts.Api.TOKEN) String oauthToken, @Path(Consts.Api.TRANSACTION_ID) String transaction_id);


    @POST("/transactions/send")
    SendResponse send(@Body DwollaTypedBytes request);

    /**
     * Users
     */
    @GET("/users/")
    AccountInformationResponse getAccountInformation(@Query(Consts.Api.TOKEN) String oauthToken);

    @GET("/users/{account_identifier}")
    BasicAccountInformationResponse getBasicAccountInformation(@Path(Consts.Api.ACCOUNT_ID) String accountIdentifier,
                                                               @Query(Consts.Api.CLIENT_ID) String clientId,
                                                               @Query(Consts.Api.CLIENT_SECRET) String clientSecret);

    @GET("/users/nearby")
    NearbyUsersResponse getNearbyUsers(@Query(Consts.Api.CLIENT_ID) String clientId,
                                       @Query(Consts.Api.CLIENT_SECRET) String clientSecret, @Query(Consts.Api.LATITUDE) double latitude,
                                       @Query(Consts.Api.LONGITUDE) double longitude);

}
