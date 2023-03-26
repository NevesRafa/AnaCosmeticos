package com.rafaelneves.anacosmeticos.internal.extension

import java.text.SimpleDateFormat
import java.util.*

object FormatterDateExt {

    fun stringToDate(dateAsString: String, dateFormat: String): Date? {
        val formatter = SimpleDateFormat(dateFormat)
        return formatter.parse(dateAsString)
    }

    fun formatMilliToDate(dateInMilli: Long): String? {
        val calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
        calendar.timeInMillis = dateInMilli

        val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        formatter.timeZone = TimeZone.getTimeZone("UTC")
        return formatter.format(calendar.time)
    }
}