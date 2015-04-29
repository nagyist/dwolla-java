package com.dwolla.java.sdk.requests;

import com.dwolla.java.sdk.models.AdditionalFee;

import java.util.Arrays;

public class SendRequest {

    /**
     * Required
     */
    public String oauth_token;
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

    public SendRequest(String oauth_token, String pin, String destinationId, double amount) {
        super();
        this.oauth_token = oauth_token;
        this.pin = pin;
        this.destinationId = destinationId;
        this.amount = amount;
    }

    public SendRequest(String oauth_token, String pin, String destinationId, double amount, boolean assumeCosts, String destinationType,
                       String facilitatorAmount, String notes, String fundsSource, AdditionalFee[] additionalFees) {
        this(oauth_token, pin, destinationId, amount);
        this.assumeCosts = assumeCosts;
        this.destinationType = destinationType;
        this.facilitatorAmount = facilitatorAmount;
        this.notes = notes;
        this.fundsSource = fundsSource;
        this.additionalFees = additionalFees;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(additionalFees);
        long temp;
        temp = Double.doubleToLongBits(amount);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + (assumeCosts ? 1231 : 1237);
        result = prime * result + ((destinationId == null) ? 0 : destinationId.hashCode());
        result = prime * result + ((destinationType == null) ? 0 : destinationType.hashCode());
        result = prime * result + ((facilitatorAmount == null) ? 0 : facilitatorAmount.hashCode());
        result = prime * result + ((fundsSource == null) ? 0 : fundsSource.hashCode());
        result = prime * result + ((notes == null) ? 0 : notes.hashCode());
        result = prime * result + ((oauth_token == null) ? 0 : oauth_token.hashCode());
        result = prime * result + ((pin == null) ? 0 : pin.hashCode());
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
        SendRequest other = (SendRequest) obj;
        if (!Arrays.equals(additionalFees, other.additionalFees))
            return false;
        if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
            return false;
        if (assumeCosts != other.assumeCosts)
            return false;
        if (destinationId == null) {
            if (other.destinationId != null)
                return false;
        } else if (!destinationId.equals(other.destinationId))
            return false;
        if (destinationType == null) {
            if (other.destinationType != null)
                return false;
        } else if (!destinationType.equals(other.destinationType))
            return false;
        if (facilitatorAmount == null) {
            if (other.facilitatorAmount != null)
                return false;
        } else if (!facilitatorAmount.equals(other.facilitatorAmount))
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
        return true;
    }

}
