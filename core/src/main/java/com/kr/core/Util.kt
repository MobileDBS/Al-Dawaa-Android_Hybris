package com.kr.core

import java.text.SimpleDateFormat
import java.time.Instant
import java.time.format.DateTimeFormatter
import java.util.*

fun ConvertMinutesTimeToHHMMString(minutesTime: Long): Long {
    val df = SimpleDateFormat("dd-MM-yyyy HH:mm:s", Locale.US)
   val currentDate = System.currentTimeMillis() // Current timeStamp in seconds
    val minToMillis = minutesTime * 60 //switch token time in min to seconds
    val timeStampFinal:Long = currentDate + minToMillis
    val result = df.format(Date(timeStampFinal)) //format expire date
    Logger("convert",true).log(" now in timeStamp: $currentDate , token millis $minToMillis ,result in timeStamp: $timeStampFinal , reult in date: $result")
    return timeStampFinal
}
