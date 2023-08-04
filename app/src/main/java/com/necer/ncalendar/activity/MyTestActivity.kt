package com.necer.ncalendar.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.necer.calendar.BaseCalendar
import com.necer.calendar.Miui9Calendar
import com.necer.enumeration.CalendarType
import com.necer.listener.OnCalendarPageListener
import com.necer.ncalendar.R
import com.vv.xmvv_calendar.Adapter
import org.joda.time.LocalDate

class MyTestActivity : AppCompatActivity() {
    val calendar by lazy { findViewById<Miui9Calendar>(R.id.calenar) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_test)
        calendar.calendarAdapter = Adapter()
        calendar.setMonthCalendarPageListener(object : OnCalendarPageListener {
            override fun onPageInit(calendar: BaseCalendar, type: CalendarType) {

            }
            override fun onInstantiateItem(calendar: BaseCalendar, type: CalendarType, localDate: LocalDate) {
                Log.e("onInstantiateItem", "$localDate, $type")
            }

            override fun onDestroyItem(calendar: BaseCalendar, type: CalendarType, localDate: LocalDate) {
                //Log.e("onDestroyItem", "$localDate, $type")
            }
        })
    }
}