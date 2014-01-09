package com.dwolla.java.sdk.utils;

import javax.xml.bind.DatatypeConverter;
import java.util.Calendar;
import java.util.TimeZone;

public class DateTimeUtils {

    public static Calendar getCalendarFrom(String date) {
        return DatatypeConverter.parseDateTime(date);
    }

    public static Calendar getLocalCalendarFrom(String date) {
        Calendar c = DatatypeConverter.parseDateTime(date);
        TimeZone tz = Calendar.getInstance().getTimeZone();
        c.setTimeZone(tz);
        c.add(Calendar.MILLISECOND, tz.getOffset(c.getTime().getTime()));
        return c;
    }
}
