package com.dwolla.java.sdk.models;

import java.util.Arrays;

public class TransactionWithFees extends Transaction {

    public Transaction[] Fees;

    public TransactionWithFees(int id, double amount, String date, String type, String userType, String destinationId, String destinationName,
                               String sourceId, String sourceName, String clearingDate, String status, String notes, Transaction[] fees) {
        super(id, amount, date, type, userType, destinationId, destinationName, sourceId, sourceName, clearingDate, status, notes);
        Fees = fees;
    }

    public TransactionWithFees() {
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Arrays.hashCode(Fees);
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
        TransactionWithFees other = (TransactionWithFees) obj;
        return Arrays.equals(Fees, other.Fees);
    }

}