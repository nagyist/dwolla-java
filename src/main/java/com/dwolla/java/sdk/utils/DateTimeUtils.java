package com.dwolla.java.sdk.utils;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class DateTimeUtils {

    public static DateTime fromUtc(String utcDateTime) {
        return DateTime.parse(utcDateTime);
    }

    public static DateTime localFromUtc(String utcDateTime) {
        return DateTime.parse(utcDateTime).withZone(DateTimeZone.getDefault());
    }

}
