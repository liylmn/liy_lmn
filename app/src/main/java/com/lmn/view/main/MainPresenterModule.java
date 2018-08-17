package com.lmn.view.main;



import dagger.Module;
import dagger.Provides;

/**
 * Created by admin on 2017/3/12.
 */
@Module
public class MainPresenterModule {
    private MainContract.View view;

    private MainDataManager mainDataManager;

    public MainPresenterModule(MainContract.View view,MainDataManager mainDataManager) {
        this.view = view;
        this.mainDataManager = mainDataManager;
    }

    @Provides
    MainContract.View providerMainContractView(){
        return view;
    }
    @Provides
    MainDataManager providerMainDataManager(){
        return mainDataManager;
    }


}
