package com.dwolla.java.sdk.models;

public class Links {

    public LinkDetails self;
    public LinkDetails send;
    public LinkDetails createScheduled;
    public LinkDetails fulfill;

    public Links(LinkDetails self, LinkDetails send, LinkDetails createScheduled, LinkDetails fulfill) {
        super();
        this.self = self;
        this.send = send;
        this.createScheduled = createScheduled;
        this.fulfill = fulfill;
    }

    public Links() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Links links = (Links) o;

        if (self != null ? !self.equals(links.self) : links.self != null) return false;
        if (send != null ? !send.equals(links.send) : links.send != null) return false;
        if (createScheduled != null ? !createScheduled.equals(links.createScheduled) : links.createScheduled != null)
            return false;
        return !(fulfill != null ? !fulfill.equals(links.fulfill) : links.fulfill != null);

    }

    @Override
    public int hashCode() {
        int result = self != null ? self.hashCode() : 0;
        result = 31 * result + (send != null ? send.hashCode() : 0);
        result = 31 * result + (createScheduled != null ? createScheduled.hashCode() : 0);
        result = 31 * result + (fulfill != null ? fulfill.hashCode() : 0);
        return result;
    }
}