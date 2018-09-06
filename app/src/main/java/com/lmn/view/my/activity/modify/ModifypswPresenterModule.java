package com.lmn.view.my.activity.modify;

import com.lmn.MainDataManager;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：liy_lmn
 * 时间：2018/9/6:17:55
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */
@Module
public class ModifypswPresenterModule {
    private MainDataManager mainDataManager;
    private ModifypswContract.View view;

    public ModifypswPresenterModule(MainDataManager mainDataManager, ModifypswContract.View view) {
        this.mainDataManager = mainDataManager;
        this.view = view;
    }

    @Provides
    ModifypswContract.View provideModifyView(){
        return  view;
    }
    @Provides
    MainDataManager providerMainDataManager(){
        return mainDataManager;
    }

}
