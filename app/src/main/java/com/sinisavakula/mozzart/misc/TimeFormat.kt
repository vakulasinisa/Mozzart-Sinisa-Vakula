package com.sinisavakula.mozzart.misc

import android.annotation.SuppressLint
import android.util.Log
import java.text.SimpleDateFormat
import java.util.Date

@SuppressLint("SimpleDateFormat")
val timeFormat = SimpleDateFormat("HH:mm")

@SuppressLint("DefaultLocale")
fun formatTime(totalSeconds: Long): String {
    val totalMinutes = totalSeconds / 60
    val seconds = totalSeconds % 60
    return String.format("%d:%02d", totalMinutes, seconds)
}

fun Long.toRemainingTime():String {
    Log.d("TestTimeFormat", "time: " + this)
    val time = this - System.currentTimeMillis()
    return formatTime(time/1000)
}

fun Long.toSecond():Long {
    val time = this - System.currentTimeMillis()
    return time/1000
}

fun Long.toTime():String {
    val date = Date(this)
    return timeFormat.format(date)
}
