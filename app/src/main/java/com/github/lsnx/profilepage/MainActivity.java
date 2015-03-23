package com.github.lsnx.profilepage;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

import com.github.lsnx.profilepage.widget.BaseRowDescriptor;
import com.github.lsnx.profilepage.widget.ContainerView;
import com.github.lsnx.profilepage.widget.GroupDescriptor;
import com.github.lsnx.profilepage.widget.NormalRowDescriptor;
import com.github.lsnx.profilepage.widget.OnRowClickListener;
import com.github.lsnx.profilepage.widget.ProfileRowDescriptor;
import com.github.lsnx.profilepage.widget.RowActionEnum;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements OnRowClickListener {
    private ContainerView mWidgetContainerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWidgetContainerView = (ContainerView) findViewById(R.id.mWidgetContainerView);
        initializeView();
    }

    private void initializeView() {
        ArrayList<GroupDescriptor> groupDescriptors = new ArrayList<GroupDescriptor>();

        ArrayList<BaseRowDescriptor> descriptors0 = new ArrayList<BaseRowDescriptor>();
        descriptors0.add(new ProfileRowDescriptor("", "Android", "UID:123456", RowActionEnum.USER_PROFILE));
        GroupDescriptor descriptor0 = new GroupDescriptor(descriptors0);
        groupDescriptors.add(descriptor0);

        ArrayList<BaseRowDescriptor> descriptors1 = new ArrayList<BaseRowDescriptor>();
        descriptors1.add(new NormalRowDescriptor(R.drawable.more_my_album, "My Posts", RowActionEnum.MY_POSTS));
        descriptors1.add(new NormalRowDescriptor(R.drawable.more_my_favorite, "Favorite Messages", RowActionEnum.FAVORITE_MSG));
        descriptors1.add(new NormalRowDescriptor(R.drawable.more_my_bank_card, "My Bank Cards", RowActionEnum.MY_BANK_CARD));
        GroupDescriptor descriptor1 = new GroupDescriptor(descriptors1);
        groupDescriptors.add(descriptor1);

        ArrayList<BaseRowDescriptor> descriptors2 = new ArrayList<BaseRowDescriptor>();
        descriptors2.add(new NormalRowDescriptor(R.drawable.more_emoji, "Sticker Gallery", RowActionEnum.STICKER_GALLERY));
        GroupDescriptor descriptor2 = new GroupDescriptor(descriptors2);
        groupDescriptors.add(descriptor2);

        ArrayList<BaseRowDescriptor> descriptors3 = new ArrayList<BaseRowDescriptor>();
        descriptors3.add(new NormalRowDescriptor(R.drawable.more_setting, "Settings", RowActionEnum.SETTING));
        GroupDescriptor descriptor3 = new GroupDescriptor(descriptors3);
        groupDescriptors.add(descriptor3);

        mWidgetContainerView.initializeData(groupDescriptors, this);
        mWidgetContainerView.notifyDataChanged();
    }

    @Override
    public void onRowClick(RowActionEnum action) {
        Toast.makeText(this, "row click on:" + action.name(), Toast.LENGTH_SHORT).show();
    }
}
