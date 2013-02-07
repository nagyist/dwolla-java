package com.dwolla.java.sdk.models;

public class BasicAccountInformation {

   public String Id;
   public String Name;
   public double Latitude;
   public double Longitude;

   public BasicAccountInformation(String id, String name, double latitude, double longitude) {
      super();
      Id = id;
      Name = name;
      Latitude = latitude;
      Longitude = longitude;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((Id == null) ? 0 : Id.hashCode());
      long temp;
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
      BasicAccountInformation other = (BasicAccountInformation) obj;
      if (Id == null) {
         if (other.Id != null)
            return false;
      } else if (!Id.equals(other.Id))
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