package com.dwolla.java.sdk.requests;

import com.dwolla.java.sdk.models.AdditionalFee;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

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
        return new SendRequest("123abc", "123", "812-000-0000", 1.11, true, "Dwolla", "0.05", "Notes", "Balance", fees);
    }

    private String getJsonString(SendRequest obj) {
        return String
                .format(
                        "{\"oauth_token\":\"%s\",\"pin\":\"%s\",\"destinationId\":\"%s\",\"amount\":%.2f,\"assumeCosts\":%b,\"destinationType\":\"%s\",\"facilitatorAmount\":\"%s\",\"notes\":\"%s\",\"fundsSource\":\"%s\",\"additionalFees\":[{\"destinationId\":\"%s\",\"amount\":%.2f},{\"destinationId\":\"%s\",\"amount\":%.2f}]}",
                        obj.oauth_token, obj.pin, obj.destinationId, obj.amount, obj.assumeCosts, obj.destinationType, obj.facilitatorAmount, obj.notes,
                        obj.fundsSource, obj.additionalFees[0].destinationId, obj.additionalFees[0].amount, obj.additionalFees[1].destinationId,
                        obj.additionalFees[1].amount);
    }

}
