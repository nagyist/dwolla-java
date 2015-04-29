package com.dwolla.java.sdk.responses;

import com.dwolla.java.sdk.models.PendingRequest;
import com.dwolla.java.sdk.models.UserContact;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class PendingRequestResponseTest {

    @Test
    public void testConversionToJson() {
        PendingRequestResponse response = createResponseObject();

        String actual = new Gson().toJson(response);

        Assert.assertEquals(getJsonString(response), actual);
    }

    @Test
    public void testConversionFromJson() {
        PendingRequestResponse expected = createResponseObject();

        PendingRequestResponse actual = new Gson().fromJson(getJsonString(expected), PendingRequestResponse.class);

        Assert.assertEquals(expected.Response, actual.Response);
    }

    private PendingRequestResponse createResponseObject() {
        PendingRequestResponse response = new PendingRequestResponse();
        PendingRequest request = new PendingRequest(123, 1.11, "3/15/12", "pending", new UserContact("Ben", "812-000-0000", "dwolla",
                "https://www.dwolla.com/avatar/812-000-0000"), new UserContact("Milne", "812-000-0001", "dwolla",
                "https://www.dwolla.com/avatar/812-000-0001"), "Notes1");
        response.Response = request;
        return response;
    }

    private String getJsonString(PendingRequestResponse obj) {
        return "{\"Response\":{\"DateRequested\":\"3/15/12\",\"Id\":123,\"Amount\":1.11,\"Status\":\"pending\",\"Source\":{\"Name\":\"Ben\",\"Id\":\"812-000-0000\",\"Type\":\"dwolla\",\"Image\":\"https://www.dwolla.com/avatar/812-000-0000\"},\"Destination\":{\"Name\":\"Milne\",\"Id\":\"812-000-0001\",\"Type\":\"dwolla\",\"Image\":\"https://www.dwolla.com/avatar/812-000-0001\"},\"Notes\":\"Notes1\"},\"Success\":false}";
    }

}
