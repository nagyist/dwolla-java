package com.dwolla.java.sdk.responses;

import com.dwolla.java.sdk.models.BasicFundingSource;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class FundingSourcesListingResponseTest {

    @Test
    public void testConversionToJson() {
        FundingSourcesListingResponse response = createResponseObject();

        String actual = new Gson().toJson(response);

        Assert.assertEquals(getJsonString(response), actual);
    }

    @Test
    public void testConversionFromJson() {
        FundingSourcesListingResponse expected = createResponseObject();

        FundingSourcesListingResponse actual = new Gson().fromJson(getJsonString(expected), FundingSourcesListingResponse.class);

        Assert.assertEquals(expected.Response[0], actual.Response[0]);
        Assert.assertEquals(expected.Response[1], actual.Response[1]);
    }

    private FundingSourcesListingResponse createResponseObject() {
        FundingSourcesListingResponse response = new FundingSourcesListingResponse();
        BasicFundingSource[] responses = {new BasicFundingSource("123abc", "Bank of Ben", "Checking", true, "FiSync"),
                new BasicFundingSource("456def", "Bank of Milne", "Savings", false, "ACH")};
        response.Response = responses;
        return response;
    }

    private String getJsonString(FundingSourcesListingResponse obj) {
        return String
                .format(
                        "{\"Response\":[{\"Id\":\"%s\",\"Name\":\"%s\",\"Type\":\"%s\",\"Verified\":%b,\"ProcessingType\":\"%s\"},{\"Id\":\"%s\",\"Name\":\"%s\",\"Type\":\"%s\",\"Verified\":%b,\"ProcessingType\":\"%s\"}],\"Success\":false}",
                        obj.Response[0].Id, obj.Response[0].Name, obj.Response[0].Type, obj.Response[0].Verified, obj.Response[0].ProcessingType,
                        obj.Response[1].Id, obj.Response[1].Name, obj.Response[1].Type, obj.Response[1].Verified, obj.Response[1].ProcessingType);
    }

}
