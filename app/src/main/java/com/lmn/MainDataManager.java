package com.lmn;

import com.lmn.Entity.DetailEntity;
import com.lmn.Entity.DetailMessageEntity;
import com.lmn.Entity.HomeFragmentEntity;
import com.lmn.Entity.LeaveMessageEntity;
import com.lmn.Entity.LoginEntity;
import com.lmn.Entity.ModifyEntity;
import com.lmn.Entity.ResouceEntity;
import com.lmn.http.ApiService;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import lmn.com.lmnlibrary.manager.BaseDataManager;
import lmn.com.lmnlibrary.manager.DataManager;


/**
 * @author：LiuXiaoDong on 2018/4/20 18:26.
 */

public class MainDataManager extends BaseDataManager {

    public MainDataManager(DataManager mDataManager) {
        super(mDataManager);
    }

    public static MainDataManager getInstance(DataManager dataManager){
        return new MainDataManager(dataManager);
    }

    /*
     *获取首页信息
     */
    public Disposable getall(DisposableObserver<HomeFragmentEntity> consumer) {
       return getService(ApiService.class).getall().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(consumer);
    }
    /*
     *登录
     */
    public Disposable login(String name ,String psw,DisposableObserver<LoginEntity> consumer) {
       return getService(ApiService.class).login(name,psw).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(consumer);
    }
    /*
     *故障信息分页接口
     */
    public Disposable getinfo(String typeId ,String pageNum,String pageSize,DisposableObserver<DetailEntity> consumer) {
        return getService(ApiService.class).getinfo(typeId,pageNum,pageSize).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(consumer);
    }
    /*
     *故障详情接口
     */
    public Disposable getdetailmessage(String id ,DisposableObserver<DetailMessageEntity> consumer) {
        return getService(ApiService.class).getdetailmessage(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(consumer);
    }
    /*
     *分页获得资源列表
     */
    public Disposable getresource(String pageNum ,String pageSize,DisposableObserver<ResouceEntity> consumer) {
        return getService(ApiService.class).getresource(pageNum,pageSize).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(consumer);
    }
    /*
     *分页获得资源列表
     */
    public Disposable leavemessage(String userId ,String content,DisposableObserver<LeaveMessageEntity> consumer) {
        return getService(ApiService.class).leavemessage(userId,content).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(consumer);
    }
    /*
     *修改密码
     */
    public Disposable modifypsw(String name ,String password,String newPassword,DisposableObserver<ModifyEntity> consumer) {
        return getService(ApiService.class).modifypsw(name,password,newPassword).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(consumer);
    }
}
