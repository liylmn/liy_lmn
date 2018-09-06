package com.lmn.view.resources;

import com.lmn.MainDataManager;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：liy_lmn
 * 时间：2018/9/6:15:52
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */
@Module
public class ResourcesFragmentPresenterModule {
   private MainDataManager mainDataManager;
   private ResourcesFragmentContract.View view;

    public ResourcesFragmentPresenterModule(MainDataManager mainDataManager, ResourcesFragmentContract.View view) {
        this.mainDataManager = mainDataManager;
        this.view = view;
    }

    @Provides
    ResourcesFragmentContract.View providerResoucesView(){
        return view;
    }

    @Provides
    MainDataManager providerMainDataManager(){
        return mainDataManager;
    }
}
