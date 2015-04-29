package com.dwolla.java.sdk.models;

import java.util.Arrays;

public class TransactionSearchResult {

    public TransactionWithFees[] Results;
    public int TotalHits;

    public TransactionSearchResult(TransactionWithFees[] results, int totalHits) {
        super();
        Results = results;
        TotalHits = totalHits;
    }

    public TransactionSearchResult() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionSearchResult that = (TransactionSearchResult) o;

        if (TotalHits != that.TotalHits) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(Results, that.Results);

    }

    @Override
    public int hashCode() {
        int result = Results != null ? Arrays.hashCode(Results) : 0;
        result = 31 * result + TotalHits;
        return result;
    }
}
