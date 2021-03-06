package com.lmn.view.login.suggest;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.lmn.MainDataManager;
import com.lmn.R;

import javax.inject.Inject;

import lmn.com.lmnlibrary.GlobalAppComponent;
import lmn.com.lmnlibrary.utils.DialogUtil;


/**
 * Created by WZH on 2017/3/25.
 */
@Route(path = "/lmn/login")
public class LoginAct extends FragmentActivity implements View.OnClickListener, KeyboardWatcher.SoftKeyboardStateListener, LoginContract.View {
    private DrawableTextView logo;
    private EditText et_mobile;
    private EditText et_password;
    private ImageView iv_clean_phone;
    private ImageView clean_password;
    private ImageView iv_show_pwd;
    private Button btn_login;
    private TextView forget_password;

    private int screenHeight = 0;//屏幕高度
    private float scale = 0.8f; //logo缩放比例
    private View service, body;
    private KeyboardWatcher keyboardWatcher;

    private View root;
    @Inject
    LoginPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String username=MainDataManager.getInstance(GlobalAppComponent.getAppComponent().getDataManager()).getSPData("username");
        String number=MainDataManager.getInstance(GlobalAppComponent.getAppComponent().getDataManager()).getSPData("number");
        String userId=MainDataManager.getInstance(GlobalAppComponent.getAppComponent().getDataManager()).getSPData("userId");
        if (username!=null&&!username.equals("")
                &&number!=null&&!number.equals("")
                &&userId!=null&&!userId.equals("")){
            ARouter.getInstance().build("/main/activity").navigation();
            finish();
        }
        setContentView(R.layout.activity_login);
        initView();
        initListener();
        keyboardWatcher = new KeyboardWatcher(findViewById(Window.ID_ANDROID_CONTENT));
        keyboardWatcher.addSoftKeyboardStateListener(this);
    }

    private void initView() {
        DaggerLoginComponent.builder()
                .appComponent(GlobalAppComponent.getAppComponent())
                .loginPresenterModule(new LoginPresenterModule(this, MainDataManager.getInstance(GlobalAppComponent.getAppComponent().getDataManager())))
                .build()
                .inject(this);
        logo = (DrawableTextView) findViewById(R.id.logo);
        et_mobile = (EditText) findViewById(R.id.et_mobile);
        et_mobile.setText(MainDataManager.getInstance(GlobalAppComponent.getAppComponent().getDataManager()).getSPData("phone"));
        et_password = (EditText) findViewById(R.id.et_password);
        iv_clean_phone = (ImageView) findViewById(R.id.iv_clean_phone);
        clean_password = (ImageView) findViewById(R.id.clean_password);
        iv_show_pwd = (ImageView) findViewById(R.id.iv_show_pwd);
        btn_login = (Button) findViewById(R.id.btn_login);
        forget_password = (TextView) findViewById(R.id.forget_password);
        service = findViewById(R.id.service);
        body = findViewById(R.id.body);
        screenHeight = this.getResources().getDisplayMetrics().heightPixels; //获取屏幕高度
        root = findViewById(R.id.root);
        findViewById(R.id.close).setOnClickListener(this);
    }

    private void initListener() {
        iv_clean_phone.setOnClickListener(this);
        clean_password.setOnClickListener(this);
        iv_show_pwd.setOnClickListener(this);
        btn_login.setOnClickListener(this);
        et_mobile.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s) && iv_clean_phone.getVisibility() == View.GONE) {
                    iv_clean_phone.setVisibility(View.VISIBLE);
                } else if (TextUtils.isEmpty(s)) {
                    iv_clean_phone.setVisibility(View.GONE);
                }
            }
        });
        et_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s) && clean_password.getVisibility() == View.GONE) {
                    clean_password.setVisibility(View.VISIBLE);
                } else if (TextUtils.isEmpty(s)) {
                    clean_password.setVisibility(View.GONE);
                }
                if (s.toString().isEmpty())
                    return;
                if (!s.toString().matches("[A-Za-z0-9]+")) {
                    String temp = s.toString();
                    Toast.makeText(LoginAct.this, R.string.please_input_limit_pwd, Toast.LENGTH_SHORT).show();
                    s.delete(temp.length() - 1, temp.length());
                    et_password.setSelection(s.length());
                }
            }
        });
        forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MaterialDialog materialDialog = new MaterialDialog.Builder(LoginAct.this)
                        .title("")
                        .content("请联系管理员更改密码")
                        .positiveText("确定")
                        .show();
            }
        });
    }

    /**
     * 缩小
     *
     * @param view
     */
    public void zoomIn(final View view, float dist) {
        view.setPivotY(view.getHeight());
        view.setPivotX(view.getWidth() / 2);
        AnimatorSet mAnimatorSet = new AnimatorSet();
        ObjectAnimator mAnimatorScaleX = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, scale);
        ObjectAnimator mAnimatorScaleY = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, scale);
        ObjectAnimator mAnimatorTranslateY = ObjectAnimator.ofFloat(view, "translationY", 0.0f, -dist);

        mAnimatorSet.play(mAnimatorTranslateY).with(mAnimatorScaleX).with(mAnimatorScaleY);

        mAnimatorSet.setDuration(300);
        mAnimatorSet.start();

    }

    /**
     * f放大
     *
     * @param view
     */
    public void zoomOut(final View view) {
        if (view.getTranslationY() == 0) {
            return;
        }
        view.setPivotY(view.getHeight());
        view.setPivotX(view.getWidth() / 2);
        AnimatorSet mAnimatorSet = new AnimatorSet();

        ObjectAnimator mAnimatorScaleX = ObjectAnimator.ofFloat(view, "scaleX", scale, 1.0f);
        ObjectAnimator mAnimatorScaleY = ObjectAnimator.ofFloat(view, "scaleY", scale, 1.0f);
        ObjectAnimator mAnimatorTranslateY = ObjectAnimator.ofFloat(view, "translationY", view.getTranslationY(), 0);

        mAnimatorSet.play(mAnimatorTranslateY).with(mAnimatorScaleX).with(mAnimatorScaleY);
        mAnimatorSet.setDuration(300);
        mAnimatorSet.start();

    }

    private boolean flag = false;

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.iv_clean_phone:
                et_mobile.setText("");
                break;
            case R.id.clean_password:
                et_password.setText("");
                break;
            case R.id.close:
                finish();
                break;
            case R.id.btn_login:
                if (et_password.getText().toString().equals("")) {
                    Toast.makeText(LoginAct.this, "请输入手机号", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (et_password.getText().toString().equals("")) {
                    Toast.makeText(LoginAct.this, "请输入密码", Toast.LENGTH_SHORT).show();
                    return;
                }
                showProgressDialog("登录中", null);
                mPresenter.login();
                break;
            case R.id.iv_show_pwd:
                if (flag == true) {
                    et_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    iv_show_pwd.setImageResource(R.drawable.pass_gone);
                    flag = false;
                } else {
                    et_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    iv_show_pwd.setImageResource(R.drawable.pass_visuable);
                    flag = true;
                }
                String pwd = et_password.getText().toString();
                if (!TextUtils.isEmpty(pwd))
                    et_password.setSelection(pwd.length());
                break;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        keyboardWatcher.removeSoftKeyboardStateListener(this);
        mPresenter.destory();
    }

    @Override
    public void onSoftKeyboardOpened(int keyboardSize) {
        Log.e("wenzhihao", "----->show" + keyboardSize);
        int[] location = new int[2];
        body.getLocationOnScreen(location); //获取body在屏幕中的坐标,控件左上角
        int x = location[0];
        int y = location[1];
        Log.e("wenzhihao", "y = " + y + ",x=" + x);
        int bottom = screenHeight - (y + body.getHeight());
        Log.e("wenzhihao", "bottom = " + bottom);
        Log.e("wenzhihao", "con-h = " + body.getHeight());
        if (keyboardSize > bottom) {
            ObjectAnimator mAnimatorTranslateY = ObjectAnimator.ofFloat(body, "translationY", 0.0f, -(keyboardSize - bottom));
            mAnimatorTranslateY.setDuration(300);
            mAnimatorTranslateY.setInterpolator(new AccelerateDecelerateInterpolator());
            mAnimatorTranslateY.start();
            zoomIn(logo, keyboardSize - bottom);
        }
    }

    @Override
    public void onSoftKeyboardClosed() {
        Log.e("wenzhihao", "----->hide");
        ObjectAnimator mAnimatorTranslateY = ObjectAnimator.ofFloat(body, "translationY", body.getTranslationY(), 0);
        mAnimatorTranslateY.setDuration(300);
        mAnimatorTranslateY.setInterpolator(new AccelerateDecelerateInterpolator());
        mAnimatorTranslateY.start();
        zoomOut(logo);
    }

    private Dialog loadingDialog;

    private void showProgressDialog(String msg, DialogInterface.OnCancelListener listener) {
        if (loadingDialog == null) {
            loadingDialog = DialogUtil.createLoadingDialog(this, msg, listener);
        } else if (!loadingDialog.isShowing()) {
            loadingDialog.show();
        }

    }

    private void hiddenProgressDialog() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }


    @Override
    public void loginsuccess() {
        hiddenProgressDialog();
        ARouter.getInstance().build("/main/activity").navigation();
        finish();
    }

    @Override
    public void loginfail() {
        hiddenProgressDialog();
    }

    @Override
    public String getname() {
        return et_mobile.getText().toString();
    }

    @Override
    public String getpsw() {
        return et_password.getText().toString();
    }
}
