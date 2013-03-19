package com.dwolla.java.sdk.responses;

public class RequestResponse extends Response {

   public int Response;

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = super.hashCode();
      result = prime * result + Response;
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
      RequestResponse other = (RequestResponse) obj;
      if (Response != other.Response)
         return false;
      return true;
   }

}
