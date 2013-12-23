package com.dwolla.java.sdk.responses;

import com.dwolla.java.sdk.models.NearbySpot;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class NearbySpotsResponseTest {

    @Test
    public void testConversionToJson() {
        NearbySpotsResponse response = createResponseObject();

        String actual = new Gson().toJson(response);

        Assert.assertEquals(getJsonString(response), actual);
    }

    @Test
    public void testConversionFromJson() {
        NearbySpotsResponse expected = createResponseObject();

        NearbySpotsResponse actual = new Gson().fromJson(getJsonString(expected), NearbySpotsResponse.class);

        Assert.assertEquals(expected.Response[0], actual.Response[0]);
        Assert.assertEquals(expected.Response[1], actual.Response[1]);
    }

    private NearbySpotsResponse createResponseObject() {
        NearbySpotsResponse response = new NearbySpotsResponse();
        NearbySpot[] responses = {
                new NearbySpot("123 abc", "Des Moines", "IA", "812-000-0000", "812-000-0001", "https://www.dwolla.com/avatar/812-000-0001", 41.0, -91.0,
                        "Ben Milne", "50309"),
                new NearbySpot("456 def", "Dog", "CA", "812-000-0002", "812-000-0003", "https://www.dwolla.com/avatar/812-000-0003", 42.0, -92.0,
                        "Milne Ben", "90210")};
        response.Response = responses;
        return response;
    }

    private String getJsonString(NearbySpotsResponse obj) {
        return String
                .format(
                        "{\"Response\":[{\"Address\":\"%s\",\"City\":\"%s\",\"State\":\"%s\",\"Group\":\"%s\",\"Id\":\"%s\",\"Image\":\"%s\",\"Latitude\":%.1f,\"Longitude\":%.1f,\"Name\":\"%s\",\"PostalCode\":\"%s\"},{\"Address\":\"%s\",\"City\":\"%s\",\"State\":\"%s\",\"Group\":\"%s\",\"Id\":\"%s\",\"Image\":\"%s\",\"Latitude\":%.1f,\"Longitude\":%.1f,\"Name\":\"%s\",\"PostalCode\":\"%s\"}],\"Success\":false}",
                        obj.Response[0].Address, obj.Response[0].City, obj.Response[0].State, obj.Response[0].Group, obj.Response[0].Id,
                        obj.Response[0].Image, obj.Response[0].Latitude, obj.Response[0].Longitude, obj.Response[0].Name, obj.Response[0].PostalCode,
                        obj.Response[1].Address, obj.Response[1].City, obj.Response[1].State, obj.Response[1].Group, obj.Response[1].Id,
                        obj.Response[1].Image, obj.Response[1].Latitude, obj.Response[1].Longitude, obj.Response[1].Name, obj.Response[1].PostalCode);
    }

}
