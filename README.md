# `dwolla-java-sdk v1.2`

[![Build Status](https://travis-ci.org/therockstorm/dwolla-java-sdk.png?branch=master)](https://travis-ci.org/therockstorm/dwolla-java-sdk)

The [Dwolla API](http://developers.dwolla.com/dev) wrapper for Java and Android. See the DwollaServiceAsync and DwollaServiceSync classes for the supported endpoints. It usees the [Retrofit](https://github.com/square/retrofit) REST client by Square. For more information, see Retrofit's [samples](https://github.com/square/retrofit/tree/master/retrofit-samples).

## Using with Maven and Gradle

`dwolla-java-sdk` is published to [Maven Central](http://search.maven.org/#search%7Cga%7C1%7Ca%3A%22dwolla-java-sdk%22). To include it in a Maven project, include the following in pom.xml:
```xml
<dependency>
  <groupId>com.dwolla</groupId>
  <artifactId>dwolla-java-sdk</artifactId>
  <version>1.1.8</version>
</dependency>
```
For Gradle (Android's new default build automator), include the following in build.gradle:
```
dependencies {
  classpath 'com.dwolla:dwolla-java-sdk:1.1.8'
}
```

## Quick Start

* Open [App.java](https://github.com/Dwolla/dwolla-java/blob/master/samples/src/main/java/com/example/App.java) and take a look at the commented code
* If you haven't already, [register](https://www.dwolla.com/register) for a Dwolla account and follow the [Getting Started](https://developers.dwolla.com/dev/docs) documentation to [create an application](https://www.dwolla.com/applications/create) and [generate an OAuth token using your new application](https://developers.dwolla.com/dev/token)
* Enter your application key, secret, OAuth token, and PIN into the appropriate fields in App.java
* If you don't have it already, download Maven and follow the installation instructions [here](https://maven.apache.org/download.cgi)
* `git clone git@github.com:Dwolla/dwolla-java.git`
* `cd dwolla-java-sdk/samples`
* `mvn package`
* `java -cp target/dwolla-example-1.0-SNAPSHOT.jar com.example.App`
* You should see "Reflector by Dwolla" and two transaction Ids printed to the terminal

## Support

- Dwolla API | api@dwolla.com | [@DwollaAPI](https://twitter.com/DwollaAPI)
- Rocky Warren | rocky@dwolla.com | [@therockstorm](https://twitter.com/therockstorm)

## License

Copyright © 2014 Dwolla

[MIT License](http://www.opensource.org/licenses/mit-license.php)
