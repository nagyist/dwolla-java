# `dwolla-java-sdk v1.1.2`

[![Build Status](https://travis-ci.org/therockstorm/dwolla-java-sdk.png?branch=master)](https://travis-ci.org/therockstorm/dwolla-java-sdk)

The [Dwolla API](http://developers.dwolla.com/dev) wrapper for Java and Android.

## Quick Start

This wrapper uses the [Retrofit](https://github.com/square/retrofit) REST client. See the DwollaServiceAsync or DwollaServiceSync classes for the supported endpoints and Retrofit's [sample](https://github.com/square/retrofit/blob/master/samples/twitter-client/src/main/java/com/squareup/retrofit/sample/twitter/Client.java) for more details.

Create a callback that extends DwollaCallback with the correct Response object:
```java
    private class BasicInformationCallback extends DwollaCallback<BasicAccountInformationResponse> {
        @Override
        public void success(BasicAccountInformationResponse response, Response r) {
            if (response.Success)
                System.out.println("Success!");
            else
                super.failure(response.Message, this);
        }

        @Override
        public void failure(RetrofitError error) {
            super.failure(error.getMessage(), this);
        }
    }
```
Then create the service and make the API call:
```java
DwollaServiceAsync service = new RestAdapter.Builder().setServer(
   new Server("https://www.dwolla.com/oauth/rest")).build().create(DwollaServiceAsync.class);
service.getBasicAccountInformation(accountId, mEncodedKey, mEncodedSecret,
   new BasicInformationCallback());
```
Post requests are just as simple. After creating a callback and DwollaServiceAsync as shown above, make the API call:
```java
service.send(new DwollaTypedBytes(new Gson(),
   new SendRequest(mToken, pin, destinationId, amount)), new SendCallback());
```

## Support

- Dwolla API | api@dwolla.com | [@DwollaAPI](https://twitter.com/DwollaAPI)
- Rocky Warren | rocky@dwolla.com | [@therockstorm](https://twitter.com/therockstorm)

## License

Copyright © 2013 Dwolla

[MIT License](http://www.opensource.org/licenses/mit-license.php)
