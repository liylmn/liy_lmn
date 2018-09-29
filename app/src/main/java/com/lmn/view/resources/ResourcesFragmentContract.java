package com.lmn.view.resources;

import com.lmn.Entity.ResouceEntity;

/**
 * 作者：liy_lmn
 * 时间：2018/9/6:15:48
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */

public interface ResourcesFragmentContract {
    interface View {
        void getdata(ResouceEntity resouceEntity);
        void showProgressDialogView();
        void hiddenProgressDialogView();
    }

    interface Presenter {
        void setdate(String id);
        void destory();
    }
}
