package com.lmn.view.main.homefragment;

import android.content.Context;
import android.widget.Toast;

import com.lmn.BasePresenter;
import com.lmn.Entity.HomeFragmentEntity;
import com.lmn.MainDataManager;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

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
        mHomeView.showProgressDialogView();
        addDisposabe(mDataManager.getall(new DisposableObserver<HomeFragmentEntity>() {
            @Override
            public void onNext(HomeFragmentEntity homeFragmentEntity) {
                if (homeFragmentEntity.getCode()==1){
                    mHomeView.setHomeData(homeFragmentEntity);
                    mHomeView.hiddenProgressDialogView();
                }else {
                    Toast.makeText((Context) mHomeView,homeFragmentEntity.getMsg(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(Throwable e) {
                mHomeView.hiddenProgressDialogView();
            }

            @Override
            public void onComplete() {

            }
        }));
    }

    @Override
    public void destory() {
        if(disposables != null){
            disposables.clear();
        }
    }
}
