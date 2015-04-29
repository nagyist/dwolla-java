package com.dwolla.java.sdk.requests;

public class RequestRequest {

    /**
     * Required
     */
    public String sourceId;
    public double amount;

    /**
     * Optional
     */
    public String sourceType = null; // See Consts.UserType
    public String facilitatorAmount = null;
    public String notes = null;

    public RequestRequest(String sourceId, double amount) {
        this.sourceId = sourceId;
        this.amount = amount;
    }

    public RequestRequest(String sourceId, double amount, String sourceType, String facilitatorAmount, String notes) {
        this(sourceId, amount);
        this.sourceType = sourceType;
        this.facilitatorAmount = facilitatorAmount;
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RequestRequest that = (RequestRequest) o;

        if (Double.compare(that.amount, amount) != 0) return false;
        if (sourceId != null ? !sourceId.equals(that.sourceId) : that.sourceId != null) return false;
        if (sourceType != null ? !sourceType.equals(that.sourceType) : that.sourceType != null) return false;
        if (facilitatorAmount != null ? !facilitatorAmount.equals(that.facilitatorAmount) : that.facilitatorAmount != null)
            return false;
        return !(notes != null ? !notes.equals(that.notes) : that.notes != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = sourceId != null ? sourceId.hashCode() : 0;
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (sourceType != null ? sourceType.hashCode() : 0);
        result = 31 * result + (facilitatorAmount != null ? facilitatorAmount.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        return result;
    }
}
