package com.github.lsnx.profilepage.widget;

public class NormalRowDescriptor extends BaseRowDescriptor {
    public int iconResId;
    public String label;

    public NormalRowDescriptor(int iconResId, String label, RowActionEnum action) {
        this.iconResId = iconResId;
        this.label = label;
        this.action = action;
    }
}
