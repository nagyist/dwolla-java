package com.dwolla.java.sdk.responses;

import com.dwolla.java.sdk.models.Transaction;
import com.dwolla.java.sdk.models.TransactionWithFees;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class TransactionResponseTest {

    @Test
    public void testConversionToJSON() {
        TransactionResponse transactionResponse = createObject();

        String actual = new Gson().toJson(transactionResponse);

        Assert.assertEquals(getJSONString(), actual);
    }

    @Test
    public void testConversionFromJSON() {
        TransactionResponse response = new Gson().fromJson(getJSONString(), TransactionResponse.class);
        Assert.assertEquals(createObject(), response);
    }

    private TransactionResponse createObject() {
        TransactionResponse response = new TransactionResponse();
        Transaction[] fees = new Transaction[1];
        fees[0] = new Transaction(2, .25, "12/23/2013", "fee", "Dwolla", "812-555-1234", "somePlaceCool", "812-555-4321", "somePerson", "12/24/2013", "processed", "beer");
        response.Response = new TransactionWithFees(1, 100.00, "12/23/2013", "money_sent", "Dwolla", "812-555-1234", "somePlaceCool", "812-555-4321", "somePerson", "12/24/2013", "processed", "beer", fees);

        return response;
    }

    private String getJSONString() {
        String jsonString = "{\"Response\":{\"Fees\":[{\"Id\":2,\"Amount\":0.25,\"Date\":\"12/23/2013\",\"Type\":\"fee\",\"UserType\":\"Dwolla\",\"DestinationId\":\"812-555-1234\",\"DestinationName\":\"somePlaceCool\",\"SourceId\":\"812-555-4321\",\"SourceName\":\"somePerson\",\"ClearingDate\":\"12/24/2013\",\"Status\":\"processed\",\"Notes\":\"beer\"}],\"Id\":1,\"Amount\":100.0,\"Date\":\"12/23/2013\",\"Type\":\"money_sent\",\"UserType\":\"Dwolla\",\"DestinationId\":\"812-555-1234\",\"DestinationName\":\"somePlaceCool\",\"SourceId\":\"812-555-4321\",\"SourceName\":\"somePerson\",\"ClearingDate\":\"12/24/2013\",\"Status\":\"processed\",\"Notes\":\"beer\"},\"Success\":false}";
        return jsonString;
    }

}
