package com.lmn.view.main.detail;

import com.lmn.BasePresenter;
import com.lmn.Entity.DetailMessageEntity;
import com.lmn.MainDataManager;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

/**
 * 作者：liy_lmn
 * 时间：2018/9/6:9:30
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */

public class DetailMessagePresenter extends BasePresenter implements DetailMessageContract.Presenter{
    private MainDataManager mainDataManager;
    private DetailMessageContract.View view;
    @Inject
    public DetailMessagePresenter(MainDataManager mainDataManager,DetailMessageContract.View view) {
        this.mainDataManager=mainDataManager;
        this.view=view;
    }

    @Override
    public void setdate(String id) {
        view.showProgressDialogView();
    addDisposabe(mainDataManager.getdetailmessage(id, new DisposableObserver<DetailMessageEntity>() {
        @Override
        public void onNext(DetailMessageEntity detailMessageEntity) {
            if (detailMessageEntity.getCode()==1){
                view.getdata(detailMessageEntity);
            }
            view.hiddenProgressDialogView();
        }

        @Override
        public void onError(Throwable e) {
            view.hiddenProgressDialogView();
        }

        @Override
        public void onComplete() {

        }
    }));
    }
}
