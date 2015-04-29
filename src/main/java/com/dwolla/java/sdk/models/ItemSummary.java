package com.dwolla.java.sdk.models;

public class ItemSummary {

    public int Count;
    public int Completed;
    public int Successful;

    public ItemSummary(int count, int completed, int successful) {

        Count = count;
        Completed = completed;
        Successful = successful;
    }

    public ItemSummary() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemSummary that = (ItemSummary) o;

        if (Count != that.Count) return false;
        if (Completed != that.Completed) return false;
        return Successful == that.Successful;

    }

    @Override
    public int hashCode() {
        int result = Count;
        result = 31 * result + Completed;
        result = 31 * result + Successful;
        return result;
    }
}
