package com.dwolla.java.sdk.models;

public class BasicFundingSource {

   public String Id;
   public String Name;
   public String Type;
   public boolean Verified;
   public String ProcessingType;

   public BasicFundingSource(String id, String name, String type, boolean verified, String processingType) {
      super();
      Id = id;
      Name = name;
      Type = type;
      Verified = verified;
      ProcessingType = processingType;
   }

   public BasicFundingSource() {
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((Id == null) ? 0 : Id.hashCode());
      result = prime * result + ((Name == null) ? 0 : Name.hashCode());
      result = prime * result + ((ProcessingType == null) ? 0 : ProcessingType.hashCode());
      result = prime * result + ((Type == null) ? 0 : Type.hashCode());
      result = prime * result + (Verified ? 1231 : 1237);
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
      BasicFundingSource other = (BasicFundingSource) obj;
      if (Id == null) {
         if (other.Id != null)
            return false;
      } else if (!Id.equals(other.Id))
         return false;
      if (Name == null) {
         if (other.Name != null)
            return false;
      } else if (!Name.equals(other.Name))
         return false;
      if (ProcessingType == null) {
         if (other.ProcessingType != null)
            return false;
      } else if (!ProcessingType.equals(other.ProcessingType))
         return false;
      if (Type == null) {
         if (other.Type != null)
            return false;
      } else if (!Type.equals(other.Type))
         return false;
      if (Verified != other.Verified)
         return false;
      return true;
   }

}