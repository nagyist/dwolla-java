package com.dwolla.java.sdk.responses;

import com.dwolla.java.sdk.models.Job;

public class CreateJobResponse extends Response {

    public Job Response;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CreateJobResponse that = (CreateJobResponse) o;

        return !(Response != null ? !Response.equals(that.Response) : that.Response != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (Response != null ? Response.hashCode() : 0);
        return result;
    }
}
