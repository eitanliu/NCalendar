package com.necer.painter;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

import org.joda.time.LocalDate;

import androidx.annotation.ColorInt;

/**
 * Created by necer on 2020/3/27.
 */
public class DrawableBackground implements CalendarBackground {

    Drawable drawable;

    public DrawableBackground(){
        this(Color.WHITE);
    }

    public DrawableBackground(@ColorInt int color) {
        drawable = new ColorDrawable(color);
    }

    public DrawableBackground(Drawable drawable) {
        this.drawable = drawable;
    }

    @Override
    public Drawable getBackgroundDrawable(LocalDate localDate, int totalDistance, int currentDistance) {
        return drawable;
    }
}
