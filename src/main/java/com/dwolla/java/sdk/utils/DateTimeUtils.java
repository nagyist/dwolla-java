package com.dwolla.java.sdk.utils;

import javax.xml.bind.DatatypeConverter;
import java.util.Calendar;
import java.util.TimeZone;

public class DateTimeUtils {

    public static Calendar getCalendarFromUtc(String utcDateTime) {
        return parseDateTime(utcDateTime);
    }

    public static Calendar getLocalCalendarFromUtc(String utcDateTime) {
        Calendar c = parseDateTime(utcDateTime);
        TimeZone tz = Calendar.getInstance().getTimeZone();
        c.setTimeZone(tz);
        c.add(Calendar.MILLISECOND, tz.getOffset(c.getTime().getTime()));
        return c;
    }

    private static Calendar parseDateTime(String utcDateTime) {
        return DatatypeConverter.parseDateTime(utcDateTime);
    }

}
