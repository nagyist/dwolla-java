package com.dwolla.java.sdk.requests;

import com.dwolla.java.sdk.models.AdditionalFee;

import java.util.Arrays;
import java.util.Map;

public class SendRequest {

    /**
     * Required
     */
    public String pin;
    public String destinationId;
    public double amount;

    /**
     * Optional
     */
    public boolean assumeCosts = false;
    public String destinationType = null; // See Consts.UserType
    public String facilitatorAmount = null;
    public String notes = null;
    public String fundsSource = null; // See Consts.FundingSource
    public AdditionalFee[] additionalFees = null;
    public Map<String, String> metadata;

    public SendRequest(String pin, String destinationId, double amount) {
        this.pin = pin;
        this.destinationId = destinationId;
        this.amount = amount;
    }

    public SendRequest(String pin, String destinationId, double amount, boolean assumeCosts, String destinationType,
                       String facilitatorAmount, String notes, String fundsSource, AdditionalFee[] additionalFees,
                       Map<String, String> metadata) {
        this(pin, destinationId, amount);
        this.assumeCosts = assumeCosts;
        this.destinationType = destinationType;
        this.facilitatorAmount = facilitatorAmount;
        this.notes = notes;
        this.fundsSource = fundsSource;
        this.additionalFees = additionalFees;
        this.metadata = metadata;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SendRequest that = (SendRequest) o;

        if (Double.compare(that.amount, amount) != 0) return false;
        if (assumeCosts != that.assumeCosts) return false;
        if (pin != null ? !pin.equals(that.pin) : that.pin != null) return false;
        if (destinationId != null ? !destinationId.equals(that.destinationId) : that.destinationId != null)
            return false;
        if (destinationType != null ? !destinationType.equals(that.destinationType) : that.destinationType != null)
            return false;
        if (facilitatorAmount != null ? !facilitatorAmount.equals(that.facilitatorAmount) : that.facilitatorAmount != null)
            return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;
        if (fundsSource != null ? !fundsSource.equals(that.fundsSource) : that.fundsSource != null) return false;
        if (!Arrays.equals(additionalFees, that.additionalFees)) return false;
        return !(metadata != null ? !metadata.equals(that.metadata) : that.metadata != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = pin != null ? pin.hashCode() : 0;
        result = 31 * result + (destinationId != null ? destinationId.hashCode() : 0);
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (assumeCosts ? 1 : 0);
        result = 31 * result + (destinationType != null ? destinationType.hashCode() : 0);
        result = 31 * result + (facilitatorAmount != null ? facilitatorAmount.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (fundsSource != null ? fundsSource.hashCode() : 0);
        result = 31 * result + (additionalFees != null ? Arrays.hashCode(additionalFees) : 0);
        result = 31 * result + (metadata != null ? metadata.hashCode() : 0);
        return result;
    }
}
