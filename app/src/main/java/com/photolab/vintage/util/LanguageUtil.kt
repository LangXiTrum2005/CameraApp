package com.photolab.vintage.util

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import com.photolab.vintage.R
import com.photolab.vintage.util.bean.LanguageModel
import java.util.Locale

data class LanguageItem(val code: String, val displayName: String)

object LanguageUtil {
    val POPULAR_LANGUAGES = listOf(
        LanguageModel("en", "English", "English", R.drawable.ic_flag_en),
        LanguageModel("vi", "Tiếng Việt", "Vietnamese", R.drawable.ic_flag_vi),
        LanguageModel("zh-CN", "简体中文", "Chinese (Simplified)", R.drawable.ic_flag_cn),
        LanguageModel("es", "Español", "Spanish", R.drawable.ic_flag_es),
        LanguageModel("fr", "Français", "French", R.drawable.ic_flag_fr),
        LanguageModel("de", "Deutsch", "German", R.drawable.ic_flag_de),
        LanguageModel("pt", "Português", "Portuguese", R.drawable.ic_flag_pt),
        LanguageModel("id", "Bahasa Indonesia", "Indonesian", R.drawable.ic_flag_id),
        LanguageModel("hi", "हिन्दी", "Hindi", R.drawable.ic_flag_hi),
        LanguageModel("ja", "日本語", "Japanese", R.drawable.ic_flag_ja),
        LanguageModel("ko", "한국어", "Korean", R.drawable.ic_flag_ko)
    )

    val LANGUAGE_LIST = POPULAR_LANGUAGES.map { LanguageItem(it.code, it.nameNative) }

    fun applyLanguage(context: Context, languageCode: String) {
        SharePreferenceUtil.setAppLanguage(context, languageCode)
        Locale.setDefault(Locale.forLanguageTag(languageCode))
        AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags(languageCode))
    }

    fun getCurrentLanguageName(context: Context): String {
        val code = SharePreferenceUtil.getAppLanguage(context)
        return POPULAR_LANGUAGES.find { it.code.equals(code, ignoreCase = true) }?.nameNative ?: "Tiếng Việt"
    }
}
