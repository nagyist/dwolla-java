package com.dwolla.java.sdk.models;

public class NearbySpot {

    public String Address;
    public String City;
    public String State;
    public String Group;
    public String Id;
    public String Image;
    public double Latitude;
    public double Longitude;
    public String Name;
    public String PostalCode;

    public NearbySpot(String address, String city, String state, String group, String id, String image, double latitude, double longitude,
                      String name, String postalCode) {
        super();
        Address = address;
        City = city;
        State = state;
        Group = group;
        Id = id;
        Image = image;
        Latitude = latitude;
        Longitude = longitude;
        Name = name;
        PostalCode = postalCode;
    }

    public NearbySpot() {
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((Address == null) ? 0 : Address.hashCode());
        result = prime * result + ((City == null) ? 0 : City.hashCode());
        result = prime * result + ((Group == null) ? 0 : Group.hashCode());
        result = prime * result + ((Id == null) ? 0 : Id.hashCode());
        result = prime * result + ((Image == null) ? 0 : Image.hashCode());
        long temp;
        temp = Double.doubleToLongBits(Latitude);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(Longitude);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((Name == null) ? 0 : Name.hashCode());
        result = prime * result + ((PostalCode == null) ? 0 : PostalCode.hashCode());
        result = prime * result + ((State == null) ? 0 : State.hashCode());
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
        NearbySpot other = (NearbySpot) obj;
        if (Address == null) {
            if (other.Address != null)
                return false;
        } else if (!Address.equals(other.Address))
            return false;
        if (City == null) {
            if (other.City != null)
                return false;
        } else if (!City.equals(other.City))
            return false;
        if (Group == null) {
            if (other.Group != null)
                return false;
        } else if (!Group.equals(other.Group))
            return false;
        if (Id == null) {
            if (other.Id != null)
                return false;
        } else if (!Id.equals(other.Id))
            return false;
        if (Image == null) {
            if (other.Image != null)
                return false;
        } else if (!Image.equals(other.Image))
            return false;
        if (Double.doubleToLongBits(Latitude) != Double.doubleToLongBits(other.Latitude))
            return false;
        if (Double.doubleToLongBits(Longitude) != Double.doubleToLongBits(other.Longitude))
            return false;
        if (Name == null) {
            if (other.Name != null)
                return false;
        } else if (!Name.equals(other.Name))
            return false;
        if (PostalCode == null) {
            if (other.PostalCode != null)
                return false;
        } else if (!PostalCode.equals(other.PostalCode))
            return false;
        if (State == null) {
            if (other.State != null)
                return false;
        } else if (!State.equals(other.State))
            return false;
        return true;
    }

}