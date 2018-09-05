package com.lmn.view.main.homefragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.alibaba.android.arouter.launcher.ARouter;
import com.lmn.Entity.HomeFragmentEntity;
import com.lmn.MainDataManager;
import com.lmn.R;
import com.lmn.view.main.adapter.MainhomeAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import lmn.com.lmnlibrary.base.BaseFragment;

public class MainHomeFragment extends BaseFragment implements HomeContract.View{

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @BindView(R.id.home_title_bar_layout)
    FrameLayout homeTitleBarBgView;
    MainhomeAdapter mainhomeAdapter;
    List<String> teststrs;
    private int distanceY;
    /**
     * 改变titlebar中icon颜色时的距离
     */
    private static int DISTANCE_WHEN_TO_SELECTED = 40;
    @Inject
    HomePresenter mPresenter;
    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    public static MainHomeFragment newInstance() {
        return new MainHomeFragment();
    }
    @Override
    public void initview() {
        DaggerHomeFragmentComponent.builder()
                .appComponent(getAppComponent())
                .homePresenterModule(new HomePresenterModule(this, MainDataManager.getInstance(mDataManager)))
                .build()
                .inject(this);
        refreshLayout.setRefreshFooter(new BallPulseFooter(mContext).setSpinnerStyle(SpinnerStyle.Scale));
        mainhomeAdapter=new MainhomeAdapter(R.layout.item_home);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(mainhomeAdapter);
    }

    @Override
    public void initData() {
        mPresenter.getHomeData();
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
        homeTitleBarBgView.setOnClickListener(new View.OnClickListener() {
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
    public void setHomeData(HomeFragmentEntity find) {
     mainhomeAdapter.setNewData(find.getData().getList());
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
