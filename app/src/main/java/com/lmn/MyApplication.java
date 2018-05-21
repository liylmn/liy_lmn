package com.lmn;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.squareup.leakcanary.LeakCanary;

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
    }


    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

}
