package com.dwolla.java.sdk.models;

public class Request {

    public int Id;
    public double Amount;
    public String Status;
    public UserContact Source;
    public UserContact Destination;
    public String Notes;

    public Request(int id, double amount, String status, UserContact source, UserContact destination, String notes) {
        super();
        Id = id;
        Amount = amount;
        Status = status;
        Source = source;
        Destination = destination;
        Notes = notes;
    }

    public Request() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Request)) return false;

        Request request = (Request) o;

        if (Double.compare(request.Amount, Amount) != 0) return false;
        if (Id != request.Id) return false;
        if (Destination != null ? !Destination.equals(request.Destination) : request.Destination != null) return false;
        if (Notes != null ? !Notes.equals(request.Notes) : request.Notes != null) return false;
        if (Source != null ? !Source.equals(request.Source) : request.Source != null) return false;
        if (Status != null ? !Status.equals(request.Status) : request.Status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = Id;
        temp = Double.doubleToLongBits(Amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (Status != null ? Status.hashCode() : 0);
        result = 31 * result + (Source != null ? Source.hashCode() : 0);
        result = 31 * result + (Destination != null ? Destination.hashCode() : 0);
        result = 31 * result + (Notes != null ? Notes.hashCode() : 0);
        return result;
    }
}
