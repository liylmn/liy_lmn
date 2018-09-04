package com.lmn;

import com.lmn.view.main.homefragment.HomeFragmentService;

import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import lmn.com.lmnlibrary.manager.BaseDataManager;
import lmn.com.lmnlibrary.manager.DataManager;
import okhttp3.ResponseBody;


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
     *验证短信验证码注册/登陆 （只做示例，无数据返回）
     */
    public Disposable login(DisposableObserver<ResponseBody> consumer, String mobile, String verifyCode) {

        return changeIOToMainThread(getService(MainApiService.class).login(mobile,verifyCode), consumer);
    }
    /*
     *获取首页信息
     */
    public Disposable getall(DisposableObserver<ResponseBody> consumer) {
        return changeIOToMainThread(getService(HomeFragmentService.class).getall(), consumer);

    }
//    public Disposable getMainData(int start , int count , DisposableObserver<ResponseBody> consumer){
//        Map<String,Object> map = new HashMap<>(2);
//        map.put("start",start);
//        map.put("count",count);
//        return changeIOToMainThread(getService(BaseApiService.class).executeGet("http://www.baidu.com",map),consumer);
//    }


}
