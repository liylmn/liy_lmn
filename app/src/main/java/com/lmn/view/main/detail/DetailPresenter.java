package com.lmn.view.main.detail;

import android.content.Context;
import android.widget.Toast;

import com.lmn.BasePresenter;
import com.lmn.Entity.DetailEntity;
import com.lmn.MainDataManager;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

/**
 * 作者：liy_lmn
 * 时间：2018/9/5:16:45
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */

public class DetailPresenter extends BasePresenter implements DetailContract.Presenter {
    private MainDataManager mDataManager;

    private DetailContract.View mHomeView;
    @Inject
    public DetailPresenter(MainDataManager mDataManager, DetailContract.View view) {
        this.mDataManager = mDataManager;
        this.mHomeView = view;
    }

    @Override
    public void setdate(String typeId, final int pageNum) {
        String pageSize = "10";
        mHomeView.showProgressDialogView();
        addDisposabe(mDataManager.getinfo(typeId, pageNum+"", pageSize, new DisposableObserver<DetailEntity>() {
        @Override
        public void onNext(DetailEntity detailEntity) {
        if (detailEntity.getCode()==1){
            mHomeView.getdata(detailEntity);
        }else {
            Toast.makeText((Context) mHomeView,detailEntity.getMsg(),Toast.LENGTH_SHORT).show();
        }
            mHomeView.hiddenProgressDialogView();
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
}
