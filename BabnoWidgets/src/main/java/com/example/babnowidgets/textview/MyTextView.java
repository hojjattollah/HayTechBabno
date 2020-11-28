package com.example.babnowidgets.textview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.babnowidgets.R;

public class MyTextView extends LinearLayout {
    Context mContext;

    private View rootView;
    private ImageButton add, mines;
    private TextView valueText;

    private int minValue = Integer.MIN_VALUE;
    private int maxValue = Integer.MAX_VALUE;

    public MyTextView(Context context) {

        super(context);
        mContext = context;
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mContext = context;

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.DoubleText);

        String leftText = a.getString(R.styleable.DoubleText_leftText);
        String rightText = a.getString(R.styleable.DoubleText_rightText);

        leftText = leftText == null ? "" : leftText;
        rightText = rightText == null ? "" : rightText;

        String service = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(service);

        LinearLayout layout = (LinearLayout) li.inflate(R.layout.view_value_selector, this, true);

        add = (ImageButton) layout.findViewById(R.id.btn_add);
        mines = (ImageButton) layout.findViewById(R.id.btn_mines);
        valueText = (TextView) layout.findViewById(R.id.tv_valueNumber);

        a.recycle();
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
    }

    @SuppressWarnings("unused")
    public void setLeftText(String text) {
    }

    @SuppressWarnings("unused")
    public void setRightText(String text) {
    }

    @SuppressWarnings("unused")
    public String getLeftText() {
        return "";
    }

    @SuppressWarnings("unused")
    public String getRightText() {
        return "";
    }

}