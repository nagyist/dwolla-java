# `dwolla-java-sdk v1.3.0`

[![Join the chat at https://gitter.im/Dwolla/dwolla-java](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/Dwolla/dwolla-java?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

[![Build Status](https://travis-ci.org/therockstorm/dwolla-java-sdk.png?branch=master)](https://travis-ci.org/therockstorm/dwolla-java-sdk)

The [Dwolla API](http://developers.dwolla.com/dev) wrapper for Java and Android. See the DwollaServiceAsync and DwollaServiceSync classes for the supported endpoints. It uses the [Retrofit](https://github.com/square/retrofit) REST client by Square. For more information, see Retrofit's [documentation](https://square.github.io/retrofit/).

## Using with Maven and Gradle

`dwolla-java-sdk` is published to [Maven Central](http://search.maven.org/#search%7Cga%7C1%7Ca%3A%22dwolla-java-sdk%22). To include it, add the following to pom.xml:
```xml
<dependency>
  <groupId>com.dwolla</groupId>
  <artifactId>dwolla-java-sdk</artifactId>
  <version>1.3.0</version>
</dependency>
```
For Gradle (Android's new default build automator), add the following to build.gradle:
```
dependencies {
  classpath 'com.dwolla:dwolla-java-sdk:1.3.0'
}
```

## Quick Start

* If you haven't already, [register](https://www.dwolla.com/register) for a Dwolla account and follow the [Getting Started](https://developers.dwolla.com/dev/docs) documentation to [create an application](https://www.dwolla.com/applications/create) and [generate an OAuth token using your new application](https://developers.dwolla.com/dev/token)
* `git clone git@github.com:Dwolla/dwolla-java.git`
* Open dwolla-java/samples/src/main/java/com/example/App.java and enter your application key, secret, OAuth token, and PIN
* Follow the instructions [here](https://maven.apache.org/download.cgi) to download and install Maven
* `cd dwolla-java/samples`
* `mvn package`
* `java -cp target/dwolla-example-1.0-SNAPSHOT.jar com.example.App`
* You should see "Reflector by Dwolla" and two transaction Ids printed to the terminal
* Log into your account at [dwolla.com](https://www.dwolla.com) to verify transactions with those Ids exist

## Support

- Dwolla API | api@dwolla.com | [@DwollaAPI](https://twitter.com/DwollaAPI)
- Rocky Warren | rocky@dwolla.com | [@therockstorm](https://twitter.com/therockstorm)

## License

Copyright © 2015 Dwolla

[MIT License](http://www.opensource.org/licenses/mit-license.php)
