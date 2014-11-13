package com.dwolla.java.sdk.responses;

import com.dwolla.java.sdk.models.FulfillRequest;
import com.dwolla.java.sdk.models.UserContact;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class FulfillRequestResponseTest {

    @Test
    public void testConversionToJson() {
        FulfillRequestResponse response = createResponseObject();

        String actual = new Gson().toJson(response);

        Assert.assertEquals(getJsonString(response), actual);
    }

    @Test
    public void testConversionFromJson() {
        FulfillRequestResponse expected = createResponseObject();

        FulfillRequestResponse actual = new Gson().fromJson(getJsonString(expected), FulfillRequestResponse.class);

        Assert.assertEquals(expected.Response, actual.Response);
    }

    private FulfillRequestResponse createResponseObject() {
        FulfillRequestResponse response = new FulfillRequestResponse();
        response.Response = new FulfillRequest(123, 456, 1.11, "3/15/12", "3/15/12", "pending", new UserContact("Ben", "812-000-0000", "dwolla",
                "https://www.dwolla.com/avatar/812-000-0000"), new UserContact("Milne", "812-000-0001", "twitter",
                "https://www.dwolla.com/avatar/812-000-0001"), "Notes");
        return response;
    }

    private String getJsonString(FulfillRequestResponse obj) {
        return "{\"Response\":{\"RequestId\":456,\"SentDate\":\"3/15/12\",\"ClearingDate\":\"3/15/12\",\"Id\":123,\"Amount\":1.11,\"Status\":\"pending\",\"Source\":{\"Name\":\"Ben\",\"Id\":\"812-000-0000\",\"Type\":\"dwolla\",\"Image\":\"https://www.dwolla.com/avatar/812-000-0000\"},\"Destination\":{\"Name\":\"Milne\",\"Id\":\"812-000-0001\",\"Type\":\"twitter\",\"Image\":\"https://www.dwolla.com/avatar/812-000-0001\"},\"Notes\":\"Notes\"},\"Success\":false}";
    }

}
