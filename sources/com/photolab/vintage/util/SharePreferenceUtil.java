package com.photolab.vintage.util;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes2.dex */
public class SharePreferenceUtil {
    private static final String KEY_COUNTDOWN_SOUND_ENABLED = "countdown_sound_enabled";
    private static final String KEY_FIRST_RUN = "is_first_run";
    private static final String KEY_GRID_ENABLED = "grid_enabled";
    private static final String KEY_SAVE_ORIGINAL_ENABLED = "save_original_enabled";
    private static final String PHOTO_EDITOR_PRO_2019 = "VINTAGE_CAMERA";

    public static boolean isFirstRun(Context context) {
        return context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, 0).getBoolean(KEY_FIRST_RUN, true);
    }

    public static void setFirstRun(Context context, boolean z) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, 0).edit();
        editorEdit.putBoolean(KEY_FIRST_RUN, z);
        editorEdit.apply();
    }

    public static void setLongScreen(Context context, boolean z) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, 0).edit();
        editorEdit.putBoolean("long_screen", z);
        editorEdit.apply();
    }

    public static boolean isLongScreen(Context context) {
        return context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, 0).getBoolean("long_screen", false);
    }

    public static void setHeightOfKeyboard(Context context, int i) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, 0).edit();
        editorEdit.putInt("height_of_keyboard", i);
        editorEdit.apply();
    }

    public static int getHeightOfKeyboard(Context context) {
        return context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, 0).getInt("height_of_keyboard", -1);
    }

    public static void setHeightOfNotch(Context context, int i) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, 0).edit();
        editorEdit.putInt("height_of_notch", i);
        editorEdit.apply();
    }

    public static int getHeightOfNotch(Context context) {
        return context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, 0).getInt("height_of_notch", -1);
    }

    public static void setFirstAdjustBoob(Context context, boolean z) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, 0).edit();
        editorEdit.putBoolean("first_boob", z);
        editorEdit.apply();
    }

    public static boolean isFirstAdjustBoob(Context context) {
        return context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, 0).getBoolean("first_boob", true);
    }

    public static void setFirstAdjustWaist(Context context, boolean z) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, 0).edit();
        editorEdit.putBoolean("first_waise", z);
        editorEdit.apply();
    }

    public static boolean isFirstAdjustWaise(Context context) {
        return context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, 0).getBoolean("first_waise", true);
    }

    public static void setFirstAdjustFace(Context context, boolean z) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, 0).edit();
        editorEdit.putBoolean("first_face", z);
        editorEdit.apply();
    }

    public static boolean isFirstAdjusFace(Context context) {
        return context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, 0).getBoolean("first_face", true);
    }

    public static void setFirstAdjustHip(Context context, boolean z) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, 0).edit();
        editorEdit.putBoolean("first_hip", z);
        editorEdit.apply();
    }

    public static boolean isFirstAdjusHip(Context context) {
        return context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, 0).getBoolean("first_hip", true);
    }

    public static void setFirstShapeSplash(Context context, boolean z) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, 0).edit();
        editorEdit.putBoolean("first_shape_splash", z);
        editorEdit.apply();
    }

    public static boolean isFirstShapeSplash(Context context) {
        if (context == null) {
            return false;
        }
        return context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, 0).getBoolean("first_shape_splash", true);
    }

    public static void setFirstDrawSplash(Context context, boolean z) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, 0).edit();
        editorEdit.putBoolean("first_draw_splash", z);
        editorEdit.apply();
    }

    public static boolean isFirstDrawSplash(Context context) {
        if (context == null) {
            return false;
        }
        return context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, 0).getBoolean("first_draw_splash", true);
    }

    public static void setFirstShapeBlur(Context context, boolean z) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, 0).edit();
        editorEdit.putBoolean("first_shape_blur", z);
        editorEdit.apply();
    }

    public static boolean isFirstShapeBlur(Context context) {
        if (context == null) {
            return false;
        }
        return context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, 0).getBoolean("first_shape_blur", true);
    }

    public static void setFirstDrawBlur(Context context, boolean z) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, 0).edit();
        editorEdit.putBoolean("first_draw_blur", z);
        editorEdit.apply();
    }

    public static boolean isFirstDrawBlur(Context context) {
        if (context == null) {
            return false;
        }
        return context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, 0).getBoolean("first_draw_blur", true);
    }

    public static boolean isPurchased(Context context) {
        return context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, 0).getBoolean("is_purchased", false);
    }

    public static void setIsPurchased(Context context, boolean z) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, 0).edit();
        editorEdit.putBoolean("is_purchased", z);
        editorEdit.apply();
    }

    public static boolean isFromEU(Context context) {
        return context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, 0).getBoolean("is_from_eu", false);
    }

    public static void setFromEU(Context context, boolean z) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, 0).edit();
        editorEdit.putBoolean("is_from_eu", z);
        editorEdit.apply();
    }

    public static boolean isCheckedUserFromEU(Context context) {
        return context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, 0).getBoolean("is_checked_user_from_eu", false);
    }

    public static void setCheckedUserFromEU(Context context, boolean z) {
        if (context != null) {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, 0).edit();
            editorEdit.putBoolean("is_checked_user_from_eu", z);
            editorEdit.apply();
        }
    }

    public static boolean isRated(Context context) {
        return context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, 0).getBoolean("is_rated", false);
    }

    public static void setRated(Context context, boolean z) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, 0).edit();
        editorEdit.putBoolean("is_rated", z);
        editorEdit.apply();
    }

    public static void increateCounter(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, 0).edit();
        editorEdit.putInt("counter", getCounter(context) + 1);
        editorEdit.apply();
    }

    public static int getCounter(Context context) {
        return context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, 0).getInt("counter", 1);
    }

    public static void setGridEnabled(Context context, boolean z) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, 0).edit();
        editorEdit.putBoolean(KEY_GRID_ENABLED, z);
        editorEdit.apply();
    }

    public static boolean isGridEnabled(Context context) {
        return context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, 0).getBoolean(KEY_GRID_ENABLED, true);
    }

    public static void setCountdownSoundEnabled(Context context, boolean z) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, 0).edit();
        editorEdit.putBoolean(KEY_COUNTDOWN_SOUND_ENABLED, z);
        editorEdit.apply();
    }

    public static boolean isCountdownSoundEnabled(Context context) {
        return context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, 0).getBoolean(KEY_COUNTDOWN_SOUND_ENABLED, true);
    }

    public static void setSaveOriginalEnabled(Context context, boolean z) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, 0).edit();
        editorEdit.putBoolean(KEY_SAVE_ORIGINAL_ENABLED, z);
        editorEdit.apply();
    }

    public static boolean isSaveOriginalEnabled(Context context) {
        return context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, 0).getBoolean(KEY_SAVE_ORIGINAL_ENABLED, false);
    }

    public static int getCredits(Context context) {
        return context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, 0).getInt("user_credits", 5);
    }

    public static void setCredits(Context context, int i) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, 0).edit();
        editorEdit.putInt("user_credits", i);
        editorEdit.apply();
    }

    public static void addCredits(Context context, int i) {
        setCredits(context, getCredits(context) + i);
    }

    public static boolean deductCredit(Context context) {
        int credits = getCredits(context);
        if (credits <= 0) {
            return false;
        }
        setCredits(context, credits - 1);
        return true;
    }
}
