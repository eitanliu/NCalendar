package com.vv.xmvv_calendar

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.necer.ncalendar.R
import com.necer.painter.CalendarAdapter
import org.joda.time.LocalDate

class Adapter: CalendarAdapter() {
    val View.tvItem get() = findViewById<TextView>(R.id.tv_day)
    override fun getCalendarItemView(context: Context?): View {
        return LayoutInflater.from(context).inflate(R.layout.layout_calendar_item, null)
    }

    override fun onBindToadyView(
        calendarItemView: View,
        localDate: LocalDate,
        totalCheckedDateList: MutableList<LocalDate>
    ) {
        setDay(calendarItemView, localDate, totalCheckedDateList)
    }

    override fun onBindCurrentMonthOrWeekView(
        calendarItemView: View,
        localDate: LocalDate,
        totalCheckedDateList: MutableList<LocalDate>
    ) {
        setDay(calendarItemView, localDate, totalCheckedDateList)
    }

    override fun onBindLastOrNextMonthView(
        calendarItemView: View,
        localDate: LocalDate,
        totalCheckedDateList: MutableList<LocalDate>
    ) {
        setDay(calendarItemView, localDate, totalCheckedDateList)
    }

    fun setDay(
        view: View,
        localDate: LocalDate,
        totalCheckedDateList: MutableList<LocalDate>) {
        view.tvItem.text = localDate.dayOfMonth.toString()
        if (localDate in totalCheckedDateList) {
            view.tvItem.setTextColor(Color.BLUE)
        } else {
            view.tvItem.setTextColor(Color.BLACK)
        }
    }
}