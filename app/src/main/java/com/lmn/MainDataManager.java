package com.lmn;

import android.os.Environment;

import com.lmn.Entity.DetailEntity;
import com.lmn.Entity.DetailMessageEntity;
import com.lmn.Entity.HomeFragmentEntity;
import com.lmn.Entity.LeaveMessageEntity;
import com.lmn.Entity.LoginEntity;
import com.lmn.Entity.ModifyEntity;
import com.lmn.Entity.ResouceEntity;
import com.lmn.Entity.SearchEntity;
import com.lmn.http.ApiService;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import lmn.com.lmnlibrary.listener.DownloadFileListener;
import lmn.com.lmnlibrary.manager.BaseDataManager;
import lmn.com.lmnlibrary.manager.DataManager;
import lmn.com.lmnlibrary.utils.SaveFileUtil;
import okhttp3.ResponseBody;


/**
 * @author：LiuXiaoDong on 2018/4/20 18:26.
 */

public class MainDataManager extends BaseDataManager {

    public MainDataManager(DataManager mDataManager) {
        super(mDataManager);
    }

    public static MainDataManager getInstance(DataManager dataManager) {
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
    public Disposable login(String name, String psw, DisposableObserver<LoginEntity> consumer) {
        return getService(ApiService.class).login(name, psw).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(consumer);
    }

    /*
     *故障信息分页接口
     */
    public Disposable getinfo(String typeId, String pageNum, String pageSize, DisposableObserver<DetailEntity> consumer) {
        return getService(ApiService.class).getinfo(typeId, pageNum, pageSize).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(consumer);
    }

    /*
     *故障详情接口
     */
    public Disposable getdetailmessage(String id, DisposableObserver<DetailMessageEntity> consumer) {
        return getService(ApiService.class).getdetailmessage(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(consumer);
    }

    /*
     *分页获得资源列表
     */
    public Disposable getresource(String pageNum, String pageSize, DisposableObserver<ResouceEntity> consumer) {
        return getService(ApiService.class).getresource(pageNum, pageSize).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(consumer);
    }

    /*
     *分页获得资源列表
     */
    public Disposable leavemessage(String userId, String content, DisposableObserver<LeaveMessageEntity> consumer) {
        return getService(ApiService.class).leavemessage(userId, content).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(consumer);
    }

    /*
     *修改密码
     */
    public Disposable modifypsw(String name, String password, String newPassword, DisposableObserver<ModifyEntity> consumer) {
        return getService(ApiService.class).modifypsw(name, password, newPassword).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(consumer);
    }

    /*
     *故障搜索接口
     */
    public Disposable search(String name, String resultType, DisposableObserver<SearchEntity> consumer) {
        return getService(ApiService.class).search(name, resultType).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(consumer);
    }

    /*
     *故障搜索接口
     */
    public Disposable download(String url, final String filePath, DisposableObserver<ResponseBody> consumer, final DownloadFileListener downloadFileListener) {
        return getService(ApiService.class).download("http://download.sj.qq.com/upload/connAssitantDownload/upload/MobileAssistant_1.apk")
                .subscribeOn(Schedulers.io())
                .map(new Function<ResponseBody, ResponseBody>() {
                    @Override
                    public ResponseBody apply(ResponseBody responseBody) throws Exception {
                        return responseBody;
                    }
                })
                .observeOn(Schedulers.io()) // 用于计算任务
                .doOnNext(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        SaveFileUtil.saveInputStream(responseBody, Environment.getExternalStorageDirectory().getAbsolutePath() + "/zhongchetaiyuan/", "MobileAssistant_1.apk",
                                downloadFileListener);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(consumer);
    }

}
