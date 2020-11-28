package com.example.babnowidgets.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;

import com.example.babnowidgets.R;

public class HamburgerButtonMenu extends LinearLayout implements View.OnClickListener {


    private AppCompatImageButton iconMenu;
    private ViewGroup iconContainer;


    //<editor-fold desc="MainMethod">
    public HamburgerButtonMenu(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize(context, attrs);

    }
    //</editor-fold>

    //<editor-fold desc="CreateMethod">
    private void initialize(Context context, AttributeSet attrs) {
        inflateView();
        initStyle(context, attrs);
        initClickListener();
    }

    private void inflateView() {
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout rootView = (LinearLayout) li.inflate(R.layout.view_menu_hamburger, this, true);

        iconContainer = (ViewGroup) rootView.findViewById(R.id.lyt_iconContainer);
        iconMenu = (AppCompatImageButton) rootView.findViewById(R.id.imgb_iconMenu);

    }

    private void initStyle(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.HamburgerButtonMenu);

        int borderColor = typedArray.getColor(R.styleable.HamburgerButtonMenu_cv_borderColor, Color.GRAY);
        float borderSize = typedArray.getDimension(R.styleable.HamburgerButtonMenu_cv_borderSize, dpToPx(2));
        float borderRadius = typedArray.getDimension(R.styleable.HamburgerButtonMenu_cv_borderRadius, dpToPx(12));
        int iconScaleType = typedArray.getInt(R.styleable.HamburgerButtonMenu_cv_iconScaleType, -1);
        int iconSource = typedArray.getResourceId(R.styleable.HamburgerButtonMenu_cv_iconSource, R.drawable.ic_hamburger_menu);

        GradientDrawable gd = new GradientDrawable();
        gd.setShape(GradientDrawable.RECTANGLE);
        gd.setSize(dpToPx(48), dpToPx(48));
        gd.setColor(Color.TRANSPARENT); // Changes this drawbale to use a single color instead of a gradient
        gd.setCornerRadius(borderRadius);
        gd.setStroke((int) borderSize, borderColor);

        iconContainer.setBackground(gd);
        iconMenu.setImageResource(iconSource);
        if (iconScaleType > -1) {
            ImageView.ScaleType[] types = ImageView.ScaleType.values();
            ImageView.ScaleType scaleType = types[iconScaleType];
            iconMenu.setScaleType(scaleType);
        }
        typedArray.recycle();
    }

    private void initClickListener() {
        iconMenu.setOnClickListener(this);
    }

    private int dpToPx(int dp) {
        return (int) (dp * getResources().getDisplayMetrics().density);
    }
    //</editor-fold>

    //<editor-fold desc="OverrideMethod">
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
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


    //</editor-fold>

    //<editor-fold desc="ImplementMethod">
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.imgb_iconMenu) {

        }
    }
    //</editor-fold>

    //<editor-fold desc="SetterAndGetterMethod">

    public ViewGroup getIconContainer() {
        return iconContainer;
    }

    public void setIconContainer(ViewGroup iconContainer) {
        this.iconContainer = iconContainer;
    }

    public AppCompatImageButton getIconMenu() {
        return iconMenu;
    }

    public void setIconMenu(AppCompatImageButton iconMenu) {
        this.iconMenu = iconMenu;
    }

    //</editor-fold>
}
