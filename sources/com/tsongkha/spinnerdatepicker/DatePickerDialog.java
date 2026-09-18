package com.tsongkha.spinnerdatepicker;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import java.text.DateFormat;
import java.util.Calendar;

/* JADX INFO: loaded from: classes2.dex */
public class DatePickerDialog extends AlertDialog implements DialogInterface.OnClickListener, OnDateChangedListener {
    private static final String DAY = "day";
    private static final String MONTH = "month";
    private static final String TITLE_SHOWN = "title_enabled";
    private static final String YEAR = "year";
    private final OnDateSetListener mCallBack;
    private final DatePicker mDatePicker;
    private boolean mIsDayShown;
    private boolean mIsTitleShown;
    private final DateFormat mTitleDateFormat;

    public interface OnDateSetListener {
        void onDateSet(DatePicker datePicker, int i, int i2, int i3);
    }

    DatePickerDialog(Context context, int i, int i2, OnDateSetListener onDateSetListener, Calendar calendar, Calendar calendar2, Calendar calendar3, boolean z, boolean z2) {
        super(context, i);
        this.mIsDayShown = true;
        this.mIsTitleShown = true;
        this.mCallBack = onDateSetListener;
        this.mTitleDateFormat = DateFormat.getDateInstance(1);
        this.mIsDayShown = z;
        this.mIsTitleShown = z2;
        updateTitle(calendar);
        setButton(-1, context.getText(android.R.string.ok), this);
        setButton(-2, context.getText(android.R.string.cancel), (DialogInterface.OnClickListener) null);
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.date_picker_dialog_container, (ViewGroup) null);
        setView(viewInflate);
        DatePicker datePicker = new DatePicker((ViewGroup) viewInflate, i2);
        this.mDatePicker = datePicker;
        datePicker.setMinDate(calendar2.getTimeInMillis());
        datePicker.setMaxDate(calendar3.getTimeInMillis());
        datePicker.init(calendar.get(1), calendar.get(2), calendar.get(5), z, this);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.mCallBack != null) {
            this.mDatePicker.clearFocus();
            OnDateSetListener onDateSetListener = this.mCallBack;
            DatePicker datePicker = this.mDatePicker;
            onDateSetListener.onDateSet(datePicker, datePicker.getYear(), this.mDatePicker.getMonth(), this.mDatePicker.getDayOfMonth());
        }
    }

    @Override // com.tsongkha.spinnerdatepicker.OnDateChangedListener
    public void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, i);
        calendar.set(2, i2);
        calendar.set(5, i3);
        updateTitle(calendar);
    }

    private void updateTitle(Calendar calendar) {
        if (this.mIsTitleShown) {
            setTitle(this.mTitleDateFormat.format(calendar.getTime()));
        } else {
            setTitle(" ");
        }
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        bundleOnSaveInstanceState.putInt(YEAR, this.mDatePicker.getYear());
        bundleOnSaveInstanceState.putInt(MONTH, this.mDatePicker.getMonth());
        bundleOnSaveInstanceState.putInt(DAY, this.mDatePicker.getDayOfMonth());
        bundleOnSaveInstanceState.putBoolean(TITLE_SHOWN, this.mIsTitleShown);
        return bundleOnSaveInstanceState;
    }

    @Override // android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        int i = bundle.getInt(YEAR);
        int i2 = bundle.getInt(MONTH);
        int i3 = bundle.getInt(DAY);
        this.mIsTitleShown = bundle.getBoolean(TITLE_SHOWN);
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, i);
        calendar.set(2, i2);
        calendar.set(5, i3);
        updateTitle(calendar);
        this.mDatePicker.init(i, i2, i3, this.mIsDayShown, this);
    }
}
