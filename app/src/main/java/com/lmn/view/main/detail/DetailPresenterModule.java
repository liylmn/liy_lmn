package com.lmn.view.main.detail;

import com.lmn.MainDataManager;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：liy_lmn
 * 时间：2018/9/5:16:45
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */
@Module
public class DetailPresenterModule {
    private DetailContract.View view;

    private MainDataManager mainDataManager;
    public DetailPresenterModule(DetailContract.View view,MainDataManager mainDataManager){
        this.mainDataManager=mainDataManager;
        this.view=view;
    }

    @Provides
    DetailContract.View providerMainContractView(){
        return view;
    }
    @Provides
    MainDataManager providerMainDataManager(){
        return mainDataManager;
    }
}
