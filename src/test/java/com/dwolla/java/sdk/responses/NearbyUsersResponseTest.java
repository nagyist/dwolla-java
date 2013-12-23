package com.dwolla.java.sdk.responses;

import com.dwolla.java.sdk.models.NearbyUser;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class NearbyUsersResponseTest {

    @Test
    public void testConversionToJson() {
        NearbyUsersResponse response = createResponseObject();

        String actual = new Gson().toJson(response);

        Assert.assertEquals(getJsonString(response), actual);
    }

    @Test
    public void testConversionFromJson() {
        NearbyUsersResponse expected = createResponseObject();

        NearbyUsersResponse actual = new Gson().fromJson(getJsonString(expected), NearbyUsersResponse.class);

        Assert.assertEquals(expected.Response[0], actual.Response[0]);
        Assert.assertEquals(expected.Response[1], actual.Response[1]);
    }

    private NearbyUsersResponse createResponseObject() {
        NearbyUsersResponse response = new NearbyUsersResponse();
        NearbyUser[] responses = {new NearbyUser("Ben", "812-000-0000", "https://www.dwolla.com/avatar/812-000-0000", 41.0, -91.0, 0.00),
                new NearbyUser("Milne", "812-000-0001", "https://www.dwolla.com/avatar/812-000-0001", 41.1, -91.1, 1.00)};
        response.Response = responses;
        return response;
    }

    private String getJsonString(NearbyUsersResponse obj) {
        return "{\"Response\":[{\"Name\":\"Ben\",\"Id\":\"812-000-0000\",\"Image\":\"https://www.dwolla.com/avatar/812-000-0000\",\"Latitude\":41.0,\"Longitude\":-91.0,\"Delta\":0.0},{\"Name\":\"Milne\",\"Id\":\"812-000-0001\",\"Image\":\"https://www.dwolla.com/avatar/812-000-0001\",\"Latitude\":41.1,\"Longitude\":-91.1,\"Delta\":1.0}],\"Success\":false}";
    }

}
