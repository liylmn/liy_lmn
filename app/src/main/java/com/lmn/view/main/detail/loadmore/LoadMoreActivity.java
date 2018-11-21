package com.lmn.view.main.detail.loadmore;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lmn.Entity.DetailMessageEntity;
import com.lmn.Entity.ImgsEntity;
import com.lmn.MainDataManager;
import com.lmn.R;
import com.lmn.view.main.detail.adapter.LoadmoreAdapter;
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
import cc.shinichi.library.ImagePreview;
import cc.shinichi.library.bean.ImageInfo;
import lmn.com.lmnlibrary.base.BaseActivity;
@Route(path = "/loadmore/activity")
public class LoadMoreActivity extends BaseActivity implements LoadMoreContract.View{


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    private ArrayList<String> teststrs;
    LoadmoreAdapter loadmoreAdapter;
    @Autowired
    DetailMessageEntity  detailMessageEntity;
    @Inject
    LoadMorePresenter loadMorePresenter;
    private int page = 1;
    List<ImageInfo> imageInfoList=new ArrayList<>();
    @Override
    public int getLayoutId() {
        return R.layout.activity_load_more;
    }

    @Override
    public void initview() {
        DaggerLoadMoreComponent
                .builder()
                .appComponent(getAppComponent())
                .loadMorPresenterModule(new LoadMorPresenterModule(MainDataManager.getInstance(mDataManager),this))
                .build()
                .inject(this);
        ARouter.getInstance().inject(this);
        teststrs=new ArrayList<String>();
//        for (int i = 0; i <detailMessageEntity.getData().getFault().getFaultImgs().size() ; i++) {
//            teststrs.add(detailMessageEntity.getData().getBasePath()+detailMessageEntity.getData().getFault().getFaultImgs().get(i).getImg());
//        }
        //设置 Footer 为 球脉冲 样式
        refreshLayout.setRefreshFooter(new BallPulseFooter(mContext).setSpinnerStyle(SpinnerStyle.Scale));
        loadmoreAdapter=new LoadmoreAdapter(R.layout.item_img);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(loadmoreAdapter);
    }

    @Override
    public void initData() {
        loadMorePresenter.setdate(detailMessageEntity.getData().getFault().getId()+"","1","10");
    }

    @Override
    public void setListener() {
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
                teststrs=new ArrayList<String>();
                imageInfoList=new ArrayList<>();
                loadMorePresenter.setdate(detailMessageEntity.getData().getFault().getId()+"","1","10");
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
                loadMorePresenter.setdate(detailMessageEntity.getData().getFault().getId()+"",page+"","10");
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        unbinder=ButterKnife.bind(this);
    }

    @Override
    public void getdata(ImgsEntity imgsEntity) {
        for (int i = 0; i < imgsEntity.getData().getPage().getList().size(); i++) {
            teststrs.add(imgsEntity.getData().getBasePath()+imgsEntity.getData().getPage().getList().get(i).getImg());
            ImageInfo imageInfo=new ImageInfo();
            imageInfo.setOriginUrl(imgsEntity.getData().getBasePath()+imgsEntity.getData().getPage().getList().get(i).getImg());
            imageInfo.setThumbnailUrl(imgsEntity.getData().getBasePath()+imgsEntity.getData().getPage().getList().get(i).getImg());
            imageInfoList.add(imageInfo);
        }
        loadmoreAdapter.setNewData(teststrs);
        loadmoreAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                ImagePreview
                        .getInstance()
                        .setContext(LoadMoreActivity.this)
                        .setIndex(0)
                        .setImageInfoList(imageInfoList)
                        .setShowDownButton(true)
                        .setLoadStrategy(ImagePreview.LoadStrategy.NetworkAuto)
                        .setFolderName("BigImageViewDownload")
                        .setScaleLevel(1, 3, 5)
                        .setZoomTransitionDuration(300)
                        .setShowCloseButton(true)
                        .setEnableDragClose(false)// 是否启用上拉/下拉关闭，默认不启用
                        .setEnableClickClose(true)// 是否启用点击图片关闭，默认启用
                        .start();
            }
        });
        if (page != imgsEntity.getData().getPage().getPages()) {
            page++;
        } else {
            refreshLayout.finishLoadMoreWithNoMoreData();
        }
    }

    @Override
    public void showProgressDialogView() {
    showProgressDialog("加载中");
    }

    @Override
    public void hiddenProgressDialogView() {
    hiddenProgressDialog();
    }
}
