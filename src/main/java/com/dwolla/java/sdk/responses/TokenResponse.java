package com.dwolla.java.sdk.responses;

public class TokenResponse {

    public String access_token;
    public int expires_in;
    public String refresh_token;
    public int refresh_expires_in;
    public String token_type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TokenResponse that = (TokenResponse) o;

        if (expires_in != that.expires_in) return false;
        if (refresh_expires_in != that.refresh_expires_in) return false;
        if (access_token != null ? !access_token.equals(that.access_token) : that.access_token != null) return false;
        if (refresh_token != null ? !refresh_token.equals(that.refresh_token) : that.refresh_token != null)
            return false;
        return !(token_type != null ? !token_type.equals(that.token_type) : that.token_type != null);
    }

    @Override
    public int hashCode() {
        int result = access_token != null ? access_token.hashCode() : 0;
        result = 31 * result + expires_in;
        result = 31 * result + (refresh_token != null ? refresh_token.hashCode() : 0);
        result = 31 * result + refresh_expires_in;
        result = 31 * result + (token_type != null ? token_type.hashCode() : 0);
        return result;
    }

}
