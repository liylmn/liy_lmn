package lmn.com.lmnlibrary.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.Unbinder;
import lmn.com.lmnlibrary.AppComponent;
import lmn.com.lmnlibrary.GlobalAppComponent;
import lmn.com.lmnlibrary.event.BusFactory;
import lmn.com.lmnlibrary.manager.DataManager;
import lmn.com.lmnlibrary.utils.DialogUtil;
import lmn.com.lmnlibrary.utils.KnifeUtil;

/**
 * Created by admin on 2017/3/15.
 */

public class BaseFragment extends LazyFragment implements UiCallback {
    protected Activity mActivity;
    protected Unbinder unbinder;
    protected Context mContext;

    protected DataManager mDataManager;
    /**
     * gif_logo进度dialog
     */
    private Dialog dialog;
    protected View rootView;
    private Dialog loadingDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layoutInflater = inflater;
        rootView = inflater.inflate(getLayoutId(), container, false);
        unbinder = KnifeUtil.bind(this, rootView);
        initview();
        return rootView;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (useEventBus()) {
            BusFactory.getBus().register(this);
        }
        setListener();
        initData();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
        mContext = getAppComponent().getContext();
        mDataManager = getAppComponent().getDataManager();
    }

    protected void showShortToast(String message) {
        Toast.makeText(mActivity.getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }


    protected AppComponent getAppComponent() {
        return GlobalAppComponent.getAppComponent();
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
            loadingDialog = DialogUtil.createLoadingDialog(mActivity, msg, listener);
        }else if(!loadingDialog.isShowing()){
            loadingDialog.show();
        }

    }
    protected void hiddenProgressDialog(){
        if(loadingDialog != null && loadingDialog.isShowing()){
            loadingDialog.dismiss();
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
        if (dialog != null) {
            if (dialog.isShowing()) dialog.dismiss();
            dialog = null;
        }
        BusFactory.getBus().unregister(this);
    }


    @Override
    public void initview() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public boolean useEventBus() {
        return false;
    }

}
