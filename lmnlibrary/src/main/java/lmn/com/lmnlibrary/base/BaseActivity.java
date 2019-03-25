package lmn.com.lmnlibrary.base;


import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import butterknife.Unbinder;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import lmn.com.lmnlibrary.AppComponent;
import lmn.com.lmnlibrary.GlobalAppComponent;
import lmn.com.lmnlibrary.event.BusFactory;
import lmn.com.lmnlibrary.manager.DataManager;
import lmn.com.lmnlibrary.receiver.NetWorkChangeBroadcastReceiver;
import lmn.com.lmnlibrary.utils.DialogUtil;
import lmn.com.lmnlibrary.utils.KnifeUtil;
import lmn.com.lmnlibrary.utils.LoggerUtil;

/**
 * Created by admin on 2017/3/12.
 */

public abstract class BaseActivity extends AppCompatActivity implements UiCallback {
    protected DataManager mDataManager;
    protected Context mContext;
    protected Dialog loadingDialog;
    protected Unbinder unbinder;
    private NetWorkChangeBroadcastReceiver receiver;
    protected LoggerUtil loggerUtil;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataManager = getAppComponent().getDataManager();
        mContext = getAppComponent().getContext();
        registerNetChangeReceiver();
        //去除title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去掉Activity上面的状态栏
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,
                WindowManager.LayoutParams. FLAG_FULLSCREEN);
        if (getLayoutId() > 0) {
            setContentView(getLayoutId());
            unbinder = KnifeUtil.bind(this);
        }
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        loggerUtil=LoggerUtil.getLoggerUtil();
        initview();
        initData();
        setListener();
        hideBottomUIMenu();

    }
    private void registerNetChangeReceiver() {
        receiver = new NetWorkChangeBroadcastReceiver(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(receiver , intentFilter);
    }

    protected AppComponent getAppComponent() {
        return GlobalAppComponent.getAppComponent();
    }

    protected void addFragment(int containerViewId, Fragment fragment , String tag) {
        final FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();

        fragmentTransaction.add(containerViewId, fragment , tag);
        fragmentTransaction.commit();
    }

    protected void showShortToast(String message){
        Toast.makeText(mContext,message,Toast.LENGTH_SHORT).show();
    }


    protected void showProgressDialog(){
        this.showProgressDialog(null,null);
    }

    protected void showProgressDialog(String msg){
        this.showProgressDialog(msg , null);
    }

    protected void showProgressDialog(DialogInterface.OnCancelListener listener){
        this.showProgressDialog(null ,listener);
    }

    protected void showProgressDialog(String msg , DialogInterface.OnCancelListener listener){
        if(loadingDialog == null){
            loadingDialog = DialogUtil.createLoadingDialog(this, msg, listener);
        }else if(!loadingDialog.isShowing()){
            loadingDialog.show();
        }

    }

    protected void hiddenProgressDialog(){
        if(loadingDialog != null && loadingDialog.isShowing()){
            loadingDialog.dismiss();
        }
    }


    private CompositeDisposable disposables;

    /**
     * 添加观察者
     * @param disposable d
     */
    public void addDisposable(Disposable disposable){
        if(disposables == null){
            disposables = new CompositeDisposable();
        }
        disposables.add(disposable);
    }

    /**
     * 注销观察者，防止泄露
     */
    public void clearDisposable(){
        if(disposables != null){
            disposables.clear();
            disposables = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(loadingDialog != null && loadingDialog.isShowing()){
            loadingDialog.dismiss();
            loadingDialog = null;
        }
        clearDisposable();
        if(unbinder != null){
            unbinder.unbind();
        }

        if(null != receiver){
            receiver.onDestroy();
            unregisterReceiver(receiver);
            receiver = null;
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        if (useEventBus()) {
            BusFactory.getBus().register(this);
        }
    }
    @Override
    public boolean useEventBus() {
        return false;
    }
    @Override
    protected void onStop() {
        super.onStop();
        BusFactory.getBus().unregister(this);
    }

    /**
     * 隐藏虚拟按键，并且全屏
     */
    protected void hideBottomUIMenu() {
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_IMMERSIVE;
        getWindow().setAttributes(params);
    }
}
