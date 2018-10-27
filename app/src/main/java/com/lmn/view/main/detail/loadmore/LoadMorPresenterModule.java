package com.lmn.view.main.detail.loadmore;

import com.lmn.MainDataManager;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：liy_lmn
 * 时间：2018/10/27:13:18
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */
@Module
public class LoadMorPresenterModule {
    private MainDataManager mainDataManager;
    private LoadMoreContract.View view;

    public LoadMorPresenterModule(MainDataManager mainDataManager, LoadMoreContract.View view) {
        this.mainDataManager = mainDataManager;
        this.view = view;
    }
    @Provides
    LoadMoreContract.View provideLoadmoreContractView(){
        return view;
    }
    @Provides
    MainDataManager providerMainDataManager(){
        return mainDataManager;
    }

}
