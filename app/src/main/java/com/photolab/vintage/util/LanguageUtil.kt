package com.photolab.vintage.util

import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import java.util.Locale

data class LanguageItem(
    val code: String,
    val displayName: String
)

object LanguageUtil {

    val LANGUAGE_LIST = listOf(
        LanguageItem("vi", "Tiếng Việt"),
        LanguageItem("en", "English"),
        LanguageItem("es", "Español"),
        LanguageItem("fr", "Français"),
        LanguageItem("de", "Deutsch"),
        LanguageItem("ja", "日本語"),
        LanguageItem("ko", "한국어"),
        LanguageItem("zh", "中文 (简体)"),
        LanguageItem("ru", "Русский"),
        LanguageItem("pt", "Português")
    )

    fun applyLanguage(context: Context, languageCode: String) {
        SharePreferenceUtil.setAppLanguage(context, languageCode)
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val resources = context.resources
        val config = Configuration(resources.configuration)
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)

        val localeList = LocaleListCompat.forLanguageTags(languageCode)
        AppCompatDelegate.setApplicationLocales(localeList)
    }

    fun getCurrentLanguageName(context: Context): String {
        val code = SharePreferenceUtil.getAppLanguage(context)
        return LANGUAGE_LIST.find { it.code.equals(code, ignoreCase = true) }?.displayName ?: "Tiếng Việt"
    }
}
