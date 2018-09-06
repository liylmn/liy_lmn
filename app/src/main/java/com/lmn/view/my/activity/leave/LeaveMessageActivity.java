package com.lmn.view.my.activity.leave;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lmn.MainDataManager;
import com.lmn.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lmn.com.lmnlibrary.base.BaseActivity;
import lmn.com.lmnlibrary.utils.RepeatUtils;

@Route(path = "/leavemessage/activity")
public class LeaveMessageActivity extends BaseActivity implements LeaveMessageContract.View {

    @BindView(R.id.edit_waste_objection)
    EditText editWasteObjection;
    @BindView(R.id.my_btn_back)
    Button myBtnBack;
    @Inject
    LeaveMessagePresenter leaveMessagePresenter;
    @Override
    public int getLayoutId() {
        return R.layout.activity_leave_message;
    }

    @Override
    public void initview() {
    DaggerLeaveMessageComponent
            .builder()
            .appComponent(getAppComponent())
            .leaveMessagePresenterModule(new LeaveMessagePresenterModule(MainDataManager.getInstance(mDataManager),this))
            .build()
            .inject(this);
    }

    @Override
    public void initData() {
    }

    @Override
    public void setListener() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        unbinder = ButterKnife.bind(this);
    }

    @OnClick(R.id.my_btn_back)
    public void onViewClicked() {
        if (RepeatUtils.isFastDoubleClick()) {
            if (editWasteObjection.getText().toString().equals("")) {
                showShortToast("请输入留言");
                return;
            }
            leaveMessagePresenter.leave(mDataManager.getSPMapData().get("userId"), editWasteObjection.getText().toString());
        }else {
            showShortToast("请不要重复点击");
        }
    }

    @Override
    public void success() {
      finish();
    }

    @Override
    public void showProgressDialogView() {
        showProgressDialog("提交数据中");
    }

    @Override
    public void hiddenProgressDialogView() {
        hiddenProgressDialog();
    }
}
