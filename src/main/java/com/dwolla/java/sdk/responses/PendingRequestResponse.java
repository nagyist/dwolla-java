package com.dwolla.java.sdk.responses;

import com.dwolla.java.sdk.models.PendingRequest;

import java.util.Arrays;

public class PendingRequestResponse extends Response {

    public PendingRequest Response;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        PendingRequestResponse that = (PendingRequestResponse) o;

        return !(Response != null ? !Response.equals(that.Response) : that.Response != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (Response != null ? Response.hashCode() : 0);
        return result;
    }
}
