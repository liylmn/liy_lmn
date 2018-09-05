package com.lmn.view.main;

import com.lmn.BasePresenter;
import com.lmn.MainDataManager;

import java.util.Map;

import javax.inject.Inject;

/**
* Created by admin on 2017/03/12
*/

public class MainPresenter extends BasePresenter implements MainContract.Presenter{
    private MainDataManager mDataManager;

    private MainContract.View mMainView;
    private static final String TAG = "MainPresenter";

    @Inject
    public MainPresenter(MainDataManager mDataManager, MainContract.View view) {
        this.mDataManager = mDataManager;
        this.mMainView = view;
    }


    @Override
    public void getText() {

    }

    @Override
    public void destory() {
        if(disposables != null){
            disposables.clear();
        }
    }

    @Override
    public void saveData() {
    }

    @Override
    public Map<String, String> getData() {
        return mDataManager.getSPMapData();
    }

}