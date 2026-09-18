package com.tsongkha.spinnerdatepicker;

import android.widget.NumberPicker;
import com.google.android.material.timepicker.TimeModel;
import java.text.DecimalFormatSymbols;
import java.util.Formatter;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class TwoDigitFormatter implements NumberPicker.Formatter {
    Formatter mFmt;
    char mZeroDigit;
    final StringBuilder mBuilder = new StringBuilder();
    final Object[] mArgs = new Object[1];

    public TwoDigitFormatter() {
        init(Locale.getDefault());
    }

    private void init(Locale locale) {
        this.mFmt = createFormatter(locale);
        this.mZeroDigit = getZeroDigit(locale);
    }

    @Override // android.widget.NumberPicker.Formatter
    public String format(int i) {
        Locale locale = Locale.getDefault();
        if (this.mZeroDigit != getZeroDigit(locale)) {
            init(locale);
        }
        this.mArgs[0] = Integer.valueOf(i);
        StringBuilder sb = this.mBuilder;
        sb.delete(0, sb.length());
        this.mFmt.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, this.mArgs);
        return this.mFmt.toString();
    }

    private static char getZeroDigit(Locale locale) {
        return DecimalFormatSymbols.getInstance(locale).getZeroDigit();
    }

    private Formatter createFormatter(Locale locale) {
        return new Formatter(this.mBuilder, locale);
    }
}
