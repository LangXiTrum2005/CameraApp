package com.photolab.vintage.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
public class DateUtil {
    public static final String FORMAT_1 = "MM dd yy";
    public static final String FORMAT_2 = "dd MM yy";
    public static final String FORMAT_3 = "yy MM dd";

    public static String getCurrentDate() {
        return new SimpleDateFormat("MM/dd/yy").format(new Date());
    }

    public static String getDateFormat(Date date, String str) {
        return new SimpleDateFormat(str).format(date);
    }
}
