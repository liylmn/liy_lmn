package com.lmn.view.main.detail;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.lmn.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import lmn.com.lmnlibrary.base.BaseActivity;

@Route(path = "/detailmessage/activity")
public class DetailMessageActivity extends BaseActivity {
    @BindView(R.id.toolbar_title_tv)
    TextView toolbar_title_tv;
    @Autowired(name = "message")
    public String message;
    @BindView(R.id.home_title_bar_layout)
    FrameLayout homeTitleBarLayout;

    @Override
    public int getLayoutId() {
        return R.layout.activity_detail_message;
    }

    @Override
    public void initview() {
        ARouter.getInstance().inject(this);//添加在onCreate（）
        toolbar_title_tv.setText(message);
    }

    @Override
    public void initData() {

    }

    @Override
    public void setListener() {
        homeTitleBarLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/search/activity").navigation();
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
