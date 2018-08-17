package com.lmn.view.my.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lmn.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lmn.com.lmnlibrary.base.BaseActivity;

@Route(path = "/leavemessage/activity")
public class LeaveMessageActivity extends BaseActivity {

    @BindView(R.id.edit_waste_objection)
    EditText editWasteObjection;
    @BindView(R.id.my_btn_back)
    Button myBtnBack;

    @Override
    public int getLayoutId() {
        return R.layout.activity_leave_message;
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        unbinder=ButterKnife.bind(this);
    }

    @OnClick(R.id.my_btn_back)
    public void onViewClicked() {

    }
}
