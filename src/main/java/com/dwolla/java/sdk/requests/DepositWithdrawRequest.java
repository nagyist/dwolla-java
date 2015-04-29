package com.dwolla.java.sdk.requests;

public class DepositWithdrawRequest {

    /**
     * Required
     */
    public String pin;
    public double amount;

    public DepositWithdrawRequest(String pin, double amount) {
        this.pin = pin;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepositWithdrawRequest that = (DepositWithdrawRequest) o;

        if (Double.compare(that.amount, amount) != 0) return false;
        return !(pin != null ? !pin.equals(that.pin) : that.pin != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = pin != null ? pin.hashCode() : 0;
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
