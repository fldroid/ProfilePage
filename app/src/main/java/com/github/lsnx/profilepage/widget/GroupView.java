package com.github.lsnx.profilepage.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.github.lsnx.profilepage.R;

import java.util.ArrayList;

public class GroupView extends LinearLayout {
    private ArrayList<BaseRowDescriptor> descriptors;
    private Context context;
    private OnRowClickListener listener;
    private String title;

    public GroupView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeView(context);
    }

    public GroupView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeView(context);
    }

    public GroupView(Context context) {
        super(context);
        initializeView(context);
    }

    private void initializeView(Context context) {
        this.context = context;
        setOrientation(VERTICAL);
    }

    public void initializeData(GroupDescriptor descriptor, OnRowClickListener listener) {
        this.descriptors = descriptor.descriptors;
        this.title = descriptor.title;
        this.listener = listener;
    }

    public void notifyDataChanged() {
        if (descriptors != null && descriptors.size() > 0) {
            BaseRowView row = null;
            View line = null;
            float density = context.getResources().getDisplayMetrics().density;
            LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = (int) (10 * density);
            BaseRowDescriptor descriptor = null;
            for (int i = 0; i < descriptors.size(); i++) {
                descriptor = descriptors.get(i);
                if (descriptor instanceof NormalRowDescriptor) {
                    row = new NormalRowView(context);

                } else if (descriptor instanceof ProfileRowDescriptor) {
                    row = new ProfileRowView(context);
                }
                row.initializeData(descriptors.get(i), listener);
                row.notifyDataChanged();
                addView(row);
                if (i != descriptors.size() - 1) {
                    line = new View(context);
                    line.setBackgroundResource(R.color.widget_general_row_line);
                    addView(line, params);
                }
            }
        } else {
            setVisibility(View.GONE);
        }
    }
}