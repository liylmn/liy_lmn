package com.lmn.view.login.suggest;

import android.content.Context;
import android.widget.Toast;

import com.lmn.BasePresenter;
import com.lmn.Entity.LoginEntity;
import com.lmn.MainDataManager;

import java.util.HashMap;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;
import lmn.com.lmnlibrary.utils.Md5Utils;

/**
 * 作者：liy_lmn
 * 时间：2018/9/5:14:32
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */

public class LoginPresenter extends BasePresenter implements LoginContract.Presenter{
    private MainDataManager mDataManager;

    private LoginContract.View mHomeView;
    @Inject
    public LoginPresenter(MainDataManager mDataManager, LoginContract.View view) {
        this.mDataManager = mDataManager;
        this.mHomeView = view;
    }

    @Override
    public void login() {
        final String name=mHomeView.getname();
        String psw= Md5Utils.MD5_LOWERCASE(mHomeView.getpsw());
        addDisposabe(mDataManager.login(name, psw, new DisposableObserver<LoginEntity>() {
        @Override
        public void onNext(LoginEntity loginEntity) {
         if (loginEntity.getCode()==1){
             HashMap<String, String> map = new HashMap<>();
             map.put("username",loginEntity.getData().getUser().getName());
             map.put("number",loginEntity.getData().getUser().getStudentNumber());
             map.put("userId",loginEntity.getData().getUser().getId()+"");
             map.put("phone",name);
             mDataManager.saveSPMapData(map);
             mHomeView.loginsuccess();
         }else {
             mHomeView.loginfail();
             Toast.makeText((Context) mHomeView,loginEntity.getMsg(),Toast.LENGTH_SHORT).show();
         }
        }

        @Override
        public void onError(Throwable e) {
            mHomeView.loginfail();
        }

        @Override
        public void onComplete() {

        }
    }));
    }
}
