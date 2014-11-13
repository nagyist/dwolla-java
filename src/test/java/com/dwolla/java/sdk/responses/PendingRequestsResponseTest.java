package com.dwolla.java.sdk.responses;

import com.dwolla.java.sdk.models.PendingRequest;
import com.dwolla.java.sdk.models.UserContact;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class PendingRequestsResponseTest {

    @Test
    public void testConversionToJson() {
        PendingRequestsResponse response = createResponseObject();

        String actual = new Gson().toJson(response);

        Assert.assertEquals(getJsonString(response), actual);
    }

    @Test
    public void testConversionFromJson() {
        PendingRequestsResponse expected = createResponseObject();

        PendingRequestsResponse actual = new Gson().fromJson(getJsonString(expected), PendingRequestsResponse.class);

        Assert.assertEquals(expected.Response[0], actual.Response[0]);
        Assert.assertEquals(expected.Response[1], actual.Response[1]);
    }

    private PendingRequestsResponse createResponseObject() {
        PendingRequestsResponse response = new PendingRequestsResponse();
        PendingRequest[] responses = {
                new PendingRequest(123, 1.11, "3/15/12", "pending", new UserContact("Ben", "812-000-0000", "dwolla",
                        "https://www.dwolla.com/avatar/812-000-0000"), new UserContact("Milne", "812-000-0001", "twitter",
                        "https://www.dwolla.com/avatar/812-000-0001"), "Notes1"),
                new PendingRequest(456, 2.22, "4/16/13", "complete", new UserContact("Hulk", "812-000-0002", "twitter",
                        "https://www.dwolla.com/avatar/812-000-0002"), new UserContact("Hogan", "812-000-0003", "email",
                        "https://www.dwolla.com/avatar/812-000-0003"), "Notes2")};
        response.Response = responses;
        return response;
    }

    private String getJsonString(PendingRequestsResponse obj) {
        return "{\"Response\":[{\"DateRequested\":\"3/15/12\",\"Id\":123,\"Amount\":1.11,\"Status\":\"pending\",\"Source\":{\"Name\":\"Ben\",\"Id\":\"812-000-0000\",\"Type\":\"dwolla\",\"Image\":\"https://www.dwolla.com/avatar/812-000-0000\"},\"Destination\":{\"Name\":\"Milne\",\"Id\":\"812-000-0001\",\"Type\":\"twitter\",\"Image\":\"https://www.dwolla.com/avatar/812-000-0001\"},\"Notes\":\"Notes1\"},{\"DateRequested\":\"4/16/13\",\"Id\":456,\"Amount\":2.22,\"Status\":\"complete\",\"Source\":{\"Name\":\"Hulk\",\"Id\":\"812-000-0002\",\"Type\":\"twitter\",\"Image\":\"https://www.dwolla.com/avatar/812-000-0002\"},\"Destination\":{\"Name\":\"Hogan\",\"Id\":\"812-000-0003\",\"Type\":\"email\",\"Image\":\"https://www.dwolla.com/avatar/812-000-0003\"},\"Notes\":\"Notes2\"}],\"Success\":false}";
    }

}
