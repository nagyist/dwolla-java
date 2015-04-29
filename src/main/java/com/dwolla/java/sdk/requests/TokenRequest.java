package com.dwolla.java.sdk.requests;

public class TokenRequest {

    public String client_id;
    public String client_secret;
    public String grant_type;
    public String redirect_uri;
    public String code;
    public String refresh_token;

    // To refresh authorization
    public TokenRequest(String client_id, String client_secret, String grant_type, String refresh_token) {
        this.client_id = client_id;
        this.client_secret = client_secret;
        this.grant_type = grant_type;
        this.refresh_token = refresh_token;
    }

    // To finish authorization
    public TokenRequest(String client_id, String client_secret, String grant_type, String redirect_uri, String code) {
        this(client_id, client_secret, grant_type, null);
        this.redirect_uri = redirect_uri;
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TokenRequest that = (TokenRequest) o;

        if (client_id != null ? !client_id.equals(that.client_id) : that.client_id != null) return false;
        if (client_secret != null ? !client_secret.equals(that.client_secret) : that.client_secret != null)
            return false;
        if (grant_type != null ? !grant_type.equals(that.grant_type) : that.grant_type != null) return false;
        if (redirect_uri != null ? !redirect_uri.equals(that.redirect_uri) : that.redirect_uri != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        return !(refresh_token != null ? !refresh_token.equals(that.refresh_token) : that.refresh_token != null);

    }

    @Override
    public int hashCode() {
        int result = client_id != null ? client_id.hashCode() : 0;
        result = 31 * result + (client_secret != null ? client_secret.hashCode() : 0);
        result = 31 * result + (grant_type != null ? grant_type.hashCode() : 0);
        result = 31 * result + (redirect_uri != null ? redirect_uri.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (refresh_token != null ? refresh_token.hashCode() : 0);
        return result;
    }
}
