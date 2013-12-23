package com.dwolla.java.sdk.responses;

import com.dwolla.java.sdk.models.FundingSource;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class FundingSourcesByIdResponseTest {

    @Test
    public void testConversionToJson() {
        FundingSourcesByIdResponse response = createResponseObject();

        String actual = new Gson().toJson(response);

        Assert.assertEquals(getJsonString(response), actual);
    }

    @Test
    public void testConversionFromJson() {
        FundingSourcesByIdResponse expected = createResponseObject();

        FundingSourcesByIdResponse actual = new Gson().fromJson(getJsonString(expected), FundingSourcesByIdResponse.class);

        Assert.assertEquals(expected, actual);
    }

    private FundingSourcesByIdResponse createResponseObject() {
        FundingSourcesByIdResponse response = new FundingSourcesByIdResponse();
        response.Response = new FundingSource("123abc", "Bank of Ben", "Checking", true, "FiSync", 1234.56);
        return response;
    }

    private String getJsonString(FundingSourcesByIdResponse obj) {
        return String
                .format(
                        "{\"Response\":{\"Balance\":%.2f,\"Id\":\"%s\",\"Name\":\"%s\",\"Type\":\"%s\",\"Verified\":%b,\"ProcessingType\":\"%s\"},\"Success\":false}",
                        obj.Response.Balance, obj.Response.Id, obj.Response.Name, obj.Response.Type, obj.Response.Verified, obj.Response.ProcessingType);
    }

}
