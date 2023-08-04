package com.necer.listener;

import androidx.annotation.NonNull;
import com.necer.calendar.BaseCalendar;
import com.necer.enumeration.CalendarType;
import org.joda.time.LocalDate;

/**
 * 日期分页加载回调
 *
 * @author necer
 * @date 2017/7/4
 */
public interface OnCalendarPageListener {
    void onPageInit(@NonNull BaseCalendar calendar, @NonNull CalendarType type);

    /**
     * 日历分页初始化
     *
     * @param calendar 日历对象，MonthCalendar和WeekCalendar
     * @param type         日历类型
     * @param localDate    日历当前页面选中日期，有选中则返回选中日期，无选中则返回null
     */
    void onInstantiateItem(@NonNull BaseCalendar calendar, @NonNull CalendarType type, @NonNull LocalDate localDate);

    /**
     * 日历分页销毁
     *
     * @param calendar 日历对象，MonthCalendar和WeekCalendar
     * @param type         日历类型
     * @param localDate    日历当前页面选中日期，有选中则返回选中日期，无选中则返回null
     */
    void onDestroyItem(@NonNull BaseCalendar calendar, @NonNull CalendarType type, @NonNull LocalDate localDate);
}
