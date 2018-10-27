package com.lmn.view.main.detail.loadmore;

import com.lmn.Entity.ImgsEntity;

/**
 * 作者：liy_lmn
 * 时间：2018/10/27:13:17
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */

public interface LoadMoreContract {
    interface View {
        void getdata(ImgsEntity imgsEntity);
        void showProgressDialogView();
        void hiddenProgressDialogView();
    }

    interface Presenter {
        void setdate(String id, String pageNum, String pageSize);
        void destory();
    }
}
