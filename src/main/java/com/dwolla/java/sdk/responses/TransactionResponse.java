package com.dwolla.java.sdk.responses;


import com.dwolla.java.sdk.models.TransactionWithFees;

public class TransactionResponse extends Response {

    public TransactionWithFees Response;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        TransactionResponse that = (TransactionResponse) o;

        if (Response != null ? !Response.equals(that.Response) : that.Response != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (Response != null ? Response.hashCode() : 0);
        return result;
    }
}
