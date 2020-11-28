package com.example.babnowidgets.textview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.babnowidgets.R;

public class SearchBox extends LinearLayout implements TextWatcher, View.OnClickListener {


    private AppCompatTextView searchButton;
    private EditText searchBox;
    private ConstraintLayout rootContainer, buttonContainer;
    private Drawable containerEmptyStateBackground;
    private Drawable containerTextStateBackground;

    //<editor-fold desc="MainMethod">
    public SearchBox(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize(context, attrs);

    }
    //</editor-fold>

    //<editor-fold desc="CreateMethod">
    private void initialize(final Context context, AttributeSet attrs) {
        inflateView();
        initStyle(context, attrs);
        initClickListener();
    }

    private void inflateView() {
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout rootView = (LinearLayout) layoutInflater.inflate(R.layout.view_edit_text_search, this, true);

        rootContainer = (ConstraintLayout) rootView.findViewById(R.id.clt_rootContainer);
        buttonContainer = (ConstraintLayout) rootView.findViewById(R.id.clt_iconContainer);

        searchButton = (AppCompatTextView) rootView.findViewById(R.id.btn_searchBox);

        searchBox = (EditText) rootView.findViewById(R.id.edt_searchBox);

    }

    private void initStyle(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SearchBox);
        if (typedArray.hasValue(R.styleable.SearchBox_cv_sv_containerEmptyStateBackground)) {
        }


        containerEmptyStateBackground = typedArray.getDrawable(R.styleable.SearchBox_cv_sv_containerEmptyStateBackground);
        containerTextStateBackground = typedArray.getDrawable(R.styleable.SearchBox_cv_sv_containerTextStateBackground);

        int containerPaddingLeft = (int) typedArray.getDimension(R.styleable.SearchBox_cv_sv_containerPaddingLeft, dpToPx(20));

        Drawable editTextBackground = typedArray.getDrawable(R.styleable.SearchBox_cv_sv_editTextBackground);
        String editTextHint = typedArray.getString(R.styleable.SearchBox_cv_sv_editTextHint);
        String editTextContent = typedArray.getString(R.styleable.SearchBox_cv_sv_editTextContent);
        int editTextPaddingRight = (int) typedArray.getDimension(R.styleable.SearchBox_cv_sv_editTextPaddingRight, dpToPx(20));
        int editTextPaddingLeft = (int) typedArray.getDimension(R.styleable.SearchBox_cv_sv_editTextPaddingLeft, dpToPx(20));

        Drawable searchButtonBackground = typedArray.getDrawable(R.styleable.SearchBox_cv_sv_searchButtonBackground);
        String searchButtonText = typedArray.getString(R.styleable.SearchBox_cv_sv_searchButtonText);
        int searchIconSource = typedArray.getResourceId(R.styleable.SearchBox_cv_sv_searchIconSource, -1);
        int searchButtonVisibility = typedArray.getInt(R.styleable.SearchBox_cv_sv_searchButtonVisibility, View.VISIBLE);


        rootContainer.setBackground(containerEmptyStateBackground);
        rootContainer.setPadding(containerPaddingLeft, dpToPx(0), dpToPx(0), dpToPx(0));

        buttonContainer.setBackground(searchButtonBackground);

        searchBox.setBackground(editTextBackground);
        searchBox.setHint(editTextHint);
        searchBox.setText(editTextContent);
        searchBox.setPadding(editTextPaddingLeft, dpToPx(0), editTextPaddingRight, dpToPx(0));


        searchButton.setVisibility(searchButtonVisibility);
        if (searchIconSource != -1)
            searchButton.setBackgroundResource(searchIconSource);
        searchButton.setText(searchButtonText);

        typedArray.recycle();

    }

    private GradientDrawable getBorderBackgoundDrawable(
            int borderColor,
            float borderSize,
            float borderRadius,
            float borderDashWith,
            float borderDashGap
    ) {
        GradientDrawable gd = new GradientDrawable();
        gd.setShape(GradientDrawable.RECTANGLE);
        gd.setSize(dpToPx(48), dpToPx(48));
        gd.setColor(Color.TRANSPARENT); // Changes this drawbale to use a single color instead of a gradient
        gd.setCornerRadius(dpToPx((int) borderRadius));
        gd.setStroke((int) borderSize, borderColor, borderDashWith, borderDashGap);

        return gd;
    }

    private void initClickListener() {
//        clearIcon.setOnClickListener(this);
//        voiceIcon.setOnClickListener(this);
//        searchButton.setOnClickListener(this);
        searchButton.setOnClickListener(this);
        searchBox.addTextChangedListener(this);
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
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if (!charSequence.toString().isEmpty()) {
//            clearIcon.setVisibility(View.VISIBLE);
            rootContainer.setBackground(containerTextStateBackground);
        } else {
//            clearIcon.setVisibility(View.GONE);
            rootContainer.setBackground(containerEmptyStateBackground);
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_back) {

        }
//        if (view.getId() == R.id.btn_clear) {
//            clearIcon.setVisibility(View.GONE);
//            rootContainer.setBackground(emptyStateBorderBackgoundDrawable);
//            searchBox.setText("");
//        } else if (view.getId() == R.id.btn_search) {
//            if (!searchBox.getText().toString().trim().isEmpty())
//                clearIcon.setVisibility(View.VISIBLE);
//            searchBox.requestFocus();
//            searchBox.setFocusableInTouchMode(true);
//        } else if (view.getId() == R.id.btn_back) {
//
//        } else if (view.getId() == R.id.btn_voice) {
//
//        }
    }
    //</editor-fold>

    //<editor-fold desc="SetterAndGetterMethod">


    public AppCompatTextView getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(AppCompatTextView searchButton) {
        this.searchButton = searchButton;
    }

    public AppCompatTextView getSearchIcon() {
        return searchButton;
    }

    public void setSearchIcon(AppCompatTextView searchButton) {
        this.searchButton = searchButton;
    }

    public EditText getSearchBox() {
        return searchBox;
    }

    public void setSearchBox(EditText searchBox) {
        this.searchBox = searchBox;
    }

    public ConstraintLayout getRootContainer() {
        return rootContainer;
    }

    public void setRootContainer(ConstraintLayout rootContainer) {
        this.rootContainer = rootContainer;
    }

    public ConstraintLayout getButtonContainer() {
        return buttonContainer;
    }

    public void setButtonContainer(ConstraintLayout buttonContainer) {
        this.buttonContainer = buttonContainer;
    }

    //</editor-fold>


    //<editor-fold desc="MainMethod">
    //</editor-fold>
    //<editor-fold desc="CreateMethod">
//</editor-fold>
    //<editor-fold desc="OverrideMethod">
    //</editor-fold>
    //<editor-fold desc="ImplementMethod">
    //</editor-fold>
    //<editor-fold desc="SetterAndGetterMethod">
    //</editor-fold>
    //<editor-fold desc="InnerClass">
    //</editor-fold>

}
