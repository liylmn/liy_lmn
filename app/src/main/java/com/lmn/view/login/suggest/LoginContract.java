package com.lmn.view.login.suggest;

/**
 * 作者：liy_lmn
 * 时间：2018/9/5:14:32
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */

public interface LoginContract {
    interface View {
        void loginsuccess();
        void loginfail();
        String getname();
        String getpsw();
    }

    interface Presenter {
        void login();
        void destory();
    }

}
