package com.dwolla.java.sdk.models;

public class NearbyUser {

   public String Name;
   public String Id;
   public String Image;
   public double Latitude;
   public double Longitude;
   public double Delta;

   public NearbyUser(String name, String id, String image, double latitude, double longitude, double delta) {
      super();
      Name = name;
      Id = id;
      Image = image;
      Latitude = latitude;
      Longitude = longitude;
      Delta = delta;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      long temp;
      temp = Double.doubleToLongBits(Delta);
      result = prime * result + (int) (temp ^ (temp >>> 32));
      result = prime * result + ((Id == null) ? 0 : Id.hashCode());
      result = prime * result + ((Image == null) ? 0 : Image.hashCode());
      temp = Double.doubleToLongBits(Latitude);
      result = prime * result + (int) (temp ^ (temp >>> 32));
      temp = Double.doubleToLongBits(Longitude);
      result = prime * result + (int) (temp ^ (temp >>> 32));
      result = prime * result + ((Name == null) ? 0 : Name.hashCode());
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
      NearbyUser other = (NearbyUser) obj;
      if (Double.doubleToLongBits(Delta) != Double.doubleToLongBits(other.Delta))
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
      return true;
   }

}