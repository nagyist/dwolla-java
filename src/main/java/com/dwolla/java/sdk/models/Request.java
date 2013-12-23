package com.dwolla.java.sdk.models;

public class Request {

    public int Id;
    public double Amount;
    public String Status;
    public UserContact Source;
    public UserContact Destination;

    public Request(int id, double amount, String status, UserContact source, UserContact destination) {
        super();
        Id = id;
        Amount = amount;
        Status = status;
        Source = source;
        Destination = destination;
    }

    public Request() {
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(Amount);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((Destination == null) ? 0 : Destination.hashCode());
        result = prime * result + Id;
        result = prime * result + ((Source == null) ? 0 : Source.hashCode());
        result = prime * result + ((Status == null) ? 0 : Status.hashCode());
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
        Request other = (Request) obj;
        if (Double.doubleToLongBits(Amount) != Double.doubleToLongBits(other.Amount))
            return false;
        if (Destination == null) {
            if (other.Destination != null)
                return false;
        } else if (!Destination.equals(other.Destination))
            return false;
        if (Id != other.Id)
            return false;
        if (Source == null) {
            if (other.Source != null)
                return false;
        } else if (!Source.equals(other.Source))
            return false;
        if (Status == null) {
            if (other.Status != null)
                return false;
        } else if (!Status.equals(other.Status))
            return false;
        return true;
    }

}
