package com.dwolla.java.sdk.requests;

public class FulfillRequestRequest {

    /**
     * Required
     */
    public String pin;
    public String request_id;
    public double amount;

    /**
     * Optional
     */
    public boolean assumeCosts = false;
    public String notes = null;
    public String fundsSource = null; // See Consts.FundingSource

    public FulfillRequestRequest(String pin, String request_id, double amount) {
        this.pin = pin;
        this.request_id = request_id;
        this.amount = amount;
    }

    public FulfillRequestRequest(String pin, String request_id, double amount, boolean assumeCosts, String notes, String fundsSource) {
        this(pin, request_id, amount);
        this.assumeCosts = assumeCosts;
        this.notes = notes;
        this.fundsSource = fundsSource;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FulfillRequestRequest that = (FulfillRequestRequest) o;

        if (Double.compare(that.amount, amount) != 0) return false;
        if (assumeCosts != that.assumeCosts) return false;
        if (pin != null ? !pin.equals(that.pin) : that.pin != null) return false;
        if (request_id != null ? !request_id.equals(that.request_id) : that.request_id != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;
        return !(fundsSource != null ? !fundsSource.equals(that.fundsSource) : that.fundsSource != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = pin != null ? pin.hashCode() : 0;
        result = 31 * result + (request_id != null ? request_id.hashCode() : 0);
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (assumeCosts ? 1 : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (fundsSource != null ? fundsSource.hashCode() : 0);
        return result;
    }
}
