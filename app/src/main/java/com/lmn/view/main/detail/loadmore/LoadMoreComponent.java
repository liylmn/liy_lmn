package com.lmn.view.main.detail.loadmore;

import dagger.Component;
import lmn.com.lmnlibrary.AppComponent;
import lmn.com.lmnlibrary.PerActivity;

/**
 * 作者：liy_lmn
 * 时间：2018/10/27:13:17
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */
@PerActivity
@Component(dependencies = AppComponent.class,modules = LoadMorPresenterModule.class)
public interface LoadMoreComponent {
    void inject(LoadMoreActivity loadMoreActivity);
}
