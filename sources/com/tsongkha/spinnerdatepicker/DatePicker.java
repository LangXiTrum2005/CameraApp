package com.tsongkha.spinnerdatepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import com.google.android.material.timepicker.TimeModel;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class DatePicker extends FrameLayout {
    private static final String DATE_FORMAT = "MM/dd/yyyy";
    private static final boolean DEFAULT_ENABLED_STATE = true;
    private Context mContext;
    private Calendar mCurrentDate;
    private final DateFormat mDateFormat;
    private NumberPicker mDaySpinner;
    private EditText mDaySpinnerInput;
    private boolean mIsDayShown;
    private boolean mIsEnabled;
    private Calendar mMaxDate;
    private Calendar mMinDate;
    private NumberPicker mMonthSpinner;
    private EditText mMonthSpinnerInput;
    private int mNumberOfMonths;
    private OnDateChangedListener mOnDateChangedListener;
    private LinearLayout mPickerContainer;
    private String[] mShortMonths;
    private Calendar mTempDate;
    private NumberPicker mYearSpinner;
    private EditText mYearSpinnerInput;

    DatePicker(ViewGroup viewGroup, int i) {
        super(viewGroup.getContext());
        this.mDateFormat = new SimpleDateFormat(DATE_FORMAT);
        this.mIsEnabled = true;
        this.mIsDayShown = true;
        this.mContext = viewGroup.getContext();
        setCurrentLocale(Locale.getDefault());
        LayoutInflater layoutInflater = (LayoutInflater) new ContextThemeWrapper(this.mContext, i).getSystemService("layout_inflater");
        layoutInflater.inflate(R.layout.date_picker_container, (ViewGroup) this, true);
        this.mPickerContainer = (LinearLayout) findViewById(R.id.parent);
        NumberPicker.OnValueChangeListener onValueChangeListener = new NumberPicker.OnValueChangeListener() { // from class: com.tsongkha.spinnerdatepicker.DatePicker.1
            @Override // android.widget.NumberPicker.OnValueChangeListener
            public void onValueChange(NumberPicker numberPicker, int i2, int i3) {
                DatePicker.this.updateInputState();
                DatePicker.this.mTempDate.setTimeInMillis(DatePicker.this.mCurrentDate.getTimeInMillis());
                if (numberPicker == DatePicker.this.mDaySpinner) {
                    int actualMaximum = DatePicker.this.mTempDate.getActualMaximum(5);
                    if (i2 == actualMaximum && i3 == 1) {
                        DatePicker.this.mTempDate.add(5, 1);
                    } else if (i2 != 1 || i3 != actualMaximum) {
                        DatePicker.this.mTempDate.add(5, i3 - i2);
                    } else {
                        DatePicker.this.mTempDate.add(5, -1);
                    }
                } else if (numberPicker == DatePicker.this.mMonthSpinner) {
                    if (i2 == 11 && i3 == 0) {
                        DatePicker.this.mTempDate.add(2, 1);
                    } else if (i2 != 0 || i3 != 11) {
                        DatePicker.this.mTempDate.add(2, i3 - i2);
                    } else {
                        DatePicker.this.mTempDate.add(2, -1);
                    }
                } else if (numberPicker == DatePicker.this.mYearSpinner) {
                    DatePicker.this.mTempDate.set(1, i3);
                } else {
                    throw new IllegalArgumentException();
                }
                DatePicker datePicker = DatePicker.this;
                datePicker.setDate(datePicker.mTempDate.get(1), DatePicker.this.mTempDate.get(2), DatePicker.this.mTempDate.get(5));
                DatePicker.this.updateSpinners();
                DatePicker.this.notifyDateChanged();
            }
        };
        NumberPicker numberPicker = (NumberPicker) layoutInflater.inflate(R.layout.number_picker_day_month, (ViewGroup) this.mPickerContainer, false);
        this.mDaySpinner = numberPicker;
        numberPicker.setId(R.id.day);
        this.mDaySpinner.setFormatter(new TwoDigitFormatter());
        this.mDaySpinner.setOnLongPressUpdateInterval(100L);
        this.mDaySpinner.setOnValueChangedListener(onValueChangeListener);
        this.mDaySpinnerInput = NumberPickers.findEditText(this.mDaySpinner);
        NumberPicker numberPicker2 = (NumberPicker) layoutInflater.inflate(R.layout.number_picker_day_month, (ViewGroup) this.mPickerContainer, false);
        this.mMonthSpinner = numberPicker2;
        numberPicker2.setId(R.id.month);
        this.mMonthSpinner.setMinValue(0);
        this.mMonthSpinner.setMaxValue(this.mNumberOfMonths - 1);
        this.mMonthSpinner.setDisplayedValues(this.mShortMonths);
        this.mMonthSpinner.setOnLongPressUpdateInterval(200L);
        this.mMonthSpinner.setOnValueChangedListener(onValueChangeListener);
        this.mMonthSpinnerInput = NumberPickers.findEditText(this.mMonthSpinner);
        NumberPicker numberPicker3 = (NumberPicker) layoutInflater.inflate(R.layout.number_picker_year, (ViewGroup) this.mPickerContainer, false);
        this.mYearSpinner = numberPicker3;
        numberPicker3.setId(R.id.year);
        this.mYearSpinner.setOnLongPressUpdateInterval(100L);
        this.mYearSpinner.setOnValueChangedListener(onValueChangeListener);
        this.mYearSpinnerInput = NumberPickers.findEditText(this.mYearSpinner);
        this.mCurrentDate.setTimeInMillis(System.currentTimeMillis());
        reorderSpinners();
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        viewGroup.addView(this);
    }

    void init(int i, int i2, int i3, boolean z, OnDateChangedListener onDateChangedListener) {
        this.mIsDayShown = z;
        setDate(i, i2, i3);
        updateSpinners();
        this.mOnDateChangedListener = onDateChangedListener;
        notifyDateChanged();
    }

    void updateDate(int i, int i2, int i3) {
        if (isNewDate(i, i2, i3)) {
            setDate(i, i2, i3);
            updateSpinners();
            notifyDateChanged();
        }
    }

    int getYear() {
        return this.mCurrentDate.get(1);
    }

    int getMonth() {
        return this.mCurrentDate.get(2);
    }

    int getDayOfMonth() {
        return this.mCurrentDate.get(5);
    }

    void setMinDate(long j) {
        this.mTempDate.setTimeInMillis(j);
        if (this.mTempDate.get(1) == this.mMinDate.get(1) && this.mTempDate.get(6) == this.mMinDate.get(6)) {
            return;
        }
        this.mMinDate.setTimeInMillis(j);
        if (this.mCurrentDate.before(this.mMinDate)) {
            this.mCurrentDate.setTimeInMillis(this.mMinDate.getTimeInMillis());
        }
        updateSpinners();
    }

    void setMaxDate(long j) {
        this.mTempDate.setTimeInMillis(j);
        if (this.mTempDate.get(1) == this.mMaxDate.get(1) && this.mTempDate.get(6) == this.mMaxDate.get(6)) {
            return;
        }
        this.mMaxDate.setTimeInMillis(j);
        if (this.mCurrentDate.after(this.mMaxDate)) {
            this.mCurrentDate.setTimeInMillis(this.mMaxDate.getTimeInMillis());
        }
        updateSpinners();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        this.mDaySpinner.setEnabled(z);
        this.mMonthSpinner.setEnabled(z);
        this.mYearSpinner.setEnabled(z);
        this.mIsEnabled = z;
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        setCurrentLocale(configuration.locale);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    protected void setCurrentLocale(Locale locale) {
        this.mTempDate = getCalendarForLocale(this.mTempDate, locale);
        this.mMinDate = getCalendarForLocale(this.mMinDate, locale);
        this.mMaxDate = getCalendarForLocale(this.mMaxDate, locale);
        this.mCurrentDate = getCalendarForLocale(this.mCurrentDate, locale);
        this.mNumberOfMonths = this.mTempDate.getActualMaximum(2) + 1;
        this.mShortMonths = new DateFormatSymbols().getShortMonths();
        if (usingNumericMonths()) {
            this.mShortMonths = new String[this.mNumberOfMonths];
            int i = 0;
            while (i < this.mNumberOfMonths) {
                int i2 = i + 1;
                this.mShortMonths[i] = String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(i2));
                i = i2;
            }
        }
    }

    private boolean usingNumericMonths() {
        return Character.isDigit(this.mShortMonths[0].charAt(0));
    }

    private Calendar getCalendarForLocale(Calendar calendar, Locale locale) {
        if (calendar == null) {
            return Calendar.getInstance(locale);
        }
        long timeInMillis = calendar.getTimeInMillis();
        Calendar calendar2 = Calendar.getInstance(locale);
        calendar2.setTimeInMillis(timeInMillis);
        return calendar2;
    }

    private void reorderSpinners() {
        this.mPickerContainer.removeAllViews();
        char[] dateFormatOrder = ICU.getDateFormatOrder(android.text.format.DateFormat.getBestDateTimePattern(Locale.getDefault(), "yyyyMMMdd"));
        int length = dateFormatOrder.length;
        for (int i = 0; i < length; i++) {
            char c = dateFormatOrder[i];
            if (c == 'M') {
                this.mPickerContainer.addView(this.mMonthSpinner);
                setImeOptions(this.mMonthSpinner, length, i);
            } else if (c == 'd') {
                this.mPickerContainer.addView(this.mDaySpinner);
                setImeOptions(this.mDaySpinner, length, i);
            } else if (c == 'y') {
                this.mPickerContainer.addView(this.mYearSpinner);
                setImeOptions(this.mYearSpinner, length, i);
            } else {
                throw new IllegalArgumentException(Arrays.toString(dateFormatOrder));
            }
        }
    }

    private String getOrderJellyBeanMr2() {
        DateFormat mediumDateFormat;
        if (this.mShortMonths[0].startsWith("1")) {
            mediumDateFormat = android.text.format.DateFormat.getDateFormat(getContext());
        } else {
            mediumDateFormat = android.text.format.DateFormat.getMediumDateFormat(getContext());
        }
        if (mediumDateFormat instanceof SimpleDateFormat) {
            return ((SimpleDateFormat) mediumDateFormat).toPattern();
        }
        return new String(android.text.format.DateFormat.getDateFormatOrder(getContext()));
    }

    private boolean isNewDate(int i, int i2, int i3) {
        return (this.mCurrentDate.get(1) == i && this.mCurrentDate.get(2) == i2 && this.mCurrentDate.get(5) == i3) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDate(int i, int i2, int i3) {
        this.mCurrentDate.set(i, i2, i3);
        if (this.mCurrentDate.before(this.mMinDate)) {
            this.mCurrentDate.setTimeInMillis(this.mMinDate.getTimeInMillis());
        } else if (this.mCurrentDate.after(this.mMaxDate)) {
            this.mCurrentDate.setTimeInMillis(this.mMaxDate.getTimeInMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSpinners() {
        this.mDaySpinner.setVisibility(this.mIsDayShown ? 0 : 8);
        if (this.mCurrentDate.equals(this.mMinDate)) {
            this.mDaySpinner.setMinValue(this.mCurrentDate.get(5));
            this.mDaySpinner.setMaxValue(this.mCurrentDate.getActualMaximum(5));
            this.mDaySpinner.setWrapSelectorWheel(false);
            this.mMonthSpinner.setDisplayedValues(null);
            this.mMonthSpinner.setMinValue(this.mCurrentDate.get(2));
            this.mMonthSpinner.setMaxValue(this.mCurrentDate.getActualMaximum(2));
            this.mMonthSpinner.setWrapSelectorWheel(false);
        } else if (this.mCurrentDate.equals(this.mMaxDate)) {
            this.mDaySpinner.setMinValue(this.mCurrentDate.getActualMinimum(5));
            this.mDaySpinner.setMaxValue(this.mCurrentDate.get(5));
            this.mDaySpinner.setWrapSelectorWheel(false);
            this.mMonthSpinner.setDisplayedValues(null);
            this.mMonthSpinner.setMinValue(this.mCurrentDate.getActualMinimum(2));
            this.mMonthSpinner.setMaxValue(this.mCurrentDate.get(2));
            this.mMonthSpinner.setWrapSelectorWheel(false);
        } else {
            this.mDaySpinner.setMinValue(1);
            this.mDaySpinner.setMaxValue(this.mCurrentDate.getActualMaximum(5));
            this.mDaySpinner.setWrapSelectorWheel(true);
            this.mMonthSpinner.setDisplayedValues(null);
            this.mMonthSpinner.setMinValue(0);
            this.mMonthSpinner.setMaxValue(11);
            this.mMonthSpinner.setWrapSelectorWheel(true);
        }
        this.mMonthSpinner.setDisplayedValues((String[]) Arrays.copyOfRange(this.mShortMonths, this.mMonthSpinner.getMinValue(), this.mMonthSpinner.getMaxValue() + 1));
        this.mYearSpinner.setMinValue(this.mMinDate.get(1));
        this.mYearSpinner.setMaxValue(this.mMaxDate.get(1));
        this.mYearSpinner.setWrapSelectorWheel(false);
        this.mYearSpinner.setValue(this.mCurrentDate.get(1));
        this.mMonthSpinner.setValue(this.mCurrentDate.get(2));
        this.mDaySpinner.setValue(this.mCurrentDate.get(5));
        if (usingNumericMonths()) {
            this.mMonthSpinnerInput.setRawInputType(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDateChanged() {
        sendAccessibilityEvent(4);
        OnDateChangedListener onDateChangedListener = this.mOnDateChangedListener;
        if (onDateChangedListener != null) {
            onDateChangedListener.onDateChanged(this, getYear(), getMonth(), getDayOfMonth());
        }
    }

    private void setImeOptions(NumberPicker numberPicker, int i, int i2) {
        NumberPickers.findEditText(numberPicker).setImeOptions(i2 < i + (-1) ? 5 : 6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInputState() {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            if (inputMethodManager.isActive(this.mYearSpinnerInput)) {
                this.mYearSpinnerInput.clearFocus();
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this.mMonthSpinnerInput)) {
                this.mMonthSpinnerInput.clearFocus();
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this.mDaySpinnerInput)) {
                this.mDaySpinnerInput.clearFocus();
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            }
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.mCurrentDate, this.mMinDate, this.mMaxDate, this.mIsDayShown);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        Calendar calendar = Calendar.getInstance();
        this.mCurrentDate = calendar;
        calendar.setTimeInMillis(savedState.currentDate);
        Calendar calendar2 = Calendar.getInstance();
        this.mMinDate = calendar2;
        calendar2.setTimeInMillis(savedState.minDate);
        Calendar calendar3 = Calendar.getInstance();
        this.mMaxDate = calendar3;
        calendar3.setTimeInMillis(savedState.maxDate);
        updateSpinners();
    }

    private static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.tsongkha.spinnerdatepicker.DatePicker.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        final long currentDate;
        final boolean isDaySpinnerShown;
        final long maxDate;
        final long minDate;

        SavedState(Parcelable parcelable, Calendar calendar, Calendar calendar2, Calendar calendar3, boolean z) {
            super(parcelable);
            this.currentDate = calendar.getTimeInMillis();
            this.minDate = calendar2.getTimeInMillis();
            this.maxDate = calendar3.getTimeInMillis();
            this.isDaySpinnerShown = z;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.currentDate = parcel.readLong();
            this.minDate = parcel.readLong();
            this.maxDate = parcel.readLong();
            this.isDaySpinnerShown = parcel.readByte() != 0;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.currentDate);
            parcel.writeLong(this.minDate);
            parcel.writeLong(this.maxDate);
            parcel.writeByte(this.isDaySpinnerShown ? (byte) 1 : (byte) 0);
        }
    }
}
