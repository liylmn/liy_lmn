package com.lmn.view.main.homefragment;

import com.lmn.BasePresenter;
import com.lmn.Entity.HomeFragmentEntity;
import com.lmn.MainDataManager;

import javax.inject.Inject;

import lmn.com.lmnlibrary.base.rxjava.ErrorDisposableObserver;
import okhttp3.ResponseBody;

/**
 * @author admin
 */

public class HomePresenter extends BasePresenter implements HomeContract.Presenter{
    private MainDataManager mDataManager;

    private HomeContract.View mHomeView;
    @Inject
    public HomePresenter(MainDataManager mDataManager, HomeContract.View view) {
        this.mDataManager = mDataManager;
        this.mHomeView = view;
    }



    @Override
    public void getHomeData() {
        addDisposabe(mDataManager.getall(new ErrorDisposableObserver<ResponseBody>() {
            @Override
            public void onNext(ResponseBody responseBody) {
            HomeFragmentEntity homeFragmentEntity = null;
            mHomeView.setHomeData((HomeFragmentEntity) homeFragmentEntity);
            }

            @Override
            public void onComplete() {

            }
        }));
    }
}
