package com.dwolla.java.sdk.responses;

import com.dwolla.java.sdk.models.Transaction;
import com.dwolla.java.sdk.models.TransactionWithFees;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class TransactionsResponseTest {

    @Test
    public void testConversionToJson() {
        TransactionsResponse response = createResponseObject();

        String actual = new Gson().toJson(response);

        Assert.assertEquals(getJsonString(response), actual);
    }

    @Test
    public void testConversionFromJson() {
        TransactionsResponse expected = createResponseObject();

        TransactionsResponse actual = new Gson().fromJson(getJsonString(expected), TransactionsResponse.class);

        Assert.assertEquals(expected.Response[0], actual.Response[0]);
        Assert.assertEquals(expected.Response[1], actual.Response[1]);
    }

    private TransactionsResponse createResponseObject() {
        TransactionsResponse response = new TransactionsResponse();
        Transaction[] fees = {new Transaction(124, 0.25, "1-1-11", "fee", "Dwolla", "812-000-0000", "812-000-0001", "Ben Milne", null, "1-2-11",
                "processed", null)};
        TransactionWithFees[] responses = {
                new TransactionWithFees(123, 1.11, "1-1-11", "money_sent", "Dwolla", "812-000-0000", "812-000-0001", "Ben Milne", "1", "1-2-11",
                        "processed", "Hey", fees),
                new TransactionWithFees(456, 2.22, "2-2-22", "money_received", "Email", "812-000-0001", "812-000-0000", "Milne Ben", "2", "2-23-22",
                        "failed", "Yo", null)};
        response.Response = responses;
        return response;
    }

    private String getJsonString(TransactionsResponse obj) {
        return "{\"Response\":[{\"Fees\":[{\"Id\":124,\"Amount\":0.25,\"Date\":\"1-1-11\",\"Type\":\"fee\",\"UserType\":\"Dwolla\",\"DestinationId\":\"812-000-0000\",\"DestinationName\":\"812-000-0001\",\"SourceId\":\"Ben Milne\",\"ClearingDate\":\"1-2-11\",\"Status\":\"processed\"}],\"Id\":123,\"Amount\":1.11,\"Date\":\"1-1-11\",\"Type\":\"money_sent\",\"UserType\":\"Dwolla\",\"DestinationId\":\"812-000-0000\",\"DestinationName\":\"812-000-0001\",\"SourceId\":\"Ben Milne\",\"SourceName\":\"1\",\"ClearingDate\":\"1-2-11\",\"Status\":\"processed\",\"Notes\":\"Hey\"},{\"Id\":456,\"Amount\":2.22,\"Date\":\"2-2-22\",\"Type\":\"money_received\",\"UserType\":\"Email\",\"DestinationId\":\"812-000-0001\",\"DestinationName\":\"812-000-0000\",\"SourceId\":\"Milne Ben\",\"SourceName\":\"2\",\"ClearingDate\":\"2-23-22\",\"Status\":\"failed\",\"Notes\":\"Yo\"}],\"Success\":false}";
    }

}
