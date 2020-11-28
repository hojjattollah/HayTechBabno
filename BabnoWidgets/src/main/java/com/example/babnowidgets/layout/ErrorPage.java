package com.example.babnowidgets.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

import com.example.babnowidgets.R;
import com.google.android.material.textview.MaterialTextView;

import static com.example.babnowidgets.util.ViewUtils.toDp;

public class ErrorPage extends LinearLayout {
    private static final float TEXT_SIZE = 17;
    public static final int NO_SERVER_CONNECTION = 0;
    public static final int PHONE_NOT_SUPPORTED = 1;
    public static final int NOT_INTERNET_CONNECTION = 2;
    public static final int IMPORTANT_UPDATE = 3;
    private final Context context;
    private AppCompatImageView errorIcon;
    private AppCompatImageView errorImage;
    private MaterialTextView errorTitle;
    private MaterialTextView trackingCodeLable;
    private MaterialTextView trackingCodeValue;
    private MaterialTextView errorDescription;
    private MaterialTextView secondButton;
    private MaterialTextView firstButton;
    private MaterialTextView errorTitleDescription;

    public ErrorPage(Context context) {
        super(context);
        this.context = context;
    }

    public ErrorPage(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        inflateView();
        initStyle(context, attrs);
        initClicklistener();
    }

    private void inflateView() {
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout rootView = (LinearLayout) layoutInflater.inflate(R.layout.layout_error_page, this, true);

        errorIcon = (AppCompatImageView) rootView.findViewById(R.id.img_errorIcon);
        errorImage = (AppCompatImageView) rootView.findViewById(R.id.img_errorImage);

        errorTitle = (MaterialTextView) rootView.findViewById(R.id.mtv_titleError);

        trackingCodeLable = (MaterialTextView) rootView.findViewById(R.id.mtv_trackingCodeLable);
        trackingCodeValue = (MaterialTextView) rootView.findViewById(R.id.mtv_trackingCodeValue);

        errorTitleDescription = (MaterialTextView) rootView.findViewById(R.id.mtv_titleDescriptionError);
        errorDescription = (MaterialTextView) rootView.findViewById(R.id.mtv_descriptionError);

        secondButton = (MaterialTextView) rootView.findViewById(R.id.mtv_secondButton);
        firstButton = (MaterialTextView) rootView.findViewById(R.id.mbtn_firstButton);
    }

    private void initStyle(Context context, AttributeSet attrs) {

        //init typedArray
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ErrorPage);

        //todo:check styleable property exist before get and use
        if (typedArray.hasValue(R.styleable.ErrorPage_cv_ep_errorIconSource)) {
        }

        //get styleable property
        int errorType = (int) typedArray.getInt(R.styleable.ErrorPage_cv_ep_errorIconWidth, NO_SERVER_CONNECTION);


        int errorIconVisibility = typedArray.getInt(R.styleable.ErrorPage_cv_ep_errorIconVisibility, View.VISIBLE);
        int errorIconSource = typedArray.getResourceId(R.styleable.ErrorPage_cv_ep_errorIconSource, -1);
        int errorIconWidth = (int) typedArray.getDimension(R.styleable.ErrorPage_cv_ep_errorIconWidth, toDp(context, 48));
        int errorIconHeight = (int) typedArray.getDimension(R.styleable.ErrorPage_cv_ep_errorIconHeight, toDp(context, 48));////

        int errorImageVisibility = typedArray.getInt(R.styleable.ErrorPage_cv_ep_errorImageVisibility, View.VISIBLE);
        int errorImageSource = typedArray.getResourceId(R.styleable.ErrorPage_cv_ep_errorImageSource, -1);
        int errorImageWidth = (int) typedArray.getDimension(R.styleable.ErrorPage_cv_ep_errorImageWidth, toDp(context, 100));
        int errorImageHeight = (int) typedArray.getDimension(R.styleable.ErrorPage_cv_ep_errorImageHeight, toDp(context, 167));////


        Drawable errorTitleBackground = typedArray.getDrawable(R.styleable.ErrorPage_cv_ep_errorTitleBackground);
        String errorTitleText = typedArray.getString(R.styleable.ErrorPage_cv_ep_errorTitleText);
        int errorTitleTextSize = (int) typedArray.getDimension(R.styleable.ErrorPage_cv_ep_errorTitleTextSize, TEXT_SIZE);
        int errorTitleTextColor = typedArray.getColor(R.styleable.ErrorPage_cv_ep_errorTitleTextColor, Color.BLACK);
        int errorTitleTextPaddingTop = (int) typedArray.getDimension(R.styleable.ErrorPage_cv_ep_errorTitleTextPaddingTop, toDp(context, 0));////

        Drawable trackingCodeLableBackground = typedArray.getDrawable(R.styleable.ErrorPage_cv_ep_trackingCodeLableBackground);
        String trackingCodeLableText = typedArray.getString(R.styleable.ErrorPage_cv_ep_trackingCodeLableText);
        int trackingCodeLableTextSize = (int) typedArray.getDimension(R.styleable.ErrorPage_cv_ep_trackingCodeLableTextSize, TEXT_SIZE);
        int trackingCodeLableTextColor = typedArray.getColor(R.styleable.ErrorPage_cv_ep_trackingCodeLableTextColor, Color.BLACK);
        int trackingCodeLableTextPaddingTop = (int) typedArray.getDimension(R.styleable.ErrorPage_cv_ep_trackingCodeLableTextPaddingTop, toDp(context, 0));////

        Drawable trackingCodeValueBackground = typedArray.getDrawable(R.styleable.ErrorPage_cv_ep_trackingCodeValueBackground);
        String trackingCodeValueText = typedArray.getString(R.styleable.ErrorPage_cv_ep_trackingCodeValueText);
        int trackingCodeValueTextSize = (int) typedArray.getDimension(R.styleable.ErrorPage_cv_ep_trackingCodeValueTextSize, TEXT_SIZE);
        int trackingCodeValueTextColor = typedArray.getColor(R.styleable.ErrorPage_cv_ep_trackingCodeValueTextColor, Color.BLACK);
        int trackingCodeValueTextPaddingTop = (int) typedArray.getDimension(R.styleable.ErrorPage_cv_ep_trackingCodeValueTextPaddingTop, toDp(context, 0));////

        Drawable errorTitleDescriptionBackground = typedArray.getDrawable(R.styleable.ErrorPage_cv_ep_errorTitleDescriptionBackground);
        String errorTitleDescriptionText = typedArray.getString(R.styleable.ErrorPage_cv_ep_errorTitleDescriptionText);
        int errorTitleDescriptionTextSize = (int) typedArray.getDimension(R.styleable.ErrorPage_cv_ep_errorTitleDescriptionTextSize, TEXT_SIZE);
        int errorTitleDescriptionTextColor = typedArray.getColor(R.styleable.ErrorPage_cv_ep_errorTitleDescriptionTextColor, Color.BLACK);
        int errorTitleDescriptionTextPaddingTop = (int) typedArray.getDimension(R.styleable.ErrorPage_cv_ep_errorTitleDescriptionTextPaddingTop, toDp(context, 0));////


        Drawable errorDescriptionBackground = typedArray.getDrawable(R.styleable.ErrorPage_cv_ep_errorDescriptionBackground);
        String errorDescriptionText = typedArray.getString(R.styleable.ErrorPage_cv_ep_errorDescriptionText);
        int errorDescriptionTextSize = (int) typedArray.getDimension(R.styleable.ErrorPage_cv_ep_errorDescriptionTextSize, TEXT_SIZE);
        int errorDescriptionTextColor = typedArray.getColor(R.styleable.ErrorPage_cv_ep_errorDescriptionTextColor, Color.BLACK);
        int errorDescriptionTextPaddingTop = (int) typedArray.getDimension(R.styleable.ErrorPage_cv_ep_errorDescriptionTextPaddingTop, toDp(context, 0));////

        int firstButtonVisibility = typedArray.getInt(R.styleable.ErrorPage_cv_ep_firstButtonVisibility, View.VISIBLE);
        Drawable firstButtonBackground = typedArray.getDrawable(R.styleable.ErrorPage_cv_ep_firstButtonBackground);
        String firstButtonText = typedArray.getString(R.styleable.ErrorPage_cv_ep_firstButtonText);
        int firstButtonTextSize = (int) typedArray.getDimension(R.styleable.ErrorPage_cv_ep_firstButtonTextSize, TEXT_SIZE);
        int firstButtonTextColor = typedArray.getColor(R.styleable.ErrorPage_cv_ep_firstButtonTextColor, Color.WHITE);////

        int secondButtonVisibility = typedArray.getInt(R.styleable.ErrorPage_cv_ep_secondButtonVisibility, View.GONE);
        Drawable secondButtonBackground = typedArray.getDrawable(R.styleable.ErrorPage_cv_ep_secondButtonBackground);
        String secondButtonText = typedArray.getString(R.styleable.ErrorPage_cv_ep_secondButtonText);
        int secondButtonTextSize = (int) typedArray.getDimension(R.styleable.ErrorPage_cv_ep_secondButtonTextSize, TEXT_SIZE);
        int secondButtonTextColor = typedArray.getColor(R.styleable.ErrorPage_cv_ep_secondButtonTextColor, Color.WHITE);


        //set property into view
        errorIcon.setVisibility(errorIconVisibility);
        if (errorIconSource != -1)
            errorIcon.setImageResource(errorIconSource);
        errorIcon.getLayoutParams().height = errorIconHeight;
        errorIcon.getLayoutParams().width = errorIconWidth;

        errorImage.setVisibility(errorImageVisibility);
        if (errorImageSource != -1)
            errorImage.setImageResource(errorImageSource);
        errorImage.getLayoutParams().height = errorImageHeight;
        errorImage.getLayoutParams().width = errorImageWidth;

        if (errorTitleBackground != null)
            errorTitle.setBackground(errorTitleBackground);
        if (errorTitleText != null)
            errorTitle.setText(errorTitleText);
        errorTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, errorTitleTextSize);
        errorTitle.setTextColor(errorTitleTextColor);
        errorTitle.setPadding(toDp(context, 0), errorTitleTextPaddingTop, toDp(context, 0), toDp(context, 0));
        if (trackingCodeLableBackground != null)
            trackingCodeLable.setBackground(trackingCodeLableBackground);
        if (trackingCodeLableText != null)
            trackingCodeLable.setText(trackingCodeLableText);
        trackingCodeLable.setTextSize(TypedValue.COMPLEX_UNIT_SP, trackingCodeLableTextSize);
        trackingCodeLable.setTextColor(trackingCodeLableTextColor);
        trackingCodeLable.setPadding(toDp(context, 0), trackingCodeLableTextPaddingTop, toDp(context, 0), toDp(context, 0));
        if (trackingCodeValueBackground != null)
            trackingCodeValue.setBackground(trackingCodeValueBackground);
        if (trackingCodeValueText != null)
            trackingCodeValue.setText(trackingCodeValueText);
        trackingCodeValue.setTextSize(TypedValue.COMPLEX_UNIT_SP, trackingCodeValueTextSize);
        trackingCodeValue.setTextColor(trackingCodeValueTextColor);
        trackingCodeValue.setPadding(toDp(context, 0), trackingCodeValueTextPaddingTop, toDp(context, 0), toDp(context, 0));
        if (errorDescriptionBackground != null)
            errorDescription.setBackground(errorDescriptionBackground);
        if (errorDescriptionText != null)
            errorDescription.setText(errorDescriptionText);
        errorDescription.setTextSize(TypedValue.COMPLEX_UNIT_SP, errorDescriptionTextSize);
        errorDescription.setTextColor(errorDescriptionTextColor);
        errorDescription.setPadding(toDp(context, 0), errorDescriptionTextPaddingTop, toDp(context, 0), toDp(context, 0));

        firstButton.setVisibility(firstButtonVisibility);
        if (firstButtonBackground != null)
            firstButton.setBackground(firstButtonBackground);
        if (firstButtonText != null)
            firstButton.setText(firstButtonText);
        firstButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, firstButtonTextSize);
        firstButton.setTextColor(firstButtonTextColor);

        secondButton.setVisibility(secondButtonVisibility);
        if (secondButtonBackground != null)
            secondButton.setBackground(secondButtonBackground);
        if (secondButtonText != null)
            secondButton.setText(secondButtonText);
        secondButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, secondButtonTextSize);
        secondButton.setTextColor(secondButtonTextColor);


        typedArray.recycle();
        setErrorType(errorType);
    }

    public void setErrorType(int errorType) {
        switch (errorType) {
            case NO_SERVER_CONNECTION:
                errorIcon.setImageResource(R.drawable.ic_error_no_server_connection);
                errorImage.setImageResource(R.drawable.error_no_server_connection);
                errorTitle.setText(context.getResources().getString(R.string.not_connected_to_the_server));
                trackingCodeLable.setText(context.getResources().getString(R.string.not_connected_to_the_server));
                trackingCodeValue.setText(context.getResources().getString(R.string.not_connected_to_the_server));
                errorTitleDescription.setText(context.getResources().getString(R.string.not_connected_to_the_server));
                errorDescription.setText(context.getResources().getString(R.string.not_connected_to_the_server));
                firstButton.setText(context.getResources().getString(R.string.not_connected_to_the_server));
                secondButton.setText(context.getResources().getString(R.string.not_connected_to_the_server));
                break;
            case NOT_INTERNET_CONNECTION:
                //todo:vm-delete:set all property
                break;
            case PHONE_NOT_SUPPORTED:
                break;
            case IMPORTANT_UPDATE:
                break;
        }
    }

    private void initClicklistener() {

    }


}
