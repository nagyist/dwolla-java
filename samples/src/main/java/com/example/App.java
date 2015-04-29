package com.example;

import com.dwolla.java.sdk.DwollaServiceSync;
import com.dwolla.java.sdk.DwollaTypedBytes;
import com.dwolla.java.sdk.OAuthServiceSync;
import com.dwolla.java.sdk.requests.SendRequest;
import com.dwolla.java.sdk.requests.TokenRequest;
import com.dwolla.java.sdk.responses.BasicAccountInformationResponse;
import com.dwolla.java.sdk.responses.SendResponse;
import com.dwolla.java.sdk.responses.TokenResponse;
import com.google.gson.Gson;
import retrofit.RestAdapter;
import spark.Request;
import spark.Response;
import spark.Route;

import java.awt.*;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;

import static spark.Spark.get;

public class App {
    public final static String SCOPES = "Send|AccountInfoFull";
    public final static String REDIRECT_URI = "http://localhost:4567";
    public final static String CLIENT_ID = "6t3kALJ5lflODl74xDG5vZt1G0nVEIUAfb5TEglD/KepIQVyOy";
    public final static String CLIENT_SECRET = "cL8dAjRkTeSkXHjLINkVN9Jn+URVVuyVudZTI6IFOxSBsArJef";
    public final static String SENDER_PIN = "1234";
    // Use 812-713-9234 in production, any money sent to it will be sent right back to you
    public final static String DESTINATION_ID = "812-172-9684";

    public static void main(String[] args) {
        openBrowserToOAuthUrl();

        get(new Route("/") {
            @Override
            public Object handle(Request req, Response res) {
                TokenResponse tr = getToken(req.queryParams("code"));
                return callApi(tr.access_token);
            }
        });
    }

    private static void openBrowserToOAuthUrl() {
        try {
            Desktop.getDesktop().browse(
                    new URI(String.format("%s/authenticate?response_type=code&scope=%s&client_id=%s&redirect_uri=%s",
                            Urls.BASE_OAUTH_URL, encode(SCOPES), encode(CLIENT_ID), encode(REDIRECT_URI))));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static TokenResponse getToken(String code) {
        OAuthServiceSync oAuth = createOAuthService();
        return oAuth.getToken(new DwollaTypedBytes(new Gson(),
                new TokenRequest(CLIENT_ID, CLIENT_SECRET, "authorization_code", REDIRECT_URI, code)));
    }

    private static String callApi(String token) {
        DwollaServiceSync dwolla = createDwollaService();
        BasicAccountInformationResponse infoRes = dwolla.getBasicAccountInformation(DESTINATION_ID, CLIENT_ID, CLIENT_SECRET);
        SendResponse sendRes = dwolla.send(new DwollaTypedBytes(new Gson(), new SendRequest(token, SENDER_PIN, DESTINATION_ID, 0.01)));

        return String.format("Account name: \"%s\" Transaction Id: \"%s\"",
                infoRes.Success ? infoRes.Response.Name : infoRes.Message,
                sendRes.Success ? sendRes.Response : sendRes.Message);
    }

    private static OAuthServiceSync createOAuthService() {
        return new RestAdapter
                .Builder()
                .setEndpoint(Urls.BASE_OAUTH_URL)
                .build()
                .create(OAuthServiceSync.class);
    }

    private static DwollaServiceSync createDwollaService() {
        return new RestAdapter
                .Builder()
                .setEndpoint(Urls.BASE_URL)
                .build()
                .create(DwollaServiceSync.class);
    }

    private static String encode(String decoded) {
        try {
            return URLEncoder.encode(decoded, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
            return decoded;
        }
    }

}