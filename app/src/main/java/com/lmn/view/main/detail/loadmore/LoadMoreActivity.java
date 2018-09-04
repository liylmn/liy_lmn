package com.lmn.view.main.detail.loadmore;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lmn.R;
import com.lmn.view.main.detail.adapter.LoadmoreAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import lmn.com.lmnlibrary.base.BaseActivity;

public class LoadMoreActivity extends BaseActivity {


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    private ArrayList<String> teststrs;
    LoadmoreAdapter loadmoreAdapter;
    @Override
    public int getLayoutId() {
        return R.layout.activity_load_more;
    }

    @Override
    public void initview() {
        teststrs=new ArrayList<String>();
        for (int i = 0; i <20 ; i++) {
            teststrs.add("测试数据"+i);
        }
        //设置 Footer 为 球脉冲 样式
        refreshLayout.setRefreshFooter(new BallPulseFooter(mContext).setSpinnerStyle(SpinnerStyle.Scale));
        loadmoreAdapter=new LoadmoreAdapter(R.layout.item_home,teststrs);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
//        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//                distanceY += dy;
//                if (distanceY > ScreenUtil.dip2px(mActivity, 20)) {
//                    homeTitleBarBgView.setBackgroundColor(getResources().getColor(R.color.white));
//                    if (Build.VERSION.SDK_INT > 10) {
//                        homeTitleBarBgView.setAlpha(distanceY * 1.0f / ScreenUtil.dip2px(mActivity, 100));
//                    }
//                    else {
//                        DISTANCE_WHEN_TO_SELECTED = 20;
//                    }
//                }
//                else {
//                    homeTitleBarBgView.setBackgroundColor(0);
//                }
//
//                if (distanceY > ScreenUtil.dip2px(mActivity, DISTANCE_WHEN_TO_SELECTED) && !homeTitleBarBgView.isSelected()) {
//                    homeTitleBarBgView.setSelected(true);
//                }
//                else if (distanceY <= ScreenUtil.dip2px(mActivity, DISTANCE_WHEN_TO_SELECTED) && homeTitleBarBgView.isSelected()) {
//                    homeTitleBarBgView.setSelected(false);
//                }
//            }
//        });
        recyclerView.setAdapter(loadmoreAdapter);
    }

    @Override
    public void initData() {

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
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        unbinder=ButterKnife.bind(this);
    }
}
