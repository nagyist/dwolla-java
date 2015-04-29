package com.dwolla.java.sdk.responses;

import com.dwolla.java.sdk.models.PendingRequest;

import java.util.Arrays;

public class PendingRequestsResponse extends Response {

    public PendingRequest[] Response;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PendingRequestsResponse)) return false;
        if (!super.equals(o)) return false;

        PendingRequestsResponse that = (PendingRequestsResponse) o;

        if (!Arrays.equals(Response, that.Response)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (Response != null ? Arrays.hashCode(Response) : 0);
        return result;
    }
}
