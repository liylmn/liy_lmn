package com.lmn.view.main.detail.loadmore;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.lmn.Entity.DetailMessageEntity;
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
@Route(path = "/loadmore/activity")
public class LoadMoreActivity extends BaseActivity {


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    private ArrayList<String> teststrs;
    LoadmoreAdapter loadmoreAdapter;
    @Autowired
    DetailMessageEntity  detailMessageEntity;
    @Override
    public int getLayoutId() {
        return R.layout.activity_load_more;
    }

    @Override
    public void initview() {
        ARouter.getInstance().inject(this);
        teststrs=new ArrayList<String>();
        for (int i = 0; i <detailMessageEntity.getData().getFault().getFaultImgs().size() ; i++) {
            teststrs.add(detailMessageEntity.getData().getBasePath()+detailMessageEntity.getData().getFault().getFaultImgs().get(i).getImg());
        }
        //设置 Footer 为 球脉冲 样式
        refreshLayout.setRefreshFooter(new BallPulseFooter(mContext).setSpinnerStyle(SpinnerStyle.Scale));
        loadmoreAdapter=new LoadmoreAdapter(R.layout.item_img,teststrs);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
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
