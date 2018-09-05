package com.lmn.view.main.detail;

import com.lmn.Entity.DetailEntity;

/**
 * 作者：liy_lmn
 * 时间：2018/9/5:16:44
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */

public interface DetailContract {
    interface View {
        void getdata(DetailEntity detailEntity);
        void showProgressDialogView();
        void hiddenProgressDialogView();
    }

    interface Presenter {
        void setdate(String typeId,int pageNum);
    }
}
