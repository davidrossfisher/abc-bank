package com.abc;

/*
 * Last modified by david on 10/31/2016.
 * Reimplemented singleton as enum
 * Since now function is not being used. I changed this to a data provider singleton
 */
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

//Original Code
//public class DateProvider {
//    private static DateProvider instance = null;
//
//    public static DateProvider getInstance() {
//        if (instance == null)
//            instance = new DateProvider();
//        return instance;
//    }
//
//    public Date now() {
//        return Calendar.getInstance().getTime();
//    }
//}
enum DataProvider {
    INSTANCE;

    AtomicLong id;

    DataProvider() {
        id = new AtomicLong(0);
    }

    public Date now() {
        return Calendar.getInstance().getTime();
    }

    public long getId() {
        return id.getAndIncrement();
    }
}
