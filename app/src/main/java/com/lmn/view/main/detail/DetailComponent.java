package com.lmn.view.main.detail;

import dagger.Component;
import lmn.com.lmnlibrary.AppComponent;
import lmn.com.lmnlibrary.PerFragment;

/**
 * 作者：liy_lmn
 * 时间：2018/9/5:16:44
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */
@PerFragment
@Component(dependencies = AppComponent.class , modules = DetailPresenterModule.class)
public interface DetailComponent {
    void inject(DetailActivity detailActivity);
}
