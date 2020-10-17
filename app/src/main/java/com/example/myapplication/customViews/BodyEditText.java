package com.example.myapplication.customViews;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatEditText;

import com.example.myapplication.R;
import com.example.myapplication.listeners.OnEnableListener;

public class BodyEditText extends AppCompatEditText {

    private OnEnableListener enableListner;
    private String fontName;

    public BodyEditText(Context context, boolean isBold) {
        super(context);

        if (!isInEditMode()) {
            setFont(context, isBold);
        }
    }

    public BodyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context, attrs);

    }

    private void initialize(Context context, AttributeSet attrs) {
        if (!isInEditMode()) {
            String packageName = "http://schemas.android.com/apk/res-auto";
            fontName = attrs.getAttributeValue(packageName, "fontNameTextView");
            boolean isBold = attrs.getAttributeBooleanValue(packageName, "fontBoldTextView", false);
            setFont(context, isBold);
        }

    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (enableListner != null) {
            enableListner.onEnable(enabled);
        }
    }

    public void setOnEnableListener(OnEnableListener enableListener) {
        this.enableListner = enableListener;
    }

    public void setFont(Context context, boolean isBold) {

        if (fontName == null || fontName.length() == 0) {
            fontName = context.getString(R.string.body_text);
        }
        Typeface tf = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Regular.ttf");
        if (isBold) {
            setTypeface(tf, Typeface.BOLD);
        } else {
            setTypeface(tf);
        }
        setTextSize(15);
    }


    public static int getColorWrapper(Context context, int id) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return context.getColor(id);
        } else {
            return context.getResources().getColor(id);
        }
    }
}
