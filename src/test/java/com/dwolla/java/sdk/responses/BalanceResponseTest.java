package com.dwolla.java.sdk.responses;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class BalanceResponseTest {

    @Test
    public void testConversionToJson() {
        BalanceResponse response = createResponseObject();

        String actual = new Gson().toJson(response);

        Assert.assertEquals(getJsonString(response), actual);
    }

    @Test
    public void testConversionFromJson() {
        BalanceResponse expected = createResponseObject();

        BalanceResponse actual = new Gson().fromJson(getJsonString(expected), BalanceResponse.class);

        Assert.assertEquals(expected, actual);
    }

    private BalanceResponse createResponseObject() {
        BalanceResponse response = new BalanceResponse();
        response.Response = 1234.56;
        return response;
    }

    private String getJsonString(BalanceResponse obj) {
        return String.format("{\"Response\":%.2f,\"Success\":false}", obj.Response);
    }

}
