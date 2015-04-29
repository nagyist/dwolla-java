package com.dwolla.java.sdk.requests;

import com.dwolla.java.sdk.models.Item;

import java.util.Arrays;

public class CreateJobRequest {

    /**
     * Required
     */
    public String fundingSource;
    public String pin;
    public Item[] items;

    /**
     * Optional
     */
    public String userJobId;
    public boolean assumeCosts;

    public CreateJobRequest(String fundingSource, String pin, Item[] items) {
        this.fundingSource = fundingSource;
        this.pin = pin;
        this.items = items;
    }

    public CreateJobRequest(String fundingSource, String pin, Item[] items, String userJobId, boolean assumeCosts) {
        this(fundingSource, pin, items);
        this.userJobId = userJobId;
        this.assumeCosts = assumeCosts;
    }

    public CreateJobRequest() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreateJobRequest that = (CreateJobRequest) o;

        if (assumeCosts != that.assumeCosts) return false;
        if (fundingSource != null ? !fundingSource.equals(that.fundingSource) : that.fundingSource != null)
            return false;
        if (pin != null ? !pin.equals(that.pin) : that.pin != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(items, that.items)) return false;
        return !(userJobId != null ? !userJobId.equals(that.userJobId) : that.userJobId != null);

    }

    @Override
    public int hashCode() {
        int result = fundingSource != null ? fundingSource.hashCode() : 0;
        result = 31 * result + (pin != null ? pin.hashCode() : 0);
        result = 31 * result + (items != null ? Arrays.hashCode(items) : 0);
        result = 31 * result + (userJobId != null ? userJobId.hashCode() : 0);
        result = 31 * result + (assumeCosts ? 1 : 0);
        return result;
    }
}
