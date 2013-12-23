package com.dwolla.java.sdk.responses;

import com.dwolla.java.sdk.models.AccountInformation;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class AccountInformationResponseTest {

    @Test
    public void testConversionToJson() {
        AccountInformationResponse response = createResponseObject();

        String actual = new Gson().toJson(response);

        Assert.assertEquals(getJsonString(response), actual);
    }

    @Test
    public void testConversionFromJson() {
        AccountInformationResponse expected = createResponseObject();

        AccountInformationResponse actual = new Gson().fromJson(getJsonString(expected), AccountInformationResponse.class);

        Assert.assertEquals(expected, actual);
    }

    private AccountInformationResponse createResponseObject() {
        AccountInformationResponse response = new AccountInformationResponse();
        response.Response = new AccountInformation("812-000-0000", "Ben Milne", 41.0, -91.0, "Des Moines", "IA", "Dwolla");
        return response;
    }

    private String getJsonString(AccountInformationResponse obj) {
        return String
                .format(
                        "{\"Response\":{\"City\":\"%s\",\"State\":\"%s\",\"Type\":\"%s\",\"Id\":\"%s\",\"Name\":\"%s\",\"Latitude\":%.1f,\"Longitude\":%.1f},\"Success\":false}",
                        obj.Response.City, obj.Response.State, obj.Response.Type, obj.Response.Id, obj.Response.Name, obj.Response.Latitude,
                        obj.Response.Longitude);
    }

}
