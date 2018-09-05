package com.lmn.view.login.suggest;

import com.lmn.MainDataManager;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：liy_lmn
 * 时间：2018/9/5:14:32
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */
@Module
public class LoginPresenterModule {
    private LoginContract.View view;

    private MainDataManager mainDataManager;

    public LoginPresenterModule(LoginContract.View  view, MainDataManager mainDataManager) {
        this.view = view;
        this.mainDataManager = mainDataManager;
    }

    @Provides
    LoginContract.View providerMainContractView(){
        return view;
    }
    @Provides
    MainDataManager providerMainDataManager(){
        return mainDataManager;
    }
}
