package com.dwolla.java.sdk.responses;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class TokenResponseTest {

    @Test
    public void testConversionToJson() {
        TokenResponse response = createResponseObject();

        String actual = new Gson().toJson(response);

        Assert.assertEquals(getJsonString(response), actual);
    }

    @Test
    public void testConversionFromJson() {
        TokenResponse expected = createResponseObject();

        TokenResponse actual = new Gson().fromJson(getJsonString(expected), TokenResponse.class);

        Assert.assertEquals(expected, actual);
    }

    private TokenResponse createResponseObject() {
        TokenResponse response = new TokenResponse();
        response.access_token = "accessToken";
        response.expires_in = 123;
        response.refresh_token = "refreshToken";
        response.refresh_expires_in = 456;
        response.token_type = "tokenType";
        return response;
    }

    private String getJsonString(TokenResponse obj) {
        return String.format("{\"access_token\":\"%s\",\"expires_in\":%d,\"refresh_token\":\"%s\",\"refresh_expires_in\":%d,\"token_type\":\"%s\"}",
                obj.access_token, obj.expires_in, obj.refresh_token, obj.refresh_expires_in, obj.token_type);
    }

}
