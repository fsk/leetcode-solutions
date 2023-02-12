package com.fsk;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


/**
 * LeetCode -> 1360. Number of Days Between Two Dates
 */
public class Main14 {

    public static void main(String[] args)  {

        System.out.println(daysBetweenDates("1971-06-29", "2010-09-23"));



    }

    public static int daysBetweenDates(String date1, String date2)  {

        String pattern = "yyyy-MM-dd";

        try {
            SimpleDateFormat format = new SimpleDateFormat(pattern);

            Date dateBefore = format.parse(date1);
            Date dateAfter = format.parse(date2);

            long dateBeforeInMs = dateBefore.getTime();
            long dateAfterInMs = dateAfter.getTime();

            long timeDiff = Math.abs(dateAfterInMs - dateBeforeInMs);

            long daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);

            return (int) daysDiff;
        }catch (Exception e) {
            e.getCause();
            return -1;
        }

    }
}
