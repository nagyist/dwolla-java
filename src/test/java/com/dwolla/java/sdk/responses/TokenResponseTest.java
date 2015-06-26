package com.dwolla.java.sdk.responses;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class TokenResponseTest {

    @Test
    public void testConversionToJson() {
        TokenResponse response = createResponseObject();

        String actual = new Gson().toJson(response);

        Assert.assertEquals(getJsonString(), actual);
    }

    @Test
    public void testConversionFromJson() {
        TokenResponse expected = createResponseObject();

        TokenResponse actual = new Gson().fromJson(getJsonString(), TokenResponse.class);

        Assert.assertEquals(expected, actual);
    }

    private TokenResponse createResponseObject() {
        TokenResponse response = new TokenResponse();
        response.access_token = "accessToken";
        response.expires_in = 123;
        response.refresh_token = "refreshToken";
        response.refresh_expires_in = 456;
        response.token_type = "tokenType";
        response.error = "error";
        response.error_description = "errorDescription";
        return response;
    }

    private String getJsonString() {
        return "{\"access_token\":\"accessToken\",\"expires_in\":123,\"refresh_token\":\"refreshToken\",\"refresh_expires_in\":456,\"token_type\":\"tokenType\",\"error\":\"error\",\"error_description\":\"errorDescription\"}";
    }

}
