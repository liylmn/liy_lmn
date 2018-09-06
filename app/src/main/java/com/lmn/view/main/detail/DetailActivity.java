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
import com.lmn.Entity.DetailEntity;
import com.lmn.Entity.DetailMultiItemEntity0;
import com.lmn.Entity.DetailMultiItemEntity1;
import com.lmn.MainDataManager;
import com.lmn.R;
import com.lmn.view.main.detail.adapter.DetailAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lmn.com.lmnlibrary.base.BaseActivity;
import lmn.com.lmnlibrary.utils.ScreenUtil;

@Route(path = "/detail/activity")
public class DetailActivity extends BaseActivity implements DetailContract.View {


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
    @Autowired(name = "status")
    public String status;
    @Inject
    DetailPresenter detailPresenter;
    private int page = 1;

    @Override
    public void initview() {
        ARouter.getInstance().inject(this);//添加在onCreate（）
        toolbar_title_tv.setText(message);
        DaggerDetailComponent
                .builder()
                .appComponent(getAppComponent())
                .detailPresenterModule(new DetailPresenterModule(this, MainDataManager.getInstance(mDataManager)))
                .build()
                .inject(this);
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
    public void initData() {
    detailPresenter.setdate(status,page);
    }

    @Override
    public void setListener() {
        homeTitleBarLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/search/activity").navigation();
            }
        });
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
                page = 1;
                list = new ArrayList<>();
                detailPresenter.setdate(status, page);
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
                detailPresenter.setdate(status, page);
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
        ARouter.getInstance().build("/search/activity").navigation();
    }

    @Override
    public void getdata(DetailEntity detailEntity) {

        for (int i = 0; i < detailEntity.getData().getPage().getList().size(); i++) {
            DetailMultiItemEntity0 DetailMultiItemEntity0 = new DetailMultiItemEntity0();
            DetailMultiItemEntity0.title = detailEntity.getData().getPage().getList().get(i).getCategoryName();
            for (int j = 0; j < detailEntity.getData().getPage().getList().get(i).getSubFault().size(); j++) {
                DetailMultiItemEntity1 DetailMultiItemEntity1 = new DetailMultiItemEntity1();
                DetailMultiItemEntity1.title = detailEntity.getData().getPage().getList().get(i).getSubFault().get(j).getCategoryName();
                DetailMultiItemEntity1.id = detailEntity.getData().getPage().getList().get(i).getSubFault().get(j).getId();
                DetailMultiItemEntity0.addSubItem(DetailMultiItemEntity1);
            }
            list.add(DetailMultiItemEntity0);
        }
        detailAdapter.setNewData(list);
        if (page != detailEntity.getData().getPage().getPages()) {
            page++;
        } else {
            refreshLayout.finishLoadMoreWithNoMoreData();
        }
    }

    @Override
    public void showProgressDialogView() {
        showProgressDialog("数据请求中");
    }

    @Override
    public void hiddenProgressDialogView() {
        hiddenProgressDialog();
    }


}
