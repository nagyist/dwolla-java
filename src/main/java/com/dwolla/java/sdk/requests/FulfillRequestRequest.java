package com.dwolla.java.sdk.requests;

public class FulfillRequestRequest {

    /**
     * Required
     */
    public String oauth_token;
    public String pin;
    public String request_id;
    public double amount;

    /**
     * Optional
     */
    public boolean assumeCosts = false;
    public String notes = null;
    public String fundsSource = null; // See Consts.FundingSource

    public FulfillRequestRequest(String oauth_token, String pin, String request_id, double amount) {
        super();
        this.oauth_token = oauth_token;
        this.pin = pin;
        this.request_id = request_id;
        this.amount = amount;
    }

    public FulfillRequestRequest(String oauth_token, String pin, String request_id, double amount, boolean assumeCosts, String notes,
                                 String fundsSource) {
        super();
        this.oauth_token = oauth_token;
        this.pin = pin;
        this.request_id = request_id;
        this.amount = amount;
        this.assumeCosts = assumeCosts;
        this.notes = notes;
        this.fundsSource = fundsSource;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(amount);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + (assumeCosts ? 1231 : 1237);
        result = prime * result + ((fundsSource == null) ? 0 : fundsSource.hashCode());
        result = prime * result + ((notes == null) ? 0 : notes.hashCode());
        result = prime * result + ((oauth_token == null) ? 0 : oauth_token.hashCode());
        result = prime * result + ((pin == null) ? 0 : pin.hashCode());
        result = prime * result + ((request_id == null) ? 0 : request_id.hashCode());
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
        FulfillRequestRequest other = (FulfillRequestRequest) obj;
        if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
            return false;
        if (assumeCosts != other.assumeCosts)
            return false;
        if (fundsSource == null) {
            if (other.fundsSource != null)
                return false;
        } else if (!fundsSource.equals(other.fundsSource))
            return false;
        if (notes == null) {
            if (other.notes != null)
                return false;
        } else if (!notes.equals(other.notes))
            return false;
        if (oauth_token == null) {
            if (other.oauth_token != null)
                return false;
        } else if (!oauth_token.equals(other.oauth_token))
            return false;
        if (pin == null) {
            if (other.pin != null)
                return false;
        } else if (!pin.equals(other.pin))
            return false;
        if (request_id == null) {
            if (other.request_id != null)
                return false;
        } else if (!request_id.equals(other.request_id))
            return false;
        return true;
    }

}
