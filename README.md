# dwolla-java-sdk v0.1

[![Build Status](https://travis-ci.org/therockstorm/dwolla-java-sdk.png?branch=master)](https://travis-ci.org/therockstorm/dwolla-java-sdk)

Java and Android SDK for Dwolla's API

## Requirements
- [Dwolla Application](https://www.dwolla.com/applications)

## Quick Start

This wrapper uses the [Retrofit](https://github.com/square/retrofit) REST client. See the [DwollaService](https://github.com/therockstorm/dwolla-java-sdk/blob/master/src/main/java/com/dwolla/java/sdk/DwollaService.java) class for the supported endpoints and Retrofit's [sample](https://github.com/square/retrofit/blob/master/samples/twitter-client/src/main/java/com/squareup/retrofit/sample/twitter/Client.java) for more details.

Create a callback that extends DwollaCallback with the correct Response object:
```java
private class BasicInformationCallback extends DwollaCallback<BasicAccountInformationResponse> {
      @Override
      public void success(BasicAccountInformationResponse response) {
         if (!response.Success || response.Response == null) {
            super.failure(response.Message);
         } else {
            // Handle response...
         }
      }

      @Override
      public void failure(RetrofitError error) {
         super.failure(error);
      }
   }
```
Then create the service and make the API call:
```java
DwollaService service = new RestAdapter.Builder().setServer(
   new Server("https://www.dwolla.com/oauth/rest")).build().create(DwollaService.class);
service.getBasicAccountInformation(accountId, mEncodedKey, mEncodedSecret, 
   new BasicInformationCallback());
```
Post requests are just as simple. After creating a callback and DwollaService as shown above, make the API call:
```java
service.send(new DwollaTypedBytes(new Gson(), 
   new SendRequest(mToken, pin, destinationId, amount)), new SendCallback());
```

## API Documentation

http://developers.dwolla.com/dev

## Support

- Dwolla API | api@dwolla.com | [@DwollaAPI](https://twitter.com/DwollaAPI)
- Rocky Warren | rocky@dwolla.com | [@therockstorm](https://twitter.com/therockstorm)

## License 

(MIT License)

Copyright (c) 2012 Dwolla

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the 'Software'), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED 'AS IS', WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
