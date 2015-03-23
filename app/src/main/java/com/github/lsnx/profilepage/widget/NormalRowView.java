package com.github.lsnx.profilepage.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.lsnx.profilepage.R;

public class NormalRowView extends BaseRowView implements View.OnClickListener {
    private Context context;
    private ImageView mWidgetRowActionBtn;
    private TextView mWidgetRowLabel;
    private ImageView mWidgetRowIconImg;
    private OnRowClickListener listener;
    private NormalRowDescriptor descriptor;

    public NormalRowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initializeView();
    }

    public NormalRowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initializeView();
    }

    public NormalRowView(Context context) {
        super(context);
        this.context = context;
        initializeView();
    }

    private void initializeView() {
        LayoutInflater.from(context).inflate(R.layout.widget_normal_row, this);
        mWidgetRowActionBtn = (ImageView) findViewById(R.id.mWidgetRowActionBtn);
        mWidgetRowLabel = (TextView) findViewById(R.id.mWidgetRowLabel);
        mWidgetRowIconImg = (ImageView) findViewById(R.id.mWidgetRowIconImg);
        mWidgetRowActionBtn.setBackgroundResource(R.drawable.backchat_submenu_normal);
    }

    @Override
    public void onClick(View v) {
        if (listener != null)
            listener.onRowClick(descriptor.action);
    }

    public void initializeData(BaseRowDescriptor descriptor, OnRowClickListener listener) {
        this.descriptor = (NormalRowDescriptor) descriptor;
        this.listener = listener;
    }

    public void notifyDataChanged() {
        if (descriptor != null) {
            mWidgetRowIconImg.setBackgroundResource(descriptor.iconResId);
            mWidgetRowLabel.setText(descriptor.label);
            if (descriptor.action != null) {
                setOnClickListener(this);
                setBackgroundResource(R.drawable.widget_general_row_selector);
                mWidgetRowIconImg.setVisibility(View.VISIBLE);
            } else {
                setBackgroundColor(Color.WHITE);
                mWidgetRowIconImg.setVisibility(View.GONE);
            }
        } else {
            setVisibility(View.GONE);
        }
    }
}
