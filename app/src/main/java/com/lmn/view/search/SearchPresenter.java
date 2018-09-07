package com.lmn.view.search;

import android.content.Context;
import android.widget.Toast;

import com.lmn.BasePresenter;
import com.lmn.Entity.SearchEntity;
import com.lmn.MainDataManager;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

/**
 * 作者：liy_lmn
 * 时间：2018/9/7:18:05
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */

public class SearchPresenter extends BasePresenter implements SearchContract.Presenter{
    private MainDataManager mainDataManager;
    private SearchContract.View view;
    @Inject
    public SearchPresenter(MainDataManager mainDataManager, SearchContract.View view) {
        this.mainDataManager = mainDataManager;
        this.view = view;
    }

    @Override
    public void searchdate(String name, String resultType) {
        addDisposabe(mainDataManager.search(name, resultType, new DisposableObserver<SearchEntity>() {
            @Override
            public void onNext(SearchEntity searchEntity) {
                if (searchEntity.getCode()==1){
                 view.getdata(searchEntity);
                }else {
                    Toast.makeText((Context) view,searchEntity.getMsg(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        }));
    }
}
