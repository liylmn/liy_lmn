package com.lmn.view.my.activity.leave;

import com.lmn.MainDataManager;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：liy_lmn
 * 时间：2018/9/6:16:52
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */
@Module
public class LeaveMessagePresenterModule {
    private MainDataManager mainDataManager;
    private LeaveMessageContract.View view;

    public LeaveMessagePresenterModule(MainDataManager mainDataManager, LeaveMessageContract.View view) {
        this.mainDataManager = mainDataManager;
        this.view = view;
    }
    @Provides
    LeaveMessageContract.View provideleaveview(){
        return view;
    }
    @Provides
    MainDataManager providerMainDataManager(){
        return mainDataManager;
    }

}
