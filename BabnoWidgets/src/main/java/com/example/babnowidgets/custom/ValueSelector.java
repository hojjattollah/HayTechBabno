package com.example.babnowidgets.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.babnowidgets.R;

public class ValueSelector extends LinearLayout implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener {
    private static final long TIME_INTERVAL = 100;
    private View rootView;
    private ImageButton add, mines;
    private TextView valueText;

    private int minValue = Integer.MIN_VALUE;
    private int maxValue = Integer.MAX_VALUE;
    private boolean isAddButtonPressed = false;
    private boolean isMinesButtonPressed = false;
    private Handler handle;

    public ValueSelector(Context context) {
        super(context);
    }


    public ValueSelector(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ValueSelector(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.DoubleText);

        LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout rootView = (LinearLayout) li.inflate(R.layout.view_value_selector, this, true);
        add = (ImageButton) rootView.findViewById(R.id.btn_add);
        mines = (ImageButton) rootView.findViewById(R.id.btn_mines);
        valueText = (TextView) rootView.findViewById(R.id.tv_valueNumber);

        handle = new Handler();

        add.setOnClickListener(this);
        mines.setOnClickListener(this);

        add.setOnLongClickListener(this);
        mines.setOnLongClickListener(this);

        add.setOnTouchListener(this);
        mines.setOnTouchListener(this);

        a.recycle();

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == add.getId()) {
            increamentValue();
        } else if (view.getId() == mines.getId()) {
            decreamentValue();
        }
    }

    private int getValue() {
        String value = valueText.getText().toString();
        if (value.isEmpty()) {
            valueText.setText("0");
            return 0;
        }
        return Integer.valueOf(value);
    }

    private void setValue(int newValue) {
        if (newValue > maxValue) {
            valueText.setText(String.valueOf(maxValue));
        } else if (newValue < minValue) {
            valueText.setText(String.valueOf(minValue));
        } else {
            valueText.setText(String.valueOf(newValue));
        }
    }

    private void increamentValue() {
        int value = getValue();
        setValue(value + 1);
    }

    private void decreamentValue() {
        int value = getValue();
        setValue(value - 1);
    }

    @Override
    public boolean onLongClick(View view) {
        if (view.getId() == add.getId()) {
            isAddButtonPressed = true;
            handle.postDelayed(new AutoIncreamenter(), TIME_INTERVAL);
        } else if (view.getId() == mines.getId()) {
            handle.postDelayed(new AutoDecreamenter(), TIME_INTERVAL);
            isMinesButtonPressed = true;
        }
        return false;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == motionEvent.ACTION_UP || motionEvent.getAction() == motionEvent.ACTION_CANCEL) {
            isAddButtonPressed = false;
            isMinesButtonPressed = false;
        }
        return false;
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

//        setMeasuredDimension(manageDimention(widthMeasureSpec, 300), manageDimention(heightMeasureSpec, 100));
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    private int manageDimention(int valueMeatureSpec, int value_desired) {
        int value_final = 0;


        int value = MeasureSpec.getSize(valueMeatureSpec);

        int value_mode = MeasureSpec.getMode(valueMeatureSpec);

        switch (value_mode) {
            case MeasureSpec.EXACTLY:
                value_final = value;
                break;
            case MeasureSpec.AT_MOST:
                value_final = Math.min(value, value_desired);
                break;
            case MeasureSpec.UNSPECIFIED:
                value_final = value_desired;
                break;

        }
        return value_final;
    }

    private class AutoIncreamenter implements Runnable {

        @Override
        public void run() {
            if (isAddButtonPressed) {
                increamentValue();
                handle.postDelayed(this, TIME_INTERVAL);
            }
        }
    }

    private class AutoDecreamenter implements Runnable {

        @Override
        public void run() {
            if (isMinesButtonPressed) {
                decreamentValue();
                handle.postDelayed(this, TIME_INTERVAL);
            }
        }
    }

}
