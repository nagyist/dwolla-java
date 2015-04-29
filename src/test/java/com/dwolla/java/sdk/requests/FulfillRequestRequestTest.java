package com.dwolla.java.sdk.requests;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class FulfillRequestRequestTest {

    @Test
    public void testConversionToJson() {
        FulfillRequestRequest response = createRequestObject();

        String actual = new Gson().toJson(response);

        Assert.assertEquals(getJsonString(response), actual);
    }

    @Test
    public void testConversionFromJson() {
        FulfillRequestRequest expected = createRequestObject();

        FulfillRequestRequest actual = new Gson().fromJson(getJsonString(expected), FulfillRequestRequest.class);

        Assert.assertEquals(expected, actual);
    }

    private FulfillRequestRequest createRequestObject() {
        return new FulfillRequestRequest("123", "456", 1.11, false, "notes", "bank");
    }

    private String getJsonString(FulfillRequestRequest obj) {
        return "{\"pin\":\"123\",\"request_id\":\"456\",\"amount\":1.11,\"assumeCosts\":false,\"notes\":\"notes\",\"fundsSource\":\"bank\"}";
    }

}
