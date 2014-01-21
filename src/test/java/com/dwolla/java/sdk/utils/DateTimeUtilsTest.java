package com.dwolla.java.sdk.utils;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Assert;
import org.junit.Test;

public class DateTimeUtilsTest {

    @Test
    public void testGetCalendarFromUtcReturnsProperDateTime() {
        DateTime dt = DateTimeUtils.getCalendarFromUtc("2010-11-12T13:14:15Z");

        Assert.assertEquals(2010, dt.getYear());
        Assert.assertEquals(11, dt.getMonthOfYear());
        Assert.assertEquals(12, dt.getDayOfMonth());
        Assert.assertEquals(13, dt.getHourOfDay());
        Assert.assertEquals(14, dt.getMinuteOfHour());
        Assert.assertEquals(15, dt.getSecondOfMinute());
        Assert.assertEquals(DateTimeZone.forID("UTC"), dt.getZone());
    }

    @Test
    public void testGetLocalCalendarFromUtcReturnsProperDateTime() {
        String date = "2010-11-12T13:14:15Z";
        DateTime expectedDt = DateTime.parse(date).withZone(DateTimeZone.getDefault());

        DateTime actualDt = DateTimeUtils.getLocalCalendarFromUtc(date);
        Assert.assertEquals(expectedDt.getYear(), actualDt.getYear());
        Assert.assertEquals(expectedDt.getMonthOfYear(), actualDt.getMonthOfYear());
        Assert.assertEquals(expectedDt.getDayOfMonth(), actualDt.getDayOfMonth());
        Assert.assertEquals(expectedDt.getHourOfDay(), actualDt.getHourOfDay());
        Assert.assertEquals(expectedDt.getMinuteOfHour(), actualDt.getMinuteOfHour());
        Assert.assertEquals(expectedDt.getSecondOfMinute(), actualDt.getSecondOfMinute());
        Assert.assertNotEquals(DateTimeZone.forID("UTC"), actualDt.getZone());
    }

}
