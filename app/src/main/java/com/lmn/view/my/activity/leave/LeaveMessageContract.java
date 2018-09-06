package com.lmn.view.my.activity.leave;

/**
 * 作者：liy_lmn
 * 时间：2018/9/6:16:51
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */

public interface LeaveMessageContract {
    interface View {
        void success();
        void showProgressDialogView();
        void hiddenProgressDialogView();
    }

    interface Presenter {
        void leave(String userid,String content);
    }
}
