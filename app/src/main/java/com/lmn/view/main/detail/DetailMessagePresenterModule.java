package com.lmn.view.main.detail;

import com.lmn.MainDataManager;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：liy_lmn
 * 时间：2018/9/6:9:40
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */
@Module
public class DetailMessagePresenterModule {
    private MainDataManager mainDataManager;
    private DetailMessageContract.View view;

    public DetailMessagePresenterModule(MainDataManager mainDataManager, DetailMessageContract.View view) {
        this.mainDataManager = mainDataManager;
        this.view = view;
    }

    @Provides
    DetailMessageContract.View provideDetailMessageContractView(){
        return view;
    }
    @Provides
    MainDataManager providerMainDataManager(){
        return mainDataManager;
    }
}
