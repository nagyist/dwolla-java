package com.dwolla.java.sdk;

import com.dwolla.java.sdk.responses.TokenResponse;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Synchronous Dwolla OAuth endpoints, see <a href="https://docs.dwolla.com/#oauth">docs.dwolla.com</a> for more information.
 */
@SuppressWarnings("UnusedDeclaration")
public interface OAuthServiceSync {

    @POST("/token")
    TokenResponse getToken(@Body DwollaTypedBytes request);

}