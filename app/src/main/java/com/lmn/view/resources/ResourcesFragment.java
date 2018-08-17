package com.lmn.view.resources;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.lmn.Entity.ResourcesMultiItemEntity0;
import com.lmn.Entity.ResourcesMultiItemEntity1;
import com.lmn.R;
import com.lmn.view.resources.adapter.ResourcesAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import lmn.com.lmnlibrary.base.BaseFragment;
import lmn.com.lmnlibrary.utils.ScreenUtil;

public class ResourcesFragment extends BaseFragment {

    @BindView(R.id.home_title_bar_layout)
    FrameLayout homeTitleBarLayout;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    private int distanceY;
    /**
     * 改变titlebar中icon颜色时的距离
     */
    private static int DISTANCE_WHEN_TO_SELECTED = 40;
    ResourcesAdapter resourcesAdapter;
    private List<MultiItemEntity> list=new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.fragment_resources;
    }

    public static ResourcesFragment newInstance() {
        return new ResourcesFragment();
    }

    @Override
    public void initview() {

    }

    @Override
    public void initData() {
        ResourcesMultiItemEntity0 ResourcesMultiItemEntity1 = new ResourcesMultiItemEntity0();
        ResourcesMultiItemEntity0 detailMultiItemEntity2 = new ResourcesMultiItemEntity0();
        ResourcesMultiItemEntity0 detailMultiItemEntity3 = new ResourcesMultiItemEntity0();
        ResourcesMultiItemEntity1 ResourcesMultiItemEntity11 = new ResourcesMultiItemEntity1();
        ResourcesMultiItemEntity1 ResourcesMultiItemEntity12 = new ResourcesMultiItemEntity1();
        ResourcesMultiItemEntity1 ResourcesMultiItemEntity13 = new ResourcesMultiItemEntity1();
        ResourcesMultiItemEntity1.title = "测试第一层1";
        detailMultiItemEntity2.title = "测试第一层2";
        detailMultiItemEntity3.title = "测试第一层3";
        ResourcesMultiItemEntity11.title = "测试第二层1";
        ResourcesMultiItemEntity12.title = "测试第二层2";
        ResourcesMultiItemEntity13.title = "测试第二层3";
        ResourcesMultiItemEntity1.addSubItem(ResourcesMultiItemEntity11);
        ResourcesMultiItemEntity1.addSubItem(ResourcesMultiItemEntity12);
        ResourcesMultiItemEntity1.addSubItem(ResourcesMultiItemEntity13);
        list.add(ResourcesMultiItemEntity1);
        list.add(detailMultiItemEntity2);
        list.add(detailMultiItemEntity3);
        resourcesAdapter = new ResourcesAdapter(list);
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
        recyclerView.setAdapter(resourcesAdapter);
    }

    @Override
    public void setListener() {
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
            }
        });
        homeTitleBarLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/search/activity").navigation();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
