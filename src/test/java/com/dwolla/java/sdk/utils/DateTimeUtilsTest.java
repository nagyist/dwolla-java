package com.dwolla.java.sdk.utils;

import org.junit.Assert;
import org.junit.Test;

import javax.xml.bind.DatatypeConverter;
import java.util.Calendar;
import java.util.TimeZone;

public class DateTimeUtilsTest {

    @Test
    public void testGetCalendarFromUtcReturnsProperDateTime() {
        Calendar c = DateTimeUtils.getCalendarFromUtc("2010-11-12T13:14:15Z");
        Assert.assertEquals(2010, c.get(Calendar.YEAR));
        Assert.assertEquals(11 - 1, c.get(Calendar.MONTH)); // Subtract 1 since months are 0-based
        Assert.assertEquals(12, c.get(Calendar.DAY_OF_MONTH));
        Assert.assertEquals(13, c.get(Calendar.HOUR_OF_DAY));
        Assert.assertEquals(14, c.get(Calendar.MINUTE));
        Assert.assertEquals(15, c.get(Calendar.SECOND));
        Assert.assertEquals(TimeZone.getTimeZone("GMT+00:00"), c.getTimeZone());
    }

    @Test
    public void testGetLocalCalendarFromUtcReturnsProperDateTime() {
        String date = "2010-11-12T13:14:15Z";
        Calendar expectedCal = DatatypeConverter.parseDateTime(date);
        TimeZone expectedTz = Calendar.getInstance().getTimeZone();
        expectedCal.add(Calendar.MILLISECOND, expectedTz.getOffset(expectedCal.getTime().getTime()));

        Calendar actualCal = DateTimeUtils.getLocalCalendarFromUtc(date);
        Assert.assertEquals(expectedCal.get(Calendar.YEAR), actualCal.get(Calendar.YEAR));
        Assert.assertEquals(expectedCal.get(Calendar.MONTH), actualCal.get(Calendar.MONTH));
        Assert.assertEquals(expectedCal.get(Calendar.DAY_OF_MONTH), actualCal.get(Calendar.DAY_OF_MONTH));
        Assert.assertEquals(expectedCal.get(Calendar.HOUR_OF_DAY), actualCal.get(Calendar.HOUR_OF_DAY));
        Assert.assertEquals(expectedCal.get(Calendar.MINUTE), actualCal.get(Calendar.MINUTE));
        Assert.assertEquals(expectedCal.get(Calendar.SECOND), actualCal.get(Calendar.SECOND));
        Assert.assertEquals(expectedTz, actualCal.getTimeZone());
    }

}
