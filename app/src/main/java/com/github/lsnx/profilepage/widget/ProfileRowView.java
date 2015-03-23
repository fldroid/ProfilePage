package com.github.lsnx.profilepage.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.lsnx.profilepage.R;

public class ProfileRowView extends BaseRowView implements View.OnClickListener {
    private Context context;
    private ImageView mWidgetProfileRowActionBtn;
    private TextView mWidgetProfileRowName;
    private TextView mWidgetProfileRowId;
    private ImageView mWidgetProfileRowIconImg;
    private OnRowClickListener listener;
    private ProfileRowDescriptor descriptor;


    public ProfileRowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initializeView();
    }

    public ProfileRowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initializeView();
    }

    public ProfileRowView(Context context) {
        super(context);
        this.context = context;
        initializeView();
    }

    private void initializeView() {
        LayoutInflater.from(context).inflate(R.layout.widget_profile_row, this);
        mWidgetProfileRowActionBtn = (ImageView) findViewById(R.id.mWidgetProfileRowActionBtn);
        mWidgetProfileRowName = (TextView) findViewById(R.id.mWidgetProfileRowName);
        mWidgetProfileRowId = (TextView) findViewById(R.id.mWidgetProfileRowId);
        mWidgetProfileRowIconImg = (ImageView) findViewById(R.id.mWidgetProfileRowIconImg);
        mWidgetProfileRowActionBtn.setBackgroundResource(R.drawable.backchat_submenu_normal);
    }

    @Override
    public void onClick(View v) {
        if (listener != null)
            listener.onRowClick(descriptor.action);
    }

    public void initializeData(BaseRowDescriptor descriptor, OnRowClickListener listener) {
        this.descriptor = (ProfileRowDescriptor) descriptor;
        this.listener = listener;
    }

    public void notifyDataChanged() {
        if (descriptor != null) {
            mWidgetProfileRowIconImg.setBackgroundResource(R.drawable.ic_launcher);
            mWidgetProfileRowName.setText(descriptor.label);
            mWidgetProfileRowId.setText(descriptor.detailLabel);
            if (descriptor.action != null) {
                setOnClickListener(this);
                setBackgroundResource(R.drawable.widget_general_row_selector);
                mWidgetProfileRowIconImg.setVisibility(View.VISIBLE);
            } else {
                setBackgroundColor(Color.WHITE);
                mWidgetProfileRowIconImg.setVisibility(View.GONE);
            }
        } else {
            setVisibility(View.GONE);
        }
    }
}
