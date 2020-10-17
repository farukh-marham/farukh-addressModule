package com.example.myapplication.customViews;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

import com.example.myapplication.listeners.OnEnableListener;
import com.example.myapplication.R;

public class BodyText extends AppCompatTextView {

    private OnEnableListener enableListner;
    private String fontName;

    public BodyText(Context context, boolean isBold) {
        super(context);

        if (!isInEditMode()) {
            setFont(context, isBold);
        }

    }

    public BodyText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (enableListner != null) {
            enableListner.onEnable(enabled);
        }
    }


    public void setOnEnableListener(OnEnableListener enableListner) {
        this.enableListner = enableListner;
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
    }
}
