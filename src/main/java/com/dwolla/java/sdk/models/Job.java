package com.dwolla.java.sdk.models;

public class Job {

    public String Id;
    public String UserJobId;
    public boolean AssumeCosts;
    public String FundingSource;
    public double Total;
    public double Fees;
    public String CreatedDate;
    public String Status;
    public ItemSummary ItemSummary;

    public Job(String id, String userJobId, boolean assumeCosts, String fundingSource, double total, double fees,
               String createdDate, String status, ItemSummary itemSummary) {
        Id = id;
        UserJobId = userJobId;
        AssumeCosts = assumeCosts;
        FundingSource = fundingSource;
        Total = total;
        Fees = fees;
        CreatedDate = createdDate;
        Status = status;
        ItemSummary = itemSummary;
    }

    public Job() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Job job = (Job) o;

        if (AssumeCosts != job.AssumeCosts) return false;
        if (Double.compare(job.Total, Total) != 0) return false;
        if (Double.compare(job.Fees, Fees) != 0) return false;
        if (Id != null ? !Id.equals(job.Id) : job.Id != null) return false;
        if (UserJobId != null ? !UserJobId.equals(job.UserJobId) : job.UserJobId != null) return false;
        if (FundingSource != null ? !FundingSource.equals(job.FundingSource) : job.FundingSource != null) return false;
        if (CreatedDate != null ? !CreatedDate.equals(job.CreatedDate) : job.CreatedDate != null) return false;
        if (Status != null ? !Status.equals(job.Status) : job.Status != null) return false;
        return !(ItemSummary != null ? !ItemSummary.equals(job.ItemSummary) : job.ItemSummary != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = Id != null ? Id.hashCode() : 0;
        result = 31 * result + (UserJobId != null ? UserJobId.hashCode() : 0);
        result = 31 * result + (AssumeCosts ? 1 : 0);
        result = 31 * result + (FundingSource != null ? FundingSource.hashCode() : 0);
        temp = Double.doubleToLongBits(Total);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(Fees);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (CreatedDate != null ? CreatedDate.hashCode() : 0);
        result = 31 * result + (Status != null ? Status.hashCode() : 0);
        result = 31 * result + (ItemSummary != null ? ItemSummary.hashCode() : 0);
        return result;
    }
}
