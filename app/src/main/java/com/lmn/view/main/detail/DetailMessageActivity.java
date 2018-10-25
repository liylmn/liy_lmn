package com.lmn.view.main.detail;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.lmn.Entity.DetailMessageEntity;
import com.lmn.MainDataManager;
import com.lmn.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lmn.com.lmnlibrary.base.BaseActivity;
import lmn.com.lmnlibrary.imageloader.ILoader;
import lmn.com.lmnlibrary.imageloader.ImageFactory;

@Route(path = "/detailmessage/activity")
public class DetailMessageActivity extends BaseActivity implements DetailMessageContract.View {
    @BindView(R.id.toolbar_title_tv)
    TextView toolbar_title_tv;
    @Autowired(name = "message")
    public String message;
    @Autowired(name = "id")
    public String id;
    @BindView(R.id.home_title_bar_layout)
    FrameLayout homeTitleBarLayout;
    @Inject
    DetailMessagePresenter detailMessagePresenter;
    @BindView(R.id.tv_reson)
    TextView tvReson;
    @BindView(R.id.img_detailmessage)
    ImageView imgDetailmessage;
    @BindView(R.id.tv_loadmore)
    TextView tvLoadmore;
    @BindView(R.id.tv_imggone)
    TextView tvImggone;
    private DetailMessageEntity mydetailMessageEntity;

    @Override
    public int getLayoutId() {
        return R.layout.activity_detail_message;
    }

    @Override
    public void initview() {
        DaggerDetailMessageComponent
                .builder()
                .appComponent(getAppComponent())
                .detailMessagePresenterModule(new DetailMessagePresenterModule(MainDataManager.getInstance(mDataManager), this))
                .build()
                .inject(this);
        ARouter.getInstance().inject(this);//添加在onCreate（）
        toolbar_title_tv.setText(message);
    }

    @Override
    public void initData() {
        detailMessagePresenter.setdate(id);
    }

    @Override
    public void setListener() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


    @Override
    public void getdata(DetailMessageEntity detailMessageEntity) {

        try {
            mydetailMessageEntity = detailMessageEntity;
            int size = detailMessageEntity.getData().getFault().getReasons().size();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < size; i++) {
                stringBuffer.append((i + 1) + "." + detailMessageEntity.getData().getFault().getReasons().get(i));
                if (i != size - 1) {
                    stringBuffer.append("\n");
                }
            }
            tvReson.setText(stringBuffer.toString());
            if (mydetailMessageEntity.getData().getFault().getImgSize().equals("0")) {
                tvLoadmore.setVisibility(View.GONE);
                imgDetailmessage.setVisibility(View.GONE);
                tvImggone.setVisibility(View.VISIBLE);
            } else if (mydetailMessageEntity.getData().getFault().getImgSize().equals("1")) {
                tvLoadmore.setVisibility(View.GONE);
            }
            ImageFactory.getLoader().loadNet(imgDetailmessage, detailMessageEntity.getData().getBasePath() + detailMessageEntity.getData().getFault().getFaultImgs().get(0).getImg(), new ILoader.Options(R.mipmap.ic_launcher, R.drawable.loading_img));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void showProgressDialogView() {
        showProgressDialog("数据加载中");
    }

    @Override
    public void hiddenProgressDialogView() {
        hiddenProgressDialog();
    }

    @OnClick({R.id.home_title_bar_layout, R.id.tv_loadmore})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_title_bar_layout:
                ARouter.getInstance().build("/search/activity")
                        .withString("resultType", "1")
                        .navigation();
                break;
            case R.id.tv_loadmore:
                ARouter.getInstance().build("/loadmore/activity")
                        .withObject("detailMessageEntity", mydetailMessageEntity)
                        .navigation();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        detailMessagePresenter.destory();
    }
}
