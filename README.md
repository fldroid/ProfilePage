# ProfilePage
This is a simple and fast way to create a profile page.You just need code a small amount of code.

![Screenshot](https://github.com/lsnx/ProfilePage/blob/master/screenshot.png)
##example
``` java
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
```
