package com.dwolla.java.sdk.responses;

import com.dwolla.java.sdk.models.UserContact;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class UserContactsResponseTest {

    @Test
    public void testConversionToJson() {
        UserContactsResponse response = createResponseObject();

        String actual = new Gson().toJson(response);

        Assert.assertEquals(getJsonString(response), actual);
    }

    @Test
    public void testConversionFromJson() {
        UserContactsResponse expected = createResponseObject();

        UserContactsResponse actual = new Gson().fromJson(getJsonString(expected), UserContactsResponse.class);

        Assert.assertEquals(expected.Response[0], actual.Response[0]);
        Assert.assertEquals(expected.Response[1], actual.Response[1]);
    }

    private UserContactsResponse createResponseObject() {
        UserContactsResponse response = new UserContactsResponse();
        UserContact[] responses = {new UserContact("Ben Milne", "812-000-0000", "Dwolla", "https://www.dwolla.com/avatar/812-000-0000"),
                new UserContact("Milne Ben", "812-000-0001", "Email", "https://www.dwolla.com/avatar/812-000-0001")};
        response.Response = responses;
        return response;
    }

    private String getJsonString(UserContactsResponse obj) {
        return "{\"Response\":[{\"Name\":\"Ben Milne\",\"Id\":\"812-000-0000\",\"Type\":\"Dwolla\",\"Image\":\"https://www.dwolla.com/avatar/812-000-0000\"},{\"Name\":\"Milne Ben\",\"Id\":\"812-000-0001\",\"Type\":\"Email\",\"Image\":\"https://www.dwolla.com/avatar/812-000-0001\"}],\"Success\":false}";
    }

}
