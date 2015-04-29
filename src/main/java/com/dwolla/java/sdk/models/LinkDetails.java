package com.dwolla.java.sdk.models;

public class LinkDetails {

    public String href;
    public boolean templated;

    public LinkDetails(String href, boolean templated) {
        this.href = href;
        this.templated = templated;
    }

    public LinkDetails(String href) {
        this.href = href;
    }

    public LinkDetails() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LinkDetails that = (LinkDetails) o;

        if (templated != that.templated) return false;
        return !(href != null ? !href.equals(that.href) : that.href != null);

    }

    @Override
    public int hashCode() {
        int result = href != null ? href.hashCode() : 0;
        result = 31 * result + (templated ? 1 : 0);
        return result;
    }
}