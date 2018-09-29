package com.lmn.view.my.activity.leave;

import android.content.Context;
import android.widget.Toast;

import com.lmn.BasePresenter;
import com.lmn.Entity.LeaveMessageEntity;
import com.lmn.MainDataManager;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

/**
 * 作者：liy_lmn
 * 时间：2018/9/6:16:52
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */

public class LeaveMessagePresenter extends BasePresenter implements LeaveMessageContract.Presenter {
    private MainDataManager mainDataManager;
    private LeaveMessageContract.View view;

    @Inject
    public LeaveMessagePresenter(MainDataManager mainDataManager, LeaveMessageContract.View view) {
        this.mainDataManager = mainDataManager;
        this.view = view;
    }

    @Override
    public void leave(String userid, String content) {
        view.showProgressDialogView();
        ;
        addDisposabe(mainDataManager.leavemessage(userid, content, new DisposableObserver<LeaveMessageEntity>() {
            @Override
            public void onNext(LeaveMessageEntity leaveMessageEntity) {
                if (leaveMessageEntity.getCode() == 1) {
                    Toast.makeText((Context) view, "留言成功", Toast.LENGTH_SHORT).show();
                    view.success();
                } else {
                    Toast.makeText((Context) view, leaveMessageEntity.getMsg(), Toast.LENGTH_SHORT).show();
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
