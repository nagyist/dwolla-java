package com.dwolla.java.sdk.responses;

import com.dwolla.java.sdk.models.NearbySpot;

import java.util.Arrays;

public class NearbySpotsResponse extends Response {

    public NearbySpot[] Response;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Arrays.hashCode(Response);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        NearbySpotsResponse other = (NearbySpotsResponse) obj;
        if (!Arrays.equals(Response, other.Response))
            return false;
        return true;
    }

}
