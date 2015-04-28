package com.dwolla.java.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Header;
import retrofit.client.Response;

import java.io.IOException;
import java.util.Scanner;

public abstract class DwollaCallback<T> implements Callback<T> {
    private Log log = LogFactory.getLog(DwollaCallback.class);

    public void setLog(Log log) {
        if (log != null) {
            this.log = log;
        }
    }

    @Override
    public void success(T t, Response response) {
        if (t != null) {
            log.info("Retrofit success: " + t.getClass().getName());
        }
    }

    public String formatErrorMessage(RetrofitError error) {
        Response response = error.getResponse();
        StringBuilder sb = new StringBuilder("Retrofit failure:\nUrl: ").append(error.getUrl());

        sb.append("\nMessage: ").append(error.getMessage());
        sb.append("\nCause: ").append(error.getCause());

        if (response != null) {
            if (response.getStatus() != 0) {
                sb.append("\nStatus code: ").append(response.getStatus());
            }

            sb.append("\nReason: ").append(response.getReason());

            if (response.getHeaders() != null) {
                sb.append("\nHeaders:");
                for (Header header : response.getHeaders()) {
                    sb.append("\n").append(header.toString());
                }
            }

            if (response.getBody() != null) {
                sb.append("\nBody: ");
                try {
                    Scanner s = new Scanner(response.getBody().in());
                    s.useDelimiter("\\A");
                    sb.append(s.hasNext() ? s.next() : "");
                    s.close();
                } catch (IOException e) {
                    sb.append("Error parsing body");
                }
            }
        }

        return sb.toString();
    }

    public void failure(String message, DwollaCallback<?> c) {
        log.error("Dwolla API Failure - " + c.getClass().getName() + ": " + message);
    }

}
