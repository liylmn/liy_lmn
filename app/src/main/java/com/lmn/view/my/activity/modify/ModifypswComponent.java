package com.lmn.view.my.activity.modify;

import dagger.Component;
import lmn.com.lmnlibrary.AppComponent;
import lmn.com.lmnlibrary.PerActivity;

/**
 * 作者：liy_lmn
 * 时间：2018/9/6:17:54
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */
@PerActivity
@Component(dependencies = AppComponent.class,modules = ModifypswPresenterModule.class)
public interface ModifypswComponent {
    void inject(ModifypswActivity modifypswActivity);
}
