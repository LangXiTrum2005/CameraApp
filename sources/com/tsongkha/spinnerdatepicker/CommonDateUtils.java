package com.tsongkha.spinnerdatepicker;

import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class CommonDateUtils {
    public static final int DEFAULT_HOUR = 8;
    public static final SimpleDateFormat NO_YEAR_DATE_FORMAT = new SimpleDateFormat("--MM-dd", Locale.US);
    public static final SimpleDateFormat FULL_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
    public static final SimpleDateFormat DATE_AND_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
    public static final SimpleDateFormat NO_YEAR_DATE_AND_TIME_FORMAT = new SimpleDateFormat("--MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
}
