package com.lmn.view.my.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lmn.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lmn.com.lmnlibrary.base.BaseActivity;

@Route(path = "/modify/activity")
public class ModifypswActivity extends BaseActivity {


    @BindView(R.id.et_oldpsw)
    EditText etOldpsw;
    @BindView(R.id.clean_oldpsw)
    ImageView cleanOldpsw;
    @BindView(R.id.iv_show_oldpwd)
    ImageView ivShowOldpwd;
    @BindView(R.id.et_newpsw)
    EditText etNewpsw;
    @BindView(R.id.clean_newpsw)
    ImageView cleanNewpsw;
    @BindView(R.id.iv_show_newpwd)
    ImageView ivShowNewpwd;
    @BindView(R.id.btn_sure)
    Button btnSure;
    private boolean flag_old = false;
    private boolean flag_new = false;
    @Override
    public int getLayoutId() {
        return R.layout.activity_modifypsw;
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
        unbinder = ButterKnife.bind(this);
    }

    @OnClick({R.id.clean_oldpsw, R.id.iv_show_oldpwd, R.id.clean_newpsw, R.id.iv_show_newpwd, R.id.btn_sure})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.clean_oldpsw:
                etOldpsw.setText("");
                break;
            case R.id.iv_show_oldpwd:
                if (flag_old == true) {
                    etOldpsw.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    ivShowOldpwd.setImageResource(R.drawable.pass_gone);
                    flag_old = false;
                } else {
                    etOldpsw.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    ivShowOldpwd.setImageResource(R.drawable.pass_visuable);
                    flag_old = true;
                }
                String pwd = etOldpsw.getText().toString();
                if (!TextUtils.isEmpty(pwd))
                    etOldpsw.setSelection(pwd.length());
                break;
            case R.id.clean_newpsw:
                etNewpsw.setText("");
                break;
            case R.id.iv_show_newpwd:
                if (flag_new == true) {
                    etNewpsw.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    ivShowNewpwd.setImageResource(R.drawable.pass_gone);
                    flag_new = false;
                } else {
                    etNewpsw.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    ivShowNewpwd.setImageResource(R.drawable.pass_visuable);
                    flag_new = true;
                }
                String pwd_new = etNewpsw.getText().toString();
                if (!TextUtils.isEmpty(pwd_new))
                    etNewpsw.setSelection(pwd_new.length());
                break;
            case R.id.btn_sure:

                break;
        }
    }
}
