package com.dwolla.java.sdk.responses;

import com.dwolla.java.sdk.models.LinkDetails;
import com.dwolla.java.sdk.models.Links;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class ResponseTest {

    @Test
    public void testConversionToJson() {
        Response response = createResponseObject();

        String actual = new Gson().toJson(response);

        Assert.assertEquals(getJsonString(response), actual);
    }

    @Test
    public void testConversionFromJson() {
        Response expected = createResponseObject();

        Response actual = new Gson().fromJson(getJsonString(expected), Response.class);

        Assert.assertEquals(expected.Success, actual.Success);
        Assert.assertEquals(expected.Message, actual.Message);
        Assert.assertEquals(expected._links, actual._links);
    }

    private Response createResponseObject() {
        Response response = new Response();
        response.Success = true;
        response.Message = "Success";
        response._links = new Links(new LinkDetails("http://uat.dwolla.com"), new LinkDetails("http://uat.dwolla.com/1"), new LinkDetails("http://uat.dwolla.com/2"), new LinkDetails("http://uat.dwolla.com/3", true));
        return response;
    }

    private String getJsonString(Response obj) {
        return "{\"Success\":true,\"Message\":\"Success\",\"_links\":{\"self\":{\"href\":\"http://uat.dwolla.com\",\"templated\":false},\"send\":{\"href\":\"http://uat.dwolla.com/1\",\"templated\":false},\"createScheduled\":{\"href\":\"http://uat.dwolla.com/2\",\"templated\":false},\"fulfill\":{\"href\":\"http://uat.dwolla.com/3\",\"templated\":true}}}";
    }

}
