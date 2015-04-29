package com.dwolla.java.sdk.responses;

import com.dwolla.java.sdk.models.Transaction;
import com.dwolla.java.sdk.models.TransactionSearchResult;
import com.dwolla.java.sdk.models.TransactionWithFees;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class TransactionSearchResponseTest {

    @Test
    public void testConversionToJSON() {
        TransactionSearchResponse response = createObject();

        String actual = new Gson().toJson(response);

        Assert.assertEquals(getJSONString(), actual);
    }

    @Test
    public void testConversionFromJSON() {
        TransactionSearchResponse response = new Gson().fromJson(getJSONString(), TransactionSearchResponse.class);
        Assert.assertEquals(createObject(), response);
    }

    private TransactionSearchResponse createObject() {
        TransactionSearchResponse response = new TransactionSearchResponse();
        TransactionWithFees[] results = new TransactionWithFees[1];
        results[0] = new TransactionWithFees(1, 100.00, "12/23/2013", "money_sent", "Dwolla", "812-555-1234", "somePlaceCool", "812-555-4321", "somePerson", "12/24/2013", "processed", "beer", null);
        response.Response = new TransactionSearchResult(results, results.length);

        return response;
    }

    private String getJSONString() {
        return "{\"Response\":{\"Results\":[{\"Id\":1,\"Amount\":100.0,\"Date\":\"12/23/2013\",\"Type\":\"money_sent\",\"UserType\":\"Dwolla\",\"DestinationId\":\"812-555-1234\",\"DestinationName\":\"somePlaceCool\",\"SourceId\":\"812-555-4321\",\"SourceName\":\"somePerson\",\"ClearingDate\":\"12/24/2013\",\"Status\":\"processed\",\"Notes\":\"beer\"}],\"TotalHits\":1},\"Success\":false}";
    }

}
