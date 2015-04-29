package com.dwolla.java.sdk;

import com.dwolla.java.sdk.requests.SendRequest;
import com.dwolla.java.sdk.responses.BalanceResponse;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class DwollaTypedBytesTest {

    @Test
    public void testUtf8StaticVariable() {
        Assert.assertEquals("UTF-8", DwollaTypedBytes.UTF_8);
    }

    @Test
    public void testMimeTypeReturnsJson() {
        String expectedMime = "application/json";

        DwollaTypedBytes actual = new DwollaTypedBytes(new Gson(), new BalanceResponse());

        Assert.assertEquals(expectedMime, actual.mimeType());
    }

    @Test
    public void testLengthReturnsExpectedLength() {
        Assert.assertEquals(79, new DwollaTypedBytes(new Gson(), createRequest()).length());
    }

    @Test
    public void testWriteToReturnsExpectedStream() {
        SendRequest expected = createRequest();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            new DwollaTypedBytes(new Gson(), expected).writeTo(out);
        } catch (IOException e) {
            Assert.fail("Unexpected execption thrown");
        }

        Assert.assertEquals("{\"pin\":\"1234\",\"destinationId\":\"812-000-0000\",\"amount\":0.01,\"assumeCosts\":false}",
                out.toString());
    }

    private SendRequest createRequest() {
        return new SendRequest("1234", "812-000-0000", 0.01);
    }
}