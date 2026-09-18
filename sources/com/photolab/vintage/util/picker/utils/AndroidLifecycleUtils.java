package com.photolab.vintage.util.picker.utils;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes2.dex */
public class AndroidLifecycleUtils {
    public static boolean canLoadImage(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return canLoadImage((Activity) fragment.getActivity());
    }

    public static boolean canLoadImage(Context context) {
        if (context == null || !(context instanceof Activity)) {
            return true;
        }
        return canLoadImage((Activity) context);
    }

    public static boolean canLoadImage(Activity activity) {
        if (activity == null) {
            return true;
        }
        return (activity.isDestroyed() || activity.isFinishing()) ? false : true;
    }
}
