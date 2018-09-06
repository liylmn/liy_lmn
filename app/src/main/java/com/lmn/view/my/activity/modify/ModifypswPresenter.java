package com.lmn.view.my.activity.modify;

import android.content.Context;
import android.widget.Toast;

import com.lmn.BasePresenter;
import com.lmn.Entity.ModifyEntity;
import com.lmn.MainDataManager;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;
import lmn.com.lmnlibrary.utils.Md5Utils;

/**
 * 作者：liy_lmn
 * 时间：2018/9/6:17:55
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */

public class ModifypswPresenter extends BasePresenter implements ModifypswContract.Presenter{
    private MainDataManager mainDataManager;
    private ModifypswContract.View view;
    @Inject
    public ModifypswPresenter(MainDataManager mainDataManager, ModifypswContract.View view) {
        this.mainDataManager = mainDataManager;
        this.view = view;
    }

    @Override
    public void modify(String studentNumber, String password, String newPassword) {
    view.showProgressDialogView();
    addDisposabe(mainDataManager.modifypsw(studentNumber, Md5Utils.MD5_LOWERCASE(password), Md5Utils.MD5_LOWERCASE(newPassword), new DisposableObserver<ModifyEntity>() {
        @Override
        public void onNext(ModifyEntity modifyEntity) {
            if (modifyEntity.getCode()==1){
                view.success();
            }else {
                Toast.makeText((Context) view,modifyEntity.getMsg(),Toast.LENGTH_SHORT).show();
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
