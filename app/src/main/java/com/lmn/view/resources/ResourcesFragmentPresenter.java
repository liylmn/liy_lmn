package com.lmn.view.resources;

import android.content.Context;
import android.widget.Toast;

import com.lmn.BasePresenter;
import com.lmn.Entity.ResouceEntity;
import com.lmn.MainDataManager;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

/**
 * 作者：liy_lmn
 * 时间：2018/9/6:15:51
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */

public class ResourcesFragmentPresenter extends BasePresenter implements ResourcesFragmentContract.Presenter{
    private MainDataManager mainDataManager;
    private ResourcesFragmentContract.View view;
    @Inject
    public ResourcesFragmentPresenter(MainDataManager mainDataManager, ResourcesFragmentContract.View view) {
        this.mainDataManager = mainDataManager;
        this.view = view;
    }

    @Override
    public void setdate(String id) {
        view.showProgressDialogView();
    addDisposabe(mainDataManager.getresource(id,"10", new DisposableObserver<ResouceEntity>() {
        @Override
        public void onNext(ResouceEntity resouceEntity) {
            if (resouceEntity.getCode()==1){
                view.getdata(resouceEntity);
            }else {
                Toast.makeText((Context) view,resouceEntity.getMsg(),Toast.LENGTH_SHORT).show();
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
