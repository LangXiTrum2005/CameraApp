package com.photolab.vintage.util

import android.content.Context

object SharePreferenceUtil {
    private const val PHOTO_EDITOR_PRO_2019 = "VINTAGE_CAMERA"
    private const val KEY_FIRST_RUN = "is_first_run"
    private const val KEY_GRID_ENABLED = "grid_enabled"
    private const val KEY_COUNTDOWN_SOUND_ENABLED = "countdown_sound_enabled"
    private const val KEY_SAVE_ORIGINAL_ENABLED = "save_original_enabled"
    private const val KEY_MIRROR_FRONT_CAMERA_ENABLED = "mirror_front_camera_enabled"
    private const val KEY_APP_LANGUAGE = "app_language"

    fun isFirstRun(context: Context): Boolean =
        context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, Context.MODE_PRIVATE).getBoolean(KEY_FIRST_RUN, true)

    fun setFirstRun(context: Context, value: Boolean) {
        context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, Context.MODE_PRIVATE).edit().putBoolean(KEY_FIRST_RUN, value).apply()
    }

    fun isPurchased(context: Context): Boolean =
        context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, Context.MODE_PRIVATE).getBoolean("is_purchased", false)

    fun setIsPurchased(context: Context, value: Boolean) {
        context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, Context.MODE_PRIVATE).edit().putBoolean("is_purchased", value).apply()
    }

    fun isGridEnabled(context: Context): Boolean =
        context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, Context.MODE_PRIVATE).getBoolean(KEY_GRID_ENABLED, true)

    fun setGridEnabled(context: Context, value: Boolean) {
        context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, Context.MODE_PRIVATE).edit().putBoolean(KEY_GRID_ENABLED, value).apply()
    }

    fun isCountdownSoundEnabled(context: Context): Boolean =
        context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, Context.MODE_PRIVATE).getBoolean(KEY_COUNTDOWN_SOUND_ENABLED, true)

    fun setCountdownSoundEnabled(context: Context, value: Boolean) {
        context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, Context.MODE_PRIVATE).edit().putBoolean(KEY_COUNTDOWN_SOUND_ENABLED, value).apply()
    }

    fun isSaveOriginalEnabled(context: Context): Boolean =
        context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, Context.MODE_PRIVATE).getBoolean(KEY_SAVE_ORIGINAL_ENABLED, false)

    fun setSaveOriginalEnabled(context: Context, value: Boolean) {
        context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, Context.MODE_PRIVATE).edit().putBoolean(KEY_SAVE_ORIGINAL_ENABLED, value).apply()
    }

    fun isMirrorFrontCameraEnabled(context: Context): Boolean =
        context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, Context.MODE_PRIVATE).getBoolean(KEY_MIRROR_FRONT_CAMERA_ENABLED, true)

    fun setMirrorFrontCameraEnabled(context: Context, value: Boolean) {
        context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, Context.MODE_PRIVATE).edit().putBoolean(KEY_MIRROR_FRONT_CAMERA_ENABLED, value).apply()
    }

    fun getAppLanguage(context: Context): String =
        context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, Context.MODE_PRIVATE).getString(KEY_APP_LANGUAGE, "vi") ?: "vi"

    fun setAppLanguage(context: Context, value: String) {
        context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, Context.MODE_PRIVATE).edit().putString(KEY_APP_LANGUAGE, value).apply()
    }

    fun getCredits(context: Context): Int =
        context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, Context.MODE_PRIVATE).getInt("user_credits", 5)

    fun setCredits(context: Context, value: Int) {
        context.getSharedPreferences(PHOTO_EDITOR_PRO_2019, Context.MODE_PRIVATE).edit().putInt("user_credits", value).apply()
    }

    fun deductCredit(context: Context): Boolean {
        val credits = getCredits(context)
        if (credits <= 0) return false
        setCredits(context, credits - 1)
        return true
    }
}
