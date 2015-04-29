package com.dwolla.java.sdk.responses;

import com.dwolla.java.sdk.models.ItemSummary;
import com.dwolla.java.sdk.models.Job;
import com.dwolla.java.sdk.models.Transaction;
import com.dwolla.java.sdk.models.TransactionWithFees;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CreateJobResponseTest {

    @Test
    public void testConversionToJSON() {
        CreateJobResponse response = createObject();

        String actual = new Gson().toJson(response);

        Assert.assertEquals(getJSONString(), actual);
    }

    @Test
    public void testConversionFromJSON() {
        CreateJobResponse response = new Gson().fromJson(getJSONString(), CreateJobResponse.class);
        Assert.assertEquals(createObject(), response);
    }

    private CreateJobResponse createObject() {
        CreateJobResponse response = new CreateJobResponse();
        response.Response = new Job("123", "456", true, "Balance", 1.01, 0.01, "12/24/2013", "queued", new ItemSummary(4, 2, 2));


        return response;
    }

    private String getJSONString() {
        return "{\"Response\":{\"Id\":\"123\",\"UserJobId\":\"456\",\"AssumeCosts\":true,\"FundingSource\":\"Balance\",\"Total\":1.01,\"Fees\":0.01,\"CreatedDate\":\"12/24/2013\",\"Status\":\"queued\",\"ItemSummary\":{\"Count\":4,\"Completed\":2,\"Successful\":2}},\"Success\":false}";
    }

}