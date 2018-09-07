package com.lmn.view.search;

import com.lmn.MainDataManager;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：liy_lmn
 * 时间：2018/9/7:18:05
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */
@Module
public class SearchPresenterModule {
    private MainDataManager mainDataManager;
    private SearchContract.View view;

    public SearchPresenterModule(MainDataManager mainDataManager, SearchContract.View view) {
        this.mainDataManager = mainDataManager;
        this.view = view;
    }

    @Provides
    SearchContract.View provideSearchView() {
        return view;
    }

    @Provides
    MainDataManager providerMainDataManager() {
        return mainDataManager;
    }

}
