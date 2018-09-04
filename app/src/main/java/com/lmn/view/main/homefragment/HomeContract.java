package com.lmn.view.main.homefragment;

import com.lmn.Entity.HomeFragmentEntity;

/**
 * @author admin
 */

public interface HomeContract {
    interface View {
        void setHomeData(HomeFragmentEntity find);
    }

    interface Presenter {
        void getHomeData();
    }

}