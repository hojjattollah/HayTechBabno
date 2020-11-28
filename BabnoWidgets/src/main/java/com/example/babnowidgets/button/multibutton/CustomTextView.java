package com.example.babnowidgets.button.multibutton;


import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.TextViewCompat;

import com.example.babnowidgets.R;
import com.google.android.material.textview.MaterialTextView;

public class CustomTextView extends MaterialTextView {

    public CustomTextView(@NonNull Context context) {
        super(context);
    }

    public CustomTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


}
