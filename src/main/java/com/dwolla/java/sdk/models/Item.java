package com.dwolla.java.sdk.models;

import java.util.Map;

public class Item {

    /**
     * Required
     */
    public double amount;
    public String destination;

    /**
     * Optional
     */
    public String destinationType;
    public String notes;
    public Map<String, String> metadata;

    public Item(double amount, String destination) {
        this.amount = amount;
        this.destination = destination;
    }

    public Item(double amount, String destination, String destinationType, String notes, Map<String, String> metadata) {
        this(amount, destination);
        this.destinationType = destinationType;
        this.notes = notes;
        this.metadata = metadata;
    }

    public Item() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (Double.compare(item.amount, amount) != 0) return false;
        if (destination != null ? !destination.equals(item.destination) : item.destination != null) return false;
        if (destinationType != null ? !destinationType.equals(item.destinationType) : item.destinationType != null)
            return false;
        if (notes != null ? !notes.equals(item.notes) : item.notes != null) return false;
        return !(metadata != null ? !metadata.equals(item.metadata) : item.metadata != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(amount);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        result = 31 * result + (destinationType != null ? destinationType.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (metadata != null ? metadata.hashCode() : 0);
        return result;
    }
}
