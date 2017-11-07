package com.georgehigbie.autotimecard.Models

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by georgehigbie on 11/4/17.
 */
class TimeEntry {

    var date:Date = Date()
    var dayOfWeek: SimpleDateFormat = SimpleDateFormat("EEEE")
    var dateReadable: SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    var timeReadable: SimpleDateFormat = SimpleDateFormat("HH:mm")
    //var clockIn: Boolean

}