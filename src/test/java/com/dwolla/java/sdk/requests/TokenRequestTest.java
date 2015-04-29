package com.dwolla.java.sdk.requests;

import com.dwolla.java.sdk.models.AdditionalFee;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class TokenRequestTest {

    @Test
    public void testConversionToJson() {
        TokenRequest response = createRequestObject();

        String actual = new Gson().toJson(response);

        Assert.assertEquals(getJsonString(response), actual);
    }

    @Test
    public void testConversionFromJson() {
        TokenRequest expected = createRequestObject();

        TokenRequest actual = new Gson().fromJson(getJsonString(expected), TokenRequest.class);

        Assert.assertEquals(expected, actual);
    }

    private TokenRequest createRequestObject() {
        return new TokenRequest("clientId", "clientSecret", "grantType", "redirectUri", "code");
    }

    private String getJsonString(TokenRequest obj) {
        return String.format("{\"client_id\":\"%s\",\"client_secret\":\"%s\",\"grant_type\":\"%s\",\"redirect_uri\":\"%s\",\"code\":\"%s\"}",
            obj.client_id, obj.client_secret, obj.grant_type, obj.redirect_uri, obj.code);
    }

}
