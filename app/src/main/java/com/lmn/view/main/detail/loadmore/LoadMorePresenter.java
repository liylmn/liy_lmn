package com.lmn.view.main.detail.loadmore;

import com.lmn.BasePresenter;
import com.lmn.Entity.ImgsEntity;
import com.lmn.MainDataManager;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

/**
 * 作者：liy_lmn
 * 时间：2018/10/27:13:18
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */

public class LoadMorePresenter extends BasePresenter implements LoadMoreContract.Presenter{
    private MainDataManager mainDataManager;
    private LoadMoreContract.View view;
    @Inject
    public LoadMorePresenter(MainDataManager mainDataManager, LoadMoreContract.View view) {
        this.mainDataManager = mainDataManager;
        this.view = view;
    }

    @Override
    public void setdate(String id,String pageNum,String pageSize) {
        addDisposabe(mainDataManager.getimgs(id,pageNum,pageSize, new DisposableObserver<ImgsEntity>() {
            @Override
            public void onNext(ImgsEntity imgsEntity) {
                view.showProgressDialogView();
                if (imgsEntity.getCode()==1){
                    view.getdata(imgsEntity);
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

    @Override
    public void destory() {
        if(disposables != null){
            disposables.clear();
        }
    }
}
