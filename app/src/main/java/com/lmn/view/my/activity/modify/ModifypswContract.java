package com.lmn.view.my.activity.modify;

/**
 * 作者：liy_lmn
 * 时间：2018/9/6:17:55
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */

public interface ModifypswContract {
    interface View {
        void success();
        void showProgressDialogView();
        void hiddenProgressDialogView();
    }

    interface Presenter {
        void modify(String studentNumber,String password,String newPassword);
    }
}
