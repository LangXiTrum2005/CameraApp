package com.photolab.vintage.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DateUtil {
    const val FORMAT_DEFAULT = "MM.dd.yy / HH:mm"
    const val FORMAT_1 = "MM dd yy"
    const val FORMAT_2 = "dd MM yy"
    const val FORMAT_3 = "yy MM dd"
    const val FORMAT_4 = "MM/dd/yy"
    const val FORMAT_5 = "dd/MM/yyyy"
    const val FORMAT_6 = "yyyy.MM.dd"

    fun getCurrentDate(): String {
        return SimpleDateFormat("MM/dd/yy", Locale.US).format(Date())
    }

    fun getDateFormat(date: Date, format: String): String {
        return try {
            SimpleDateFormat(format, Locale.US).format(date)
        } catch (e: Exception) {
            SimpleDateFormat(FORMAT_DEFAULT, Locale.US).format(date)
        }
    }
}
