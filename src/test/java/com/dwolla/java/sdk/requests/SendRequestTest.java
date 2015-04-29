package com.dwolla.java.sdk.requests;

import com.dwolla.java.sdk.models.AdditionalFee;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class SendRequestTest {

    @Test
    public void testConversionToJson() {
        SendRequest response = createRequestObject();

        String actual = new Gson().toJson(response);

        Assert.assertEquals(getJsonString(response), actual);
    }

    @Test
    public void testConversionFromJson() {
        SendRequest expected = createRequestObject();

        SendRequest actual = new Gson().fromJson(getJsonString(expected), SendRequest.class);

        Assert.assertEquals(expected, actual);
    }

    private SendRequest createRequestObject() {
        AdditionalFee[] fees = {new AdditionalFee("812-000-0001", 0.01), new AdditionalFee("812-000-0002", 0.02)};
        Map<String, String> metadata = new HashMap<String, String>();
        metadata.put("dog", "cat");
        return new SendRequest("123", "812-000-0000", 1.11, true, "Dwolla", "0.05", "Notes", "Balance", fees, metadata);
    }

    private String getJsonString(SendRequest obj) {
        return "{\"pin\":\"123\",\"destinationId\":\"812-000-0000\",\"amount\":1.11,\"assumeCosts\":true,\"destinationType\":\"Dwolla\",\"facilitatorAmount\":\"0.05\",\"notes\":\"Notes\",\"fundsSource\":\"Balance\",\"additionalFees\":[{\"destinationId\":\"812-000-0001\",\"amount\":0.01},{\"destinationId\":\"812-000-0002\",\"amount\":0.02}],\"metadata\":{\"dog\":\"cat\"}}";
    }

}
