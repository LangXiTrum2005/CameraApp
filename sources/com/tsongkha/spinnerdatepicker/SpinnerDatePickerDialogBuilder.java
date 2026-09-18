package com.tsongkha.spinnerdatepicker;

import android.content.Context;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: loaded from: classes2.dex */
public class SpinnerDatePickerDialogBuilder {
    private DatePickerDialog.OnDateSetListener callBack;
    private Context context;
    private boolean isDayShown = true;
    private boolean isTitleShown = true;
    private int theme = 0;
    private int spinnerTheme = 0;
    private Calendar defaultDate = new GregorianCalendar(1980, 0, 1);
    private Calendar minDate = new GregorianCalendar(1900, 0, 1);
    private Calendar maxDate = new GregorianCalendar(2100, 0, 1);

    public SpinnerDatePickerDialogBuilder context(Context context) {
        this.context = context;
        return this;
    }

    public SpinnerDatePickerDialogBuilder callback(DatePickerDialog.OnDateSetListener onDateSetListener) {
        this.callBack = onDateSetListener;
        return this;
    }

    public SpinnerDatePickerDialogBuilder dialogTheme(int i) {
        this.theme = i;
        return this;
    }

    public SpinnerDatePickerDialogBuilder spinnerTheme(int i) {
        this.spinnerTheme = i;
        return this;
    }

    public SpinnerDatePickerDialogBuilder defaultDate(int i, int i2, int i3) {
        this.defaultDate = new GregorianCalendar(i, i2, i3);
        return this;
    }

    public SpinnerDatePickerDialogBuilder minDate(int i, int i2, int i3) {
        this.minDate = new GregorianCalendar(i, i2, i3);
        return this;
    }

    public SpinnerDatePickerDialogBuilder maxDate(int i, int i2, int i3) {
        this.maxDate = new GregorianCalendar(i, i2, i3);
        return this;
    }

    public SpinnerDatePickerDialogBuilder showDaySpinner(boolean z) {
        this.isDayShown = z;
        return this;
    }

    public SpinnerDatePickerDialogBuilder showTitle(boolean z) {
        this.isTitleShown = z;
        return this;
    }

    public DatePickerDialog build() {
        if (this.context == null) {
            throw new IllegalArgumentException("Context must not be null");
        }
        if (this.maxDate.getTime().getTime() <= this.minDate.getTime().getTime()) {
            throw new IllegalArgumentException("Max date is not after Min date");
        }
        return new DatePickerDialog(this.context, this.theme, this.spinnerTheme, this.callBack, this.defaultDate, this.minDate, this.maxDate, this.isDayShown, this.isTitleShown);
    }
}
