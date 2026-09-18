package com.tsongkha.spinnerdatepicker;

import android.widget.EditText;
import android.widget.NumberPicker;

/* JADX INFO: loaded from: classes2.dex */
public class NumberPickers {
    public static EditText findEditText(NumberPicker numberPicker) {
        for (int i = 0; i < numberPicker.getChildCount(); i++) {
            if (numberPicker.getChildAt(i) instanceof EditText) {
                return (EditText) numberPicker.getChildAt(i);
            }
        }
        return null;
    }
}
