package com.dwolla.java.sdk.responses;

import com.dwolla.java.sdk.models.BasicAccountInformation;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class BasicAccountInformationResponseTest {

    @Test
    public void testConversionToJson() {
        BasicAccountInformationResponse response = createResponseObject();

        String actual = new Gson().toJson(response);

        Assert.assertEquals(getJsonString(response), actual);
    }

    @Test
    public void testConversionFromJson() {
        BasicAccountInformationResponse expected = createResponseObject();

        BasicAccountInformationResponse actual = new Gson().fromJson(getJsonString(expected), BasicAccountInformationResponse.class);

        Assert.assertEquals(expected, actual);
    }

    private BasicAccountInformationResponse createResponseObject() {
        BasicAccountInformationResponse response = new BasicAccountInformationResponse();
        response.Response = new BasicAccountInformation("812-000-0000", "Ben Milne", 41.0, -91.0);
        return response;
    }

    private String getJsonString(BasicAccountInformationResponse obj) {
        return String.format("{\"Response\":{\"Id\":\"%s\",\"Name\":\"%s\",\"Latitude\":%.1f,\"Longitude\":%.1f},\"Success\":false}", obj.Response.Id,
                obj.Response.Name, obj.Response.Latitude, obj.Response.Longitude);
    }

}
