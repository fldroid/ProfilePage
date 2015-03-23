package com.github.lsnx.profilepage.widget;

public class ProfileRowDescriptor extends BaseRowDescriptor {
    public String imgUrl;
    public String label;
    public String detailLabel;

    public ProfileRowDescriptor(String imgUrl, String label, String detailLabel, RowActionEnum action) {
        this.imgUrl = imgUrl;
        this.label = label;
        this.detailLabel = detailLabel;
        this.action = action;
    }

}
