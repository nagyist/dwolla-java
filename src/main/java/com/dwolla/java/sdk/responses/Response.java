package com.dwolla.java.sdk.responses;

import com.dwolla.java.sdk.models.Links;

public class Response {

    public boolean Success;
    public String Message;
    public Links _links;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((Message == null) ? 0 : Message.hashCode());
        result = prime * result + (Success ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Response other = (Response) obj;
        if (Message == null) {
            if (other.Message != null)
                return false;
        } else if (!Message.equals(other.Message))
            return false;
        if (Success != other.Success)
            return false;
        return true;
    }

}
