package com.demo.mycryptoapp.utils

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

fun Date.convertTimestampToTime(timestamp: Long?): String {
    if (timestamp != null) {
        this.time = timestamp
    } else return ""

    val stamp = Timestamp(this.time * 1000)
    val date = Date(stamp.time)
    val pattern = "HH:mm:ss"
    val sdf = SimpleDateFormat(pattern, Locale.getDefault())
    sdf.timeZone = TimeZone.getDefault()
    return sdf.format(date)
}