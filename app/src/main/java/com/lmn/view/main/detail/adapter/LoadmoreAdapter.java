package com.lmn.view.main.detail.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lmn.R;

import java.util.List;

import lmn.com.lmnlibrary.imageloader.ILoader;
import lmn.com.lmnlibrary.imageloader.ImageFactory;

/**
 * 作者：liy_lmn
 * 时间：2018/8/23:9:23
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */

public class LoadmoreAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public LoadmoreAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    public LoadmoreAdapter(@Nullable List<String> data) {
        super(data);
    }

    public LoadmoreAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
    ImageFactory.getLoader().loadNet((ImageView) helper.getView(R.id.img),item,new ILoader.Options(R.drawable.loading_img,R.drawable.error_img));
    }
}
