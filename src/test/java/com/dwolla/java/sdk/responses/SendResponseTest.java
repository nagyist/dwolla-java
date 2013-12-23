package com.dwolla.java.sdk.responses;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class SendResponseTest {

    @Test
    public void testConversionToJson() {
        SendResponse response = createResponseObject();

        String actual = new Gson().toJson(response);

        Assert.assertEquals(getJsonString(response), actual);
    }

    @Test
    public void testConversionFromJson() {
        SendResponse expected = createResponseObject();

        SendResponse actual = new Gson().fromJson(getJsonString(expected), SendResponse.class);

        Assert.assertEquals(expected.Response, actual.Response);
    }

    private SendResponse createResponseObject() {
        SendResponse response = new SendResponse();
        response.Response = 123;
        return response;
    }

    private String getJsonString(SendResponse obj) {
        return String.format("{\"Response\":%d,\"Success\":false}", obj.Response);
    }

}
