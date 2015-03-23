package com.github.lsnx.profilepage.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public abstract class BaseRowView extends LinearLayout {

    public BaseRowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public BaseRowView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseRowView(Context context) {
        super(context);
    }

    public abstract void initializeData(BaseRowDescriptor rowDescriptor, OnRowClickListener listener);

    public abstract void notifyDataChanged();
}
