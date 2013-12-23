package com.dwolla.java.sdk.models;

public class UserContact {

    public String Name;
    public String Id;
    public String Type;
    public String Image;

    public UserContact(String name, String id, String type, String image) {
        super();
        Name = name;
        Id = id;
        Type = type;
        Image = image;
    }

    public UserContact() {
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((Id == null) ? 0 : Id.hashCode());
        result = prime * result + ((Image == null) ? 0 : Image.hashCode());
        result = prime * result + ((Name == null) ? 0 : Name.hashCode());
        result = prime * result + ((Type == null) ? 0 : Type.hashCode());
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
        UserContact other = (UserContact) obj;
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
        if (Name == null) {
            if (other.Name != null)
                return false;
        } else if (!Name.equals(other.Name))
            return false;
        if (Type == null) {
            if (other.Type != null)
                return false;
        } else if (!Type.equals(other.Type))
            return false;
        return true;
    }

}