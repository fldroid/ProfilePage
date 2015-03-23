package com.github.lsnx.profilepage.widget;

import java.util.ArrayList;

public class GroupDescriptor {
    public String title;
    public ArrayList<BaseRowDescriptor> descriptors;

    public GroupDescriptor(ArrayList<BaseRowDescriptor> descriptors) {
        this.descriptors = descriptors;
    }

    public GroupDescriptor(String title, ArrayList<BaseRowDescriptor> descriptors) {
        this.title = title;
        this.descriptors = descriptors;
    }
}
