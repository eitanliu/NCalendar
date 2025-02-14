package com.necer.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import android.text.TextPaint;
import android.util.AttributeSet;

import com.necer.R;
import com.necer.utils.Attrs;

/**
 * Created by necer on 2018/12/24.
 */
public class WeekBar extends AppCompatTextView {


    private String[] days = {"一", "二", "三", "四", "五", "六", "日"};

    private int firstDayOfWeek;//一周的第一天是周几
    private TextPaint textPaint;

    public WeekBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.NCalendar);
        firstDayOfWeek = ta.getInt(R.styleable.NCalendar_firstDayOfWeek, Attrs.SUNDAY);
        ta.recycle();

        textPaint = getPaint();
        textPaint.setTextAlign(Paint.Align.CENTER);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();

        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();

        int width = getMeasuredWidth() - paddingRight - paddingLeft;
        int height = getMeasuredHeight() - paddingTop - paddingBottom;
        for (int i = 0; i < days.length; i++) {
            @SuppressLint("DrawAllocation")
            Rect rect = new Rect(paddingLeft + (i * width / days.length), paddingTop,
                    paddingLeft + ((i + 1) * width / days.length), paddingTop + height);
            Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
            float top = fontMetrics.top;
            float bottom = fontMetrics.bottom;
            int baseLineY = (int) (rect.centerY() - top / 2 - bottom / 2);
            String day = days[(i + firstDayOfWeek - 1) % days.length];
            canvas.drawText(day, rect.centerX(), baseLineY, textPaint);
        }
    }

    public void setDays(String[] days) {
        if (days.length != 7) throw new IllegalArgumentException("天数长度必须为7");
        this.days = days;
        invalidate();
    }

    public String[] getDays() {
        return days;
    }

    public void setFirstDayOfWeek(int dayOfWeek) {
        if(firstDayOfWeek == dayOfWeek) return;
        this.firstDayOfWeek = dayOfWeek;
        invalidate();
    }

    public int getFirstDayOfWeek() {
        return firstDayOfWeek;
    }
}
