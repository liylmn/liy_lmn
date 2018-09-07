package com.lmn.view.search;

import dagger.Component;
import lmn.com.lmnlibrary.AppComponent;
import lmn.com.lmnlibrary.PerActivity;

/**
 * 作者：liy_lmn
 * 时间：2018/9/7:18:04
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */
@PerActivity
@Component(dependencies = AppComponent.class,modules = SearchPresenterModule.class)
public interface SearchComponent {
    void inject(SearchActivity searchActivity);
}
