package com.lmn.view.main.detail;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.lmn.Entity.DetailMultiItemEntity0;
import com.lmn.Entity.DetailMultiItemEntity1;
import com.lmn.R;
import com.lmn.view.main.detail.adapter.DetailAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lmn.com.lmnlibrary.base.BaseActivity;
import lmn.com.lmnlibrary.utils.ScreenUtil;

@Route(path = "/detail/activity")
public class DetailActivity extends BaseActivity {


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    DetailAdapter detailAdapter;
    List<MultiItemEntity> list = new ArrayList<>();
    @BindView(R.id.home_title_bar_layout)
    FrameLayout homeTitleBarLayout;
    @BindView(R.id.toolbar_title_tv)
    TextView toolbar_title_tv;
    private int distanceY;
    /**
     * 改变titlebar中icon颜色时的距离
     */
    private static int DISTANCE_WHEN_TO_SELECTED = 40;
    @Autowired(name = "message")
    public String message;

    @Override
    public void initview() {
        ARouter.getInstance().inject(this);//添加在onCreate（）
        toolbar_title_tv.setText(message);
    }

    @Override
    public void initData() {
        DetailMultiItemEntity0 detailMultiItemEntity1 = new DetailMultiItemEntity0();
        DetailMultiItemEntity0 detailMultiItemEntity2 = new DetailMultiItemEntity0();
        DetailMultiItemEntity0 detailMultiItemEntity3 = new DetailMultiItemEntity0();
        DetailMultiItemEntity1 detailMultiItemEntity11 = new DetailMultiItemEntity1();
        DetailMultiItemEntity1 detailMultiItemEntity12 = new DetailMultiItemEntity1();
        DetailMultiItemEntity1 detailMultiItemEntity13 = new DetailMultiItemEntity1();
        detailMultiItemEntity1.title = "测试第一层1";
        detailMultiItemEntity2.title = "测试第一层2";
        detailMultiItemEntity3.title = "测试第一层3";
        detailMultiItemEntity11.title = "测试第二层1";
        detailMultiItemEntity12.title = "测试第二层2";
        detailMultiItemEntity13.title = "测试第二层3";
        detailMultiItemEntity1.addSubItem(detailMultiItemEntity11);
        detailMultiItemEntity1.addSubItem(detailMultiItemEntity12);
        detailMultiItemEntity1.addSubItem(detailMultiItemEntity13);
        list.add(detailMultiItemEntity1);
        list.add(detailMultiItemEntity2);
        list.add(detailMultiItemEntity3);
        detailAdapter = new DetailAdapter(list);
        //设置 Footer 为 球脉冲 样式
        refreshLayout.setRefreshFooter(new BallPulseFooter(mContext).setSpinnerStyle(SpinnerStyle.Scale));
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                distanceY += dy;
                if (distanceY > ScreenUtil.dip2px(mContext, 20)) {
                    homeTitleBarLayout.setBackgroundColor(getResources().getColor(R.color.white));
                    if (Build.VERSION.SDK_INT > 10) {
                        homeTitleBarLayout.setAlpha(distanceY * 1.0f / ScreenUtil.dip2px(mContext, 100));
                    } else {
                        DISTANCE_WHEN_TO_SELECTED = 20;
                    }
                } else {
                    homeTitleBarLayout.setBackgroundColor(0);
                }

                if (distanceY > ScreenUtil.dip2px(mContext, DISTANCE_WHEN_TO_SELECTED) && !homeTitleBarLayout.isSelected()) {
                    homeTitleBarLayout.setSelected(true);
                } else if (distanceY <= ScreenUtil.dip2px(mContext, DISTANCE_WHEN_TO_SELECTED) && homeTitleBarLayout.isSelected()) {
                    homeTitleBarLayout.setSelected(false);
                }
            }
        });
        recyclerView.setAdapter(detailAdapter);

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
    public int getLayoutId() {
        return R.layout.activity_detail;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        unbinder = ButterKnife.bind(this);

    }

    @OnClick(R.id.home_title_bar_layout)
    public void onViewClicked() {
    }
}
