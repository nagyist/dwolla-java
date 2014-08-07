package com.example;

import com.dwolla.java.sdk.DwollaCallback;
import com.dwolla.java.sdk.DwollaServiceAsync;
import com.dwolla.java.sdk.DwollaServiceSync;
import com.dwolla.java.sdk.DwollaTypedBytes;
import com.dwolla.java.sdk.requests.SendRequest;
import com.dwolla.java.sdk.responses.BasicAccountInformationResponse;
import com.dwolla.java.sdk.responses.SendResponse;
import com.google.gson.Gson;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.Server;
import retrofit.client.Response;

public class App {
    private final static String baseUrl = "https://www.dwolla.com/oauth/rest";
    // Sandbox mode: private final static String baseUrl = "https://uat.dwolla.com/oauth/rest";
    private final static String applicationKey = "";
    private final static String applicationSecret = "";
    private final static String userOAuthToken = "";
    private final static String userPin = "";

    // Dwolla Reflector account, any money sent to it will be sent right back to you
    private final static String testAccountId = "812-713-9234";

    public static void main(String[] args) {
        makeAsynchronousApiCalls();

        makeSynchronousApiCalls();
    }

    private static void makeAsynchronousApiCalls() {
        DwollaServiceAsync asyncService = createAsynchronousService();

        // Make calls and continue (non-blocking), results printed in callbacks below
        asyncService.getBasicAccountInformation(testAccountId, applicationKey, applicationSecret,
            new BasicInformationCallback());
        asyncService.send(new DwollaTypedBytes(new Gson(), new SendRequest(userOAuthToken, userPin, testAccountId, 0.01)),
            new SendCallback());
    }

    private static DwollaServiceAsync createAsynchronousService() {
        return new RestAdapter
                .Builder()
                .setServer(new Server(baseUrl))
                .build()
                .create(DwollaServiceAsync.class);
    }

    private static void makeSynchronousApiCalls() {
        DwollaServiceSync syncService = createSynchronousService();

        // Make calls, wait for response (blocking), and print result
        System.out.println(syncService
            .getBasicAccountInformation(testAccountId, applicationKey, applicationSecret).Response.Name);
        System.out.println(syncService
            .send(new DwollaTypedBytes(new Gson(), new SendRequest(userOAuthToken, userPin, testAccountId, 0.01))).Response);
    }

    private static DwollaServiceSync createSynchronousService() {
        return new RestAdapter
                .Builder()
                .setServer(new Server(baseUrl))
                .build()
                .create(DwollaServiceSync.class);
    }

    // Callback for asynchronous service call
    private static class BasicInformationCallback extends DwollaCallback<BasicAccountInformationResponse> {
        @Override
        public void success(BasicAccountInformationResponse response, Response r) {
            if (response.Success)
                // Print result
                System.out.println(response.Response.Name);
            else
                super.failure(response.Message, this);
        }

        @Override
        public void failure(RetrofitError error) {
            super.failure(error.getMessage(), this);
        }
    }

    // Callback for asynchronous service call
    private static class SendCallback extends DwollaCallback<SendResponse> {
        @Override
        public void success(SendResponse response, Response r) {
            if (response.Success)
                // Print result
                System.out.println(response.Response);
            else
                super.failure(response.Message, this);
        }

        @Override
        public void failure(RetrofitError error) {
            super.failure(error.getMessage(), this);
        }
    }
}
