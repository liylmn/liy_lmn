package com.lmn.view.login.suggest;

import dagger.Component;
import lmn.com.lmnlibrary.AppComponent;
import lmn.com.lmnlibrary.PerFragment;

/**
 * 作者：liy_lmn
 * 时间：2018/9/5:14:33
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */
@PerFragment
@Component(dependencies = AppComponent.class , modules = LoginPresenterModule.class)
public interface LoginComponent {
    void inject(LoginAct loginAct);
}
