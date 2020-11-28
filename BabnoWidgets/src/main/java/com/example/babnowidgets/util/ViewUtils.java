package com.example.babnowidgets.util;

import android.content.Context;
import android.util.TypedValue;

import androidx.core.text.TextUtilsCompat;
import androidx.core.view.ViewCompat;

import java.util.Locale;

public class ViewUtils {

    public static int toDp(Context context, int value) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, context.getResources().getDisplayMetrics());
    }

    public static boolean isRTL() {
        return TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == ViewCompat.LAYOUT_DIRECTION_RTL;
    }
}
