package com.lmn.view.main.adapter;

import android.support.annotation.Nullable;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lmn.Entity.HomeFragmentEntity;
import com.lmn.R;

import java.util.List;


/**
 * 作者：liy_lmn
 * 时间：2018/8/12:20:28
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */

public class MainhomeAdapter extends BaseQuickAdapter<HomeFragmentEntity.DataBean.ListBean,BaseViewHolder>{
    public MainhomeAdapter(int layoutResId, @Nullable List data) {
        super(layoutResId, data);
    }

    public MainhomeAdapter(@Nullable List data) {
        super(data);
    }

    public MainhomeAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, final HomeFragmentEntity.DataBean.ListBean item) {
     helper.setText(R.id.tv_type,item.getName());
     helper.getView(R.id.al_message).setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             ARouter.getInstance().build("/detail/activity")
                     .withString("message", item.getName())
                     .withString("status", item.getStatus()+"")
                     .navigation();
         }
     });
    }

}
