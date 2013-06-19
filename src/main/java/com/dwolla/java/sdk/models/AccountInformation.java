package com.dwolla.java.sdk.models;

public class AccountInformation extends BasicAccountInformation {

   public String City;
   public String State;
   public String Type;

   public AccountInformation(String id, String name, double latitude, double longitude, String city, String state, String type) {
      super(id, name, latitude, longitude);
      City = city;
      State = state;
      Type = type;
   }

   private AccountInformation() {
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = super.hashCode();
      result = prime * result + ((City == null) ? 0 : City.hashCode());
      result = prime * result + ((State == null) ? 0 : State.hashCode());
      result = prime * result + ((Type == null) ? 0 : Type.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (!super.equals(obj))
         return false;
      if (getClass() != obj.getClass())
         return false;
      AccountInformation other = (AccountInformation) obj;
      if (City == null) {
         if (other.City != null)
            return false;
      } else if (!City.equals(other.City))
         return false;
      if (State == null) {
         if (other.State != null)
            return false;
      } else if (!State.equals(other.State))
         return false;
      if (Type == null) {
         if (other.Type != null)
            return false;
      } else if (!Type.equals(other.Type))
         return false;
      return true;
   }

}