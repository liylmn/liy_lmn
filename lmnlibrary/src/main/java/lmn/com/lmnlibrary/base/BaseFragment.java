package lmn.com.lmnlibrary.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.shashank.sony.fancytoastlib.FancyToast;

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layoutInflater = inflater;
        rootView = inflater.inflate(getLayoutId(), container, false);
        unbinder = KnifeUtil.bind(this, rootView);
        initview();
        initData();
        setListener();
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

    protected void showSuccessToast(String message) {
        FancyToast.makeText(mActivity.getApplicationContext(), message, FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true);
    }

    protected void showDefaultToast(String message) {
        FancyToast.makeText(mActivity.getApplicationContext(), message, FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true);
    }

    protected void showErrorToast(String message) {
        FancyToast.makeText(mActivity.getApplicationContext(), message, FancyToast.LENGTH_LONG, FancyToast.DEFAULT, true);
    }

    protected AppComponent getAppComponent() {
        return GlobalAppComponent.getAppComponent();
    }

    protected void showJDLoadingDialog() {
        if (dialog == null) dialog = DialogUtil.createJDLoadingDialog(mActivity, null);
        if (!dialog.isShowing()) {
            dialog.show();
        }
    }

    protected void hideJDLoadingDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
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
