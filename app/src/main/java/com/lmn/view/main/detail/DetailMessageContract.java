package com.lmn.view.main.detail;

import com.lmn.Entity.DetailMessageEntity;

/**
 * 作者：liy_lmn
 * 时间：2018/9/5:16:44
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */

public interface DetailMessageContract {
    interface View {
        void getdata(DetailMessageEntity detailMessageEntity);
        void showProgressDialogView();
        void hiddenProgressDialogView();
    }

    interface Presenter {
        void setdate(String id);
    }
}
