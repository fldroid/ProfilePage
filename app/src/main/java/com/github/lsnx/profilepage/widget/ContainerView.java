package com.github.lsnx.profilepage.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class ContainerView extends LinearLayout {
    private Context context;
    private ArrayList<GroupDescriptor> descriptors;
    private OnRowClickListener listener;

    public ContainerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeView(context);
    }

    public ContainerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeView(context);
    }

    public ContainerView(Context context) {
        super(context);
        initializeView(context);
    }

    private void initializeView(Context context) {
        this.context = context;
        setOrientation(VERTICAL);
    }

    public void initializeData(ArrayList<GroupDescriptor> descriptors, OnRowClickListener listener) {
        this.descriptors = descriptors;
        this.listener = listener;
    }

    public void notifyDataChanged() {
        if (descriptors != null && descriptors.size() > 0) {
            GroupView group = null;
            float density = context.getResources().getDisplayMetrics().density;
            LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.topMargin = (int) (20 * density);
            for (GroupDescriptor groupDescriptor : descriptors) {
                group = new GroupView(context);
                group.initializeData(groupDescriptor, listener);
                group.notifyDataChanged();
                addView(group, params);
            }
            setVisibility(VISIBLE);
        } else {
            setVisibility(GONE);
        }
    }
}
