package com.dwolla.java.sdk.requests;

import com.dwolla.java.sdk.models.Item;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CreateJobRequestTest {

    @Test
    public void testConversionToJson() {
        CreateJobRequest response = createRequestObject();

        String actual = new Gson().toJson(response);

        Assert.assertEquals(getJsonString(response), actual);
    }

    @Test
    public void testConversionFromJson() {
        CreateJobRequest expected = createRequestObject();

        CreateJobRequest actual = new Gson().fromJson(getJsonString(expected), CreateJobRequest.class);

        Assert.assertEquals(expected, actual);
    }

    private CreateJobRequest createRequestObject() {
        Map<String, String> metadata = new HashMap<String, String>();
        metadata.put("dog", "cat");
        Item[] items = {new Item(0.01, "812-000-0001", "Dwolla", "notes", metadata)};
        return new CreateJobRequest("Balance", "1234", items, "456", true);
    }

    private String getJsonString(CreateJobRequest obj) {
        return "{\"fundingSource\":\"Balance\",\"pin\":\"1234\",\"items\":[{\"amount\":0.01,\"destination\":\"812-000-0001\",\"destinationType\":\"Dwolla\",\"notes\":\"notes\",\"metadata\":{\"dog\":\"cat\"}}],\"userJobId\":\"456\",\"assumeCosts\":true}";
    }

}
