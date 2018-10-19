package com.lmn;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.alibaba.android.arouter.launcher.ARouter;
import com.squareup.leakcanary.LeakCanary;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;

import lmn.com.lmnlibrary.CommonConfig;
import lmn.com.lmnlibrary.GlobalAppComponent;


/**
 * @author admin
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        if(CommonConfig.DEBUG){
            LeakCanary.install(this);
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   //开启调试模 式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }

        ARouter.init(this);
        //CrashReport.initCrashReport(getApplicationContext(), "93f0e37549", CommonConfig.DEBUG);
        GlobalAppComponent.init(this);
        // 这里实现SDK初始化，appId替换成你的在Bugly平台申请的appId
        // 调试时，将第三个参数改为true
        Bugly.init(this, "ef66e004c8", true);
    }


    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        // you must install multiDex whatever tinker is installed!
        MultiDex.install(base);


        // 安装tinker
        Beta.installTinker();
    }
}
