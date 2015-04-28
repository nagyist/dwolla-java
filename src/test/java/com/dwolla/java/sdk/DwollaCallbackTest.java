package com.dwolla.java.sdk;

import com.dwolla.java.sdk.responses.BalanceResponse;
import com.google.gson.Gson;
import org.apache.commons.logging.Log;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import retrofit.RetrofitError;
import retrofit.client.Header;
import retrofit.client.Response;
import retrofit.converter.ConversionException;
import retrofit.converter.GsonConverter;
import retrofit.mime.TypedInput;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DwollaCallbackTest {
    private DwollaCallback<BalanceResponse> callback;
    private Log log;

    @Before
    public void setUp() {
        callback = new TestCallback();
        log = mock(Log.class);
        callback.setLog(log);
    }

    @Test
    public void testSuccessWithNullDoesNotThrow() {
        try {
            callback.success(null, null);
        } catch (Exception e) {
            Assert.fail("Unexpected execption thrown");
        }
    }

    @Test
    public void testSuccessLogsSuccess() {
        BalanceResponse response = new BalanceResponse();

        callback.success(response, null);

        verify(log).info(String.format("Retrofit success: %s", response.getClass().getName()));
    }

    @Test
    public void testFailureWithNullDoesNotThrow() {
        RetrofitError error = RetrofitError.conversionError(null, null, null, null, new ConversionException(""));

        try {
            callback.failure(error);
        } catch (Exception e) {
            Assert.fail("Unexpected exception thrown");
        }
    }

    @Test
    public void testFailureSetsLastError() {
        String reason = "reason";
        List<Header> headers = Arrays.asList(new Header("name1", "value1"), new Header("name2", "value2"));
        String body = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\"><html xmlns=\"http://www.w3.org/1999/xhtml\"><body></body></html>";
        String url = "http://www.example.com";
        Response response = new Response(url, 200, reason, headers, new TypedInputStream("application/json", body.length(), new ByteArrayInputStream(
                body.getBytes())));
        RetrofitError error = RetrofitError.conversionError("https://www.dwolla.com", response, new GsonConverter(new Gson()), null,
                new ConversionException("message"));

        Assert.assertEquals(
                "Retrofit failure:\nUrl: https://www.dwolla.com\nMessage: message\nCause: retrofit.converter.ConversionException: message\nStatus code: 200\nReason: reason\nHeaders:\nname1: value1\nname2: value2\nBody: <!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\"><html xmlns=\"http://www.w3.org/1999/xhtml\"><body></body></html>",
                callback.formatErrorMessage(error));
    }

    @Test
    public void testFailureLogsMessage() {
        String message = "message";

        callback.failure(message, new TestCallback());

        verify(log).error(String.format("Dwolla API Failure - com.dwolla.java.sdk.DwollaCallbackTest$TestCallback: %s", message));
    }

    private static class TypedInputStream implements TypedInput {
        private final String mimeType;
        private final long length;
        private final InputStream stream;

        private TypedInputStream(String mimeType, long length, InputStream stream) {
            this.mimeType = mimeType;
            this.length = length;
            this.stream = stream;
        }

        @Override
        public String mimeType() {
            return mimeType;
        }

        @Override
        public long length() {
            return length;
        }

        @Override
        public InputStream in() throws IOException {
            return stream;
        }
    }

    private class TestCallback extends DwollaCallback<BalanceResponse> {
        @Override
        public void success(BalanceResponse br, Response r) {
            super.success(br, r);
        }

        @Override
        public void failure(RetrofitError error) {
        }
    }
}
