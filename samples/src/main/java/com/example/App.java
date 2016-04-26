package com.example;

import com.dwolla.java.sdk.*;
import com.dwolla.java.sdk.requests.SendRequest;
import com.dwolla.java.sdk.requests.TokenRequest;
import com.dwolla.java.sdk.responses.BasicAccountInformationResponse;
import com.dwolla.java.sdk.responses.SendResponse;
import com.dwolla.java.sdk.responses.TokenResponse;
import com.google.gson.Gson;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.api.CustomersApi;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import spark.Request;
import spark.Response;
import spark.Route;

import java.awt.*;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;

import static spark.Spark.get;

public class App {
    public final static String SCOPES = "Send|AccountInfoFull|Funding";
    public final static String REDIRECT_URI = "http://localhost:4567/callback";
    public final static String CLIENT_ID = "6t3kALJ5lflODl74xDG5vZt1G0nVEIUAfb5TEglD/KepIQVyOy";
    public final static String CLIENT_SECRET = "cL8dAjRkTeSkXHjLINkVN9Jn+URVVuyVudZTI6IFOxSBsArJef";
    public final static String SENDER_PIN = "1234";
    // Use "812-713-9234" in production, any money sent to it will be sent right back to you
    public final static String DESTINATION_ID = "812-172-9684";

    public static void main(String[] args) {
        ApiClient client = new ApiClient();
        client.setBasePath("http://api-uat.dwolla.com");
        client.addDefaultHeader("Authorization", "Bearer NmMGDSD3pETrChtOeGbf6nmnBLD0lNGjtCpghwusJ8O2OBz9WQ");
        CustomersApi api = new CustomersApi(client);
        try {
            System.out.println(api.list(10, 0));
        } catch (ApiException e) {
            System.out.println(e.getMessage());
        }
//        openBrowserToRequestAuthorization();
//
//        get(new Route("/callback") {
//            @Override
//            public Object handle(Request req, Response res) {
//                TokenResponse tr = getToken(req.queryParams("code"));
//                callApiAsync(tr.access_token);
//                return callApi(tr.access_token);
//            }
//        });
    }

    private static void openBrowserToRequestAuthorization() {
        try {
            Desktop.getDesktop().browse(
                    new URI(String.format("%s/authenticate?response_type=code&scope=%s&client_id=%s&redirect_uri=%s",
                            Config.BASE_OAUTH_URL, encode(SCOPES), encode(CLIENT_ID), encode(REDIRECT_URI))));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static TokenResponse getToken(String code) {
        OAuthServiceSync oAuth = createOAuthService();
        return oAuth.getToken(new DwollaTypedBytes(new Gson(),
                new TokenRequest(CLIENT_ID, CLIENT_SECRET, Consts.Api.AUTHORIZATION_CODE, REDIRECT_URI, code)));
    }

    private static void callApiAsync(String token) {
        DwollaServiceAsync dwolla = createDwollaAsyncService();
        dwolla.getBasicAccountInformation(DESTINATION_ID, CLIENT_ID, CLIENT_SECRET, new BasicInformationCallback());
        dwolla.send(token, new DwollaTypedBytes(new Gson(), new SendRequest(SENDER_PIN, DESTINATION_ID, 0.01)), new SendCallback());
    }

    private static String callApi(String token) {
        DwollaServiceSync dwolla = createDwollaService();
        BasicAccountInformationResponse infoRes = dwolla.getBasicAccountInformation(DESTINATION_ID, CLIENT_ID, CLIENT_SECRET);
        SendResponse sendRes = dwolla.send(token, new DwollaTypedBytes(new Gson(), new SendRequest(SENDER_PIN, DESTINATION_ID, 0.01)));

        return String.format("Synchronous account name: \"%s\" | Synchronous transaction id: \"%s\" | Check console output for asynchronous responses",
                infoRes.Success ? infoRes.Response.Name : infoRes.Message,
                sendRes.Success ? sendRes.Response : sendRes.Message);
    }

    private static OAuthServiceSync createOAuthService() {
        return new RestAdapter
                .Builder()
                .setEndpoint(Config.BASE_OAUTH_URL)
                .build()
                .create(OAuthServiceSync.class);
    }

    private static DwollaServiceSync createDwollaService() {
        return new RestAdapter
                .Builder()
                .setEndpoint(Config.BASE_URL)
                .build()
                .create(DwollaServiceSync.class);
    }

    private static DwollaServiceAsync createDwollaAsyncService() {
        return new RestAdapter
                .Builder()
                .setEndpoint(Config.BASE_URL)
                .build()
                .create(DwollaServiceAsync.class);
    }

    private static String encode(String decoded) {
        try {
            return URLEncoder.encode(decoded, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
            return decoded;
        }
    }

    /**
     * Asynchronous callbacks, helpful in Android apps to keep HTTP calls off the main thread.
     */
    private static class BasicInformationCallback extends DwollaCallback<BasicAccountInformationResponse> {
        @Override
        public void success(BasicAccountInformationResponse response, retrofit.client.Response r) {
            System.out.println("Asynchronous account name: " + (response.Success ? response.Response.Name : response.Message));
        }

        public void failure(RetrofitError error) {
            super.failure(error.getMessage(), this);
        }
    }

    private static class SendCallback extends DwollaCallback<SendResponse> {
        @Override
        public void success(SendResponse response, retrofit.client.Response r) {
            System.out.println("Asynchronous transaction id: " + (response.Success ? response.Response : response.Message));
        }

        public void failure(RetrofitError error) {
            super.failure(error.getMessage(), this);
        }
    }
}