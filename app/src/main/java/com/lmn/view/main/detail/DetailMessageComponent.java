package com.lmn.view.main.detail;

import dagger.Component;
import lmn.com.lmnlibrary.AppComponent;
import lmn.com.lmnlibrary.PerFragment;

/**
 * 作者：liy_lmn
 * 时间：2018/9/6:9:39
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */
@PerFragment
@Component(dependencies = AppComponent.class,modules = DetailMessagePresenterModule.class)
public interface DetailMessageComponent {
    void inject(DetailMessageActivity detailMessageActivity);
}
