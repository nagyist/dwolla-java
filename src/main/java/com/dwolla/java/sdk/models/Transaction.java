package com.dwolla.java.sdk.models;

import java.util.Map;

public class Transaction {

    public int Id;
    public double Amount;
    public String Date;
    public String Type;
    public String UserType;
    public String DestinationId;
    public String DestinationName;
    public String SourceId;
    public String SourceName;
    public String ClearingDate;
    public String Status;
    public String Notes;
    public Map<String, String> Metadata;

    public Transaction(int id, double amount, String date, String type, String userType, String destinationId,
                       String destinationName, String sourceId, String sourceName, String clearingDate, String status,
                       String notes, Map<String, String> metadata) {
        Id = id;
        Amount = amount;
        Date = date;
        Type = type;
        UserType = userType;
        DestinationId = destinationId;
        DestinationName = destinationName;
        SourceId = sourceId;
        SourceName = sourceName;
        ClearingDate = clearingDate;
        Status = status;
        Notes = notes;
        Metadata = metadata;
    }

    public Transaction() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (Id != that.Id) return false;
        if (Double.compare(that.Amount, Amount) != 0) return false;
        if (Date != null ? !Date.equals(that.Date) : that.Date != null) return false;
        if (Type != null ? !Type.equals(that.Type) : that.Type != null) return false;
        if (UserType != null ? !UserType.equals(that.UserType) : that.UserType != null) return false;
        if (DestinationId != null ? !DestinationId.equals(that.DestinationId) : that.DestinationId != null)
            return false;
        if (DestinationName != null ? !DestinationName.equals(that.DestinationName) : that.DestinationName != null)
            return false;
        if (SourceId != null ? !SourceId.equals(that.SourceId) : that.SourceId != null) return false;
        if (SourceName != null ? !SourceName.equals(that.SourceName) : that.SourceName != null) return false;
        if (ClearingDate != null ? !ClearingDate.equals(that.ClearingDate) : that.ClearingDate != null) return false;
        if (Status != null ? !Status.equals(that.Status) : that.Status != null) return false;
        if (Notes != null ? !Notes.equals(that.Notes) : that.Notes != null) return false;
        return !(Metadata != null ? !Metadata.equals(that.Metadata) : that.Metadata != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = Id;
        temp = Double.doubleToLongBits(Amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (Date != null ? Date.hashCode() : 0);
        result = 31 * result + (Type != null ? Type.hashCode() : 0);
        result = 31 * result + (UserType != null ? UserType.hashCode() : 0);
        result = 31 * result + (DestinationId != null ? DestinationId.hashCode() : 0);
        result = 31 * result + (DestinationName != null ? DestinationName.hashCode() : 0);
        result = 31 * result + (SourceId != null ? SourceId.hashCode() : 0);
        result = 31 * result + (SourceName != null ? SourceName.hashCode() : 0);
        result = 31 * result + (ClearingDate != null ? ClearingDate.hashCode() : 0);
        result = 31 * result + (Status != null ? Status.hashCode() : 0);
        result = 31 * result + (Notes != null ? Notes.hashCode() : 0);
        result = 31 * result + (Metadata != null ? Metadata.hashCode() : 0);
        return result;
    }
}
