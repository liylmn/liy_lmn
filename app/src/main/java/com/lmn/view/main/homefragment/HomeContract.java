package com.lmn.view.main.homefragment;

import com.lmn.Entity.HomeFragmentEntity;

/**
 * @author admin
 */

public interface HomeContract {
    interface View {
        void setHomeData(HomeFragmentEntity find);
        void showProgressDialogView();

        void hiddenProgressDialogView();
    }

    interface Presenter {
        void getHomeData();
        void destory();
    }

}