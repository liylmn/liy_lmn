package com.lmn.view.resources;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.lmn.Entity.ResouceEntity;
import com.lmn.Entity.ResourcesMultiItemEntity0;
import com.lmn.Entity.ResourcesMultiItemEntity1;
import com.lmn.MainDataManager;
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

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import lmn.com.lmnlibrary.base.BaseFragment;

public class ResourcesFragment extends BaseFragment implements ResourcesFragmentContract.View {

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
    private List<MultiItemEntity> list = new ArrayList<>();
    private int page = 1;
    @Inject
    ResourcesFragmentPresenter resourcesFragmentPresenter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_resources;
    }

    public static ResourcesFragment newInstance() {
        return new ResourcesFragment();
    }

    @Override
    public void initview() {
    DaggerResourcesFragmentComponent
            .builder()
            .appComponent(getAppComponent())
            .resourcesFragmentPresenterModule(new ResourcesFragmentPresenterModule(MainDataManager.getInstance(mDataManager),this))
            .build()
            .inject(this);
        resourcesAdapter = new ResourcesAdapter(mActivity, list);
        //设置 Footer 为 球脉冲 样式
        refreshLayout.setRefreshFooter(new BallPulseFooter(mContext).setSpinnerStyle(SpinnerStyle.Scale));
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(resourcesAdapter);
    }

    @Override
    public void initData() {
    resourcesFragmentPresenter.setdate(page+"");
    }

    @Override
    public void setListener() {
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
                page = 1;
                list = new ArrayList<>();
                resourcesFragmentPresenter.setdate(page+"");
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
                resourcesFragmentPresenter.setdate(page+"");
            }
        });
        homeTitleBarLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/search/activity")
                        .withString("resultType","2")
                        .navigation();
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

    @Override
    public void getdata(ResouceEntity resouceEntity) {
        List<ResouceEntity.DataBean.PageBean.ListBean> listBeans = resouceEntity.getData().getPage().getList();
        for (int i = 0; i < listBeans.size(); i++) {
            ResourcesMultiItemEntity0 resourcesMultiItemEntity0 = new ResourcesMultiItemEntity0();
            resourcesMultiItemEntity0.title = (String) listBeans.get(i).getName();
            resourcesMultiItemEntity0.imgurl = (String) listBeans.get(i).getUrl();

            for (int j = 0; j < listBeans.get(i).getFaultResources().size(); j++) {
                ResourcesMultiItemEntity1 resourcesMultiItemEntity1 = new ResourcesMultiItemEntity1();
                resourcesMultiItemEntity1.title = listBeans.get(i).getFaultResources().get(j).getName();

                resourcesMultiItemEntity1.downloadfilename = (String) listBeans.get(i).getFaultResources().get(j).getType();
                resourcesMultiItemEntity1.baseurl = resouceEntity.getData().getBasePath();
                resourcesMultiItemEntity1.url = (String) listBeans.get(i).getFaultResources().get(j).getUrl();
//                resourcesMultiItemEntity1.imgurl = (String) listBeans.get(i).getFaultResources().get(j).get();

                resourcesMultiItemEntity0.addSubItem(resourcesMultiItemEntity1);
            }
            list.add(resourcesMultiItemEntity0);
        }
        resourcesAdapter.setNewData(list);
        if (page != resouceEntity.getData().getPage().getPages()) {
            page++;
        } else {
            refreshLayout.finishLoadMoreWithNoMoreData();
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

    @Override
    public void onDestroy() {
        super.onDestroy();
        resourcesFragmentPresenter.destory();
    }
}
